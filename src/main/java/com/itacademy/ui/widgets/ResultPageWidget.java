package com.itacademy.ui.widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ResultPageWidget {
    private final SelenideElement titleField;
    private final SelenideElement descriptionField;
    private final SelenideElement itemPriceField;

    public ResultPageWidget(SelenideElement root) {
        titleField = root.find(By.xpath(".//div[@class='product__title']"));
        descriptionField = root.find(By.xpath(".//a[@class='product__description']"));
        itemPriceField = root.find(By.xpath(".//div[@class='product__price']"));
    }
    public String getTitleText() {
        titleField.should(Condition.visible);
        return titleField.getText();
    }

    public String getDescription() {
        descriptionField.should(Condition.visible);
        return descriptionField.getText();
    }

    public String getPrice() {
        itemPriceField.should(Condition.visible);
        return itemPriceField.getText();
    }
}
