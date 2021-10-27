package seedu.address.ui;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import seedu.address.logic.Logic;

public class UserInfo extends UiPart<Region> {
    private static final String FXML = "UserInfo.fxml";

    @FXML
    private HBox mainContainer;

    @FXML
    private VBox leftHeader;

    @FXML
    private VBox totalContactsContainer;

    @FXML
    private VBox daysTillWeddingContainer;

    /**
     * Creates an UserInfo object
     */
    public UserInfo(Logic logic) {
        super(FXML);

        Text userName = new Text("Good day to you too!");
        userName.setStyle("-fx-font-weight: bold");
        userName.setFont(Font.font(40));
        userName.setFill(Color.color(1, 1, 1));

        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        Text dateText = new Text(date);
        dateText.setFont(Font.font(15));
        dateText.setFill(Color.color(0, 0.5, 1));

        leftHeader.setBackground(new Background(
                new BackgroundFill(Color.web("#383838"), CornerRadii.EMPTY, Insets.EMPTY)));

        leftHeader.getChildren().addAll(userName, dateText);
        leftHeader.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0.5))));

        // Assume dummy variables
        int contacts = logic.size();
        int noOfdates = (int) LocalDate.now().until(logic.getCountdown().getDate(), ChronoUnit.DAYS);

        ModelInfo totalContacts = new ModelInfo(contacts, "People in-charge");
        totalContactsContainer.getChildren().add(totalContacts.getRoot());

        ModelInfo datesToWedding = new ModelInfo(noOfdates,
               "Days before Wedding day");
        daysTillWeddingContainer.getChildren().add(datesToWedding.getRoot());
    }

}