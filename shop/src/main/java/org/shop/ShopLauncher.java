package org.shop;

import org.shop.config.ShopConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfig.class);
        DataInitializer dataInitializer = context.getBean( "dataInitializer", DataInitializer.class );
        dataInitializer.initData();
    }
}
