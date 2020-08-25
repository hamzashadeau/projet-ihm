package com.example.stock.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.example.stock.AgenceDeVoyageApplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class MyJavaFXApp extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        ApplicationContextInitializer<GenericApplicationContext> initializer =
                context -> {
                    context.registerBean(Application.class, () -> MyJavaFXApp.this);
                    context.registerBean(Parameters.class, this::getParameters); 
                };
        this.context = new SpringApplicationBuilder()
                .sources(AgenceDeVoyageApplication.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        context.publishEvent(new StageReadyEvent(primaryStage));
    }

    @Override
    public void stop() throws Exception {
        this.context.close();
        Platform.exit();
    }
}
