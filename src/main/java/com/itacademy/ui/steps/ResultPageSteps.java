package com.itacademy.ui.steps;

import com.codeborne.selenide.Condition;
import com.itacademy.ui.pages.ResultPage;

public class ResultPageSteps extends ResultPage {
    public ItemsDetailsPageSteps chooseItem() {
        itemTitle.should(Condition.visible).click();
        return new ItemsDetailsPageSteps();
    }
}
