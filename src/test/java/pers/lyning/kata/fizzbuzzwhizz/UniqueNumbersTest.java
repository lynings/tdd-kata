package pers.lyning.kata.fizzbuzzwhizz;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UniqueNumbersTest {

    @org.junit.Rule
    public final ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void validate() {
    }

    /********* validate test start *********/
    @Test
    public void should_success_when_three_numbers_are_entered_correctly() throws Exception {
        UniqueNumbers uniqueNumbers = new UniqueNumbers(1, 2, 3);
        uniqueNumbers.validate();
    }

    @Test
    public void should_fail_when_given_2_and_7_were_entered() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("请输入三个不同的个位数字！");

        UniqueNumbers uniqueNumbers = new UniqueNumbers(2, 7, null);
        uniqueNumbers.validate();
    }

    @Test
    public void should_fail_when_contain_numbers_less_than_1() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("数字不能小于1或大于9！");

        UniqueNumbers uniqueNumbers = new UniqueNumbers(0, 3, 7);
        uniqueNumbers.validate();
    }

    @Test
    public void should_fail_when_contain_numbers_greater_than_9() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("数字不能小于1或大于9！");

        UniqueNumbers uniqueNumbers = new UniqueNumbers(1, 3, 10);
        uniqueNumbers.validate();
    }
    /********* validate test start *********/
}