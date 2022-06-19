package ex10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MagicSquareApp extends Application {

	public static String gakuban = "20EC070"; // 学籍番号を入力すること
	public static String yourname = "高矢空"; // 氏名を入力すること

	// 問題の定義
	String[] tasks = { "81635-492", "-7215-8-4", "-3-9-1-7-", "2------1-","---------","8341--672","22--2222-"};
	int[] ans = new int[9];

	Button[] btn;
	GridPane gp;
	ComboBox<String> cbox;
	Label lb;
	HBox hb1, hb2;
	VBox vb1, vb2;

	@Override
	public void start(Stage primaryStage) {
		reset();
		comboBoxLayout();
		buttonLayout();

		vb2 = new VBox(10, hb1, hb2);
		vb2.setPadding(new Insets(10));
		vb2.setAlignment(Pos.CENTER);

		primaryStage.setScene(new Scene(vb2));
		primaryStage.setTitle("MagicSquareApp");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	// 選択リスト設定
	public void comboBoxLayout() {
		lb = new Label("問題選択");
		lb.setFont(new Font(13));
		lb.setAlignment(Pos.CENTER_LEFT);

		cbox = new ComboBox<>();
		cbox.getItems().addAll(tasks);
		cbox.setOnAction(e -> showTasks());

		hb1 = new HBox(10, lb, cbox);
		hb1.setAlignment(Pos.CENTER_LEFT);
	}

	// デフォルトのボタン設定
	public void buttonLayout() {
		
		Button ResetBtn = new Button("Reset");
		ResetBtn.setOnAction(e -> showTasks());
		ResetBtn.setPrefSize(100, 25);
		ResetBtn.setFont(new Font(15));
		
		Button CheckBtn = new Button("Check");
		CheckBtn.setOnAction(e -> checkBtnClicked());
		CheckBtn.setPrefSize(100, 25);
		CheckBtn.setFont(new Font(15));
		
		vb1 = new VBox(30, CheckBtn, ResetBtn);
		vb1.setAlignment(Pos.CENTER);
		
		btn = new Button[9];
		gp = new GridPane();
		for (int i = 0; i < 9; i++) {
			btn[i] = new Button();
			btn[i].setPrefSize(50., 50.);
			btn[i].setFont(new Font(20));
			gp.add(btn[i], i % 3, 1 + i / 3);
		}
		gp.setHgap(5);
		gp.setVgap(5);
		
		hb2 = new HBox(15, gp, vb1);
	}

	// 問題の表示
	public void showTasks() {
		try {
			reset();
			char[] task = getTask();
			for (int i = 0; i < 9; i++) {
				int index = i;
				if (task[i] != '-') {
					btn[i].setText(String.valueOf(task[i]));
					btn[i].setTextFill(Color.BLACK);
					btn[i].setOnAction(null);
				} else {
					btn[i].setText(null);
					btn[i].setTextFill(Color.BLUE);
					btn[i].setOnAction(e -> {
						btn[index].setText(String.valueOf(ansToggle(index)));
					});
				}
			}
		} catch (Exception e) {
		}
	}

	// 問題の取得
	public char[] getTask() {
		char[] task = new char[9];
		int index = getTaskIndex();
		for (int i = 0; i < 9; i++)task[i] = tasks[index].charAt(i);
		return task;
	}

	// 問題のインデックス取得
	public int getTaskIndex() {
		int i = 0;
		for (; i < tasks.length; i++)if (tasks[i].equals(cbox.getValue()))break;
		return i;
	}

	// 解答を9以上にならないようにインクリメント
	public int ansToggle(int index) {
		int tmp = ans[index];
		if (ans[index] < 9)ans[index]++;else ans[index] = 1;
		return tmp;
	}

	// Checkボタンのイベント
	public void checkBtnClicked() {
		try {
			boolean flag = answerCheck();
			if (flag) {
				for (int i = 0; i < 9; i++)btn[i].setOnAction(null);
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Check");
				alert.setHeaderText("正解です！");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Check");
				alert.setHeaderText("不正解です");
				alert.showAndWait();
			}
		} catch (Exception e) {
		}
	}

	// 解答のチェック
	public boolean answerCheck() {
		boolean flag = true;
		int[][] check = getAnsArray();
		int tmp = 0;
		// 行の判定
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)tmp += check[j][i];
			if (tmp != 15)flag = false;
			tmp = 0;
		}
				
		//   列の判定
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)tmp += check[i][j];
			if (tmp != 15)
				flag = false;
			tmp = 0;
		}
		
		// 斜めの判定
		if ((check[0][0] + check[1][1] + check[2][2]) != 15)flag = false;
		if ((check[0][2] + check[1][1] + check[2][0]) != 15)flag = false;

		return flag;
	}

	// 解答を二次元配列へ格納
	public int[][] getAnsArray() {
		int[][] check = new int[3][3];
		String tmpstr;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tmpstr = btn[3 * i + j].getText();
				if (tmpstr != null)check[i][j] = Integer.parseInt(tmpstr);else check[i][j] = 0;
			}
		}
		return check;
	}

	// 解答のリセット
	public void reset() {
		for (int i = 0; i < 9; i++)ans[i] = 1;
	}

	public static void main(String[] args) {
		// アプリケーションを起動する
		Application.launch(args);
		System.out.println("完了--MagicSquareApp");
	}
	
}
/* 考察 -- 調査したこと、工夫したこと、確認したことを記述
この講義の名称がオブジェクト指向であるように、しっかりとオブジェクト指向を心がけて関数を使用したりした。
また、ユーザーの成否によってメッセージで出るアラートの種類を変更したりした。
また、そのアラートの受け取り方にも関数を使用している。
成否を判定する関数に成否判定させ、回答をboolean型に入れて戻り値とした。
そのあとはそのままif分に用いることができた。この便利な使い方を初めてした。
また、判定では、魔法人の斜め以外は２重ループで考えるのが地味に難しかった。
また、問題のタスクを地震で追加して、デバッグのタスクを増やした。
すべて---------にしても正解はしっかりでた。
また、何も回答していない状態でも判定ができるようになっている。
さらにほかのテストケースも試し、自分の意図した動きをしていることがわかった
 */