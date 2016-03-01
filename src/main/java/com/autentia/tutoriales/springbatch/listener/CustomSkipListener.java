package com.autentia.tutoriales.springbatch.listener;

import org.springframework.batch.core.SkipListener;
import org.springframework.batch.item.file.FlatFileParseException;

public class CustomSkipListener implements SkipListener<Object, Object> {

    @Override
    public void onSkipInRead(Throwable t) {
        StringBuilder message = new StringBuilder("ERROR en LECTURA: ");

        if (t instanceof FlatFileParseException) {
            message.append("Linea ")
                    .append(((FlatFileParseException)t).getLineNumber())
                    .append(": Error de formato para la siguiente entrada: ")
                    .append(((FlatFileParseException)t).getInput());
        } else {
            message.append(t.getMessage());
        }
        
        System.out.println(message.toString());
    }

    @Override
    public void onSkipInWrite(Object item, Throwable t) {
        StringBuilder message = new StringBuilder("ERROR en ESCRITURA: ").append(t.getMessage());
        
        System.out.println(message.toString());

    }

    @Override
    public void onSkipInProcess(Object item, Throwable t) {
        StringBuilder message = new StringBuilder("ERROR en PROCESADO: ").append(t.getMessage());
        
        System.out.println(message.toString());
    }
}
