package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	

	    // 1. 最初にページを開いたとき（GETリクエスト）
	    @GetMapping("/counter")
	    public String showCounter(HttpSession session, Model model) {
	        // セッションから現在のカウントを取得（最初はnull）
	        Integer count = (Integer) session.getAttribute("count");
	        
	        // まだカウントがなければ 0 で初期化
	        if (count == null) {
	            count = 0;
	            session.setAttribute("count", count);
	        }
	        
	        // 画面（HTML）に値を渡す
	        model.addAttribute("currentCount", count);
	        return "counter";
	    }

	    // 2. カウントアップボタンが押されたとき（POSTリクエスト）
	    @PostMapping("/counter/add")
	    public String addCount(HttpSession session) {
	        Integer count = (Integer) session.getAttribute("count");
	        if (count == null) {
	            count = 0;
	        }
	        
	        // 数を1増やすしてセッションに保存
	        session.setAttribute("count", count + 1);
	        
	        // GETのURL（/counter）にリダイレクトして再表示
	        return "redirect:/counter";
	    }

	    // 3. リセットボタンが押されたとき
	    @PostMapping("/counter/reset")
	    public String resetCount(HttpSession session) {
	        // カウントを 0 に戻す
	        session.setAttribute("count", 0);
	        return "redirect:/counter";
	    }
	    
	    // 4. カウントダウンボタンが押されたとき（POSTリクエスト）★追加
	    @PostMapping("/counter/sub")
	    public String subCount(HttpSession session) {
	        Integer count = (Integer) session.getAttribute("count");
	        if (count == null) {
	            count = 0;
	        }
	        
	        // 数を1減らしてセッションに保存
	        session.setAttribute("count", count - 1);
	        
	        // GETのURL（/counter）にリダイレクトして再表示
	        return "redirect:/counter";
	    }

	


}
