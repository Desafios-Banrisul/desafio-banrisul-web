package utilitarios;

import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class EsperaFixa {

    public static void esperaEmSegundos(int timeout){
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(timeout));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
