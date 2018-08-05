package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    public StackPane exit;
    public StackPane minimize;
    public Pane SignInMenu;
    public Pane SingUpMenu;
    public Pane AdminMenu;
    public TextField username;
    public PasswordField password;

    private Transitions transitions;
    private InnerShadow ButtonEnterEffect;
    private InnerShadow ButtonDefaultEffect;

    Controller(){
        ButtonDefaultEffect = new InnerShadow(10.0, Color.rgb(102,102,102,1));
        ButtonEnterEffect = new InnerShadow(10.0, Color.rgb(49,49,49,1));
        transitions = new Transitions();
    }

    public void SignIn(){
        if(username.getText().equals("admin") && password.getText().equals("admin")){
            transitions.TransiteWithEffect(SignInMenu,AdminMenu,200);
        }
        else{
            transitions.TransiteWithEffect(SignInMenu,AdminMenu,200);
        }
    }

    public void SignUp(){
        transitions.TransiteWithEffect(SignInMenu,SingUpMenu,200);
    }
    public void SignUpBack(){
        transitions.TransiteWithEffect(SingUpMenu,SignInMenu,200);
    }

    public void SignOutAdmin(){
        transitions.TransiteWithEffect(AdminMenu,SignInMenu,200);
    }


    public void ButtonEnterEffect(Event event){
        Node node = (Node)event.getSource();
        node.setEffect(ButtonEnterEffect);
    }

    public void ButtonLeaveEffect(Event event){
        Node node = (Node)event.getSource();
        node.setEffect(ButtonDefaultEffect);
    }

}
