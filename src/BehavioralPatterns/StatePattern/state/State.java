package BehavioralPatterns.StatePattern.state;

import BehavioralPatterns.StatePattern.models.Item;
import BehavioralPatterns.StatePattern.models.Money;
import BehavioralPatterns.StatePattern.models.VendingMachine;

import java.util.List;

public interface State {

    void onProductSelectionClick(VendingMachine vendingMachine) throws Exception;

    void onProductConfirmationClick(VendingMachine vendingMachine, int code) throws Exception;

    void onPaymentInititation(VendingMachine vendingMachine) throws Exception;

    void onDispense(VendingMachine vendingMachine) throws Exception;

    void onCancelTransaction(VendingMachine vendingMachine, int cost) throws Exception;

    List<Money> refundMoney(VendingMachine vendingMachine, int cost) throws Exception;

}
