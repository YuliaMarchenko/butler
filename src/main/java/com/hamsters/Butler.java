package com.hamsters;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.IOException;
import java.util.List;

public class Butler implements UpdatesListener{
    private TelegramBot bot;
    private Jokes jokes;

    public Butler() throws IOException {
        this.bot = new TelegramBot(System.getenv("BUTLER_TELEGRAM_TOKEN"));
        this.jokes = new Jokes();
        bot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> list) {
        for(Update update: list){
            long chatId = update.message().chat().id();
            SendResponse response = bot.execute(new SendMessage(chatId, this.jokes.getRandomJoke()));
            System.out.println(response.message());
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
