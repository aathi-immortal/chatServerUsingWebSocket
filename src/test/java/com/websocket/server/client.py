import websocket
import threading

out_semaphore = threading.Semaphore(1)


def on_message(ws, message):
    print(f"message: {message}")


def on_close(ws, code, message):
    print("websocket is closed")


def on_open(ws):
    def run():
        while (True):
            print("enter the message")
            message = input()
            ws.send(message)
    threading.Thread(target=run).start()


buit_in_print = print


def synchro(text):
    out_semaphore.acquire()
    try:
        buit_in_print(text)
    finally:
        out_semaphore.release()


print = synchro
websocket.enableTrace(True)
ws = websocket.WebSocketApp("https://chatserver123.azurewebsites.net/chat",
                            on_message=on_message, on_open=on_open, on_close=on_close)
ws.run_forever()
