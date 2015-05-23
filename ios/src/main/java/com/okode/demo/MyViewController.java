package com.okode.demo;

import org.robovm.apple.foundation.NSSet;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UITextFieldDelegateAdapter;
import org.robovm.apple.uikit.UITouch;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
    private UITextField textField;
    private UILabel label;
    private String string;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        textField.setDelegate(new UITextFieldDelegateAdapter() {
            @Override
            public boolean shouldReturn(UITextField textField) {
                // When the user presses return, take focus away from the text
                // field so that the keyboard is dismissed.
                textField.resignFirstResponder();
                // Invoke the method that changes the greeting.
                updateString();

                return true;
            }
        });

        // When the view first loads, display the placeholder text that's in the
        // text field in the label.
        label.setText(textField.getPlaceholder());
    }

    private void updateString() {
        // Store the text of the text field in the 'string' instance variable.
        string = textField.getText();
        // Set the text of the label to the value of the 'string' instance
        // variable.
        label.setText(string);
    }

    @Override
    public void touchesBegan(NSSet<UITouch> touches, UIEvent event) {
        // Dismiss the keyboard when the view outside the text field is touched.
        textField.resignFirstResponder();
        // Revert the text field to the previous value.
        textField.setText(string + "colega");
        super.touchesBegan(touches, event);
    }

    @IBOutlet
    public void setTextField(UITextField textField) {
        this.textField = textField;
    }

    @IBOutlet
    public void setLabel(UILabel label) {
        this.label = label;
    }
}
