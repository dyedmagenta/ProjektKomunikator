<p>Testowanie to bardzo szerokie pojęcie jak chodzi o testowanie oprogramowania.
<br>Poniżej wymienione argumenty są ogólne i nie tyczą się jednego sposobu testowania jak np unittesty.
</p>
<p>
	<ol>
		<li>
			Testowanie oprogramowania w trakcie jego tworzenia pozwala na wykrywanie i eliminację błędów.
		</li>
		<li>
			Może redukować koszty i czas tworzenia oprogramowania. Lepiej testować równolegle (metodologia Agile) z tworzeniem oprogramowania niż naprawiać błędy na sam koniec co może wiązać się z dużymi zmianami w kodzie co oznacza wzrost kosztów.
		</li>
		<li>
			Szybko wykryte błędy łatwiej i szybciej naprawić co wiąże się z niższymi kosztami produkcji. Również programista lepiej pracuje przy świeżym kodzie niż przy takim co napisał miesiące wcześniej.
		</li>
		<li>
			Do klienta trafia lepszy produkt, ponieważ nawet podstawowe testy (Sanity/Smoke) mogą wykryć czy podstawowe funkcje produktu
			w ogóle działają.
		</li>
		<li>
			Test Driven Develpoement (TDD) To pisanie Unit testów przed pisaniem kodu. Najpierw piszemy test a potem dopiero kod.
		</li>
		<li>
			Wymaga spójnego pisania kodu, modularności co wpływa na jakość pisanego kodu.
		</li>
		<li>
			Kiedy ktoś modyfikuje kod np metodę to sam program może dalej działać lecz odpalenie unit testu może pokazać	że ktoś źle zmodyfikował metodę co nie wprowadza nowych błędów do kodu.
		</li>
		<li>
			Unit testy mogą być formą dokumentacji, kiedy widzimy co dana metoda ma zwracać, w jakim zakresie itd. Przez co kod jest tym bardziej czytelny i wiemy co ma robić.
		</li>
		<li>
			Tworzy bazę danych testów wstecz (Regresion testy) co pozwala w nowych buildach oprogramowania ponieważ	odpalamy wtedy wszystkie testy i widzimy, czy oprogramowanie działa zgodnie z założonymi testami. 
		</li>
		<li>
			Unit testy również mogą być formą raportu. Kiedy pokryjemy kod testami i wysypuje testy pomniejszych funkcji nie musi to oznaczać że nie można wydać tego buildu ale wiadomo również co należy naprawiać i można ustalić priorytety i plan działania dla działu developerów
		</li>
		<li>
			Projekt manager widzi dość efektywny postęp zepsołu developerskiego. To, że dodawane są nowe funkcje to oprogramowania nie znaczy, że one działają jak należy co jest złym wskaźnikiem na postęp projektu. Dobrze napisane testy mogą lepiej odzwierciedlić postęp developerów i ich efektywność pracy.		
		</li>
		<li>
			Stress Test to test przeciążenia np servera. Testowana jest ile osób będzie w stanie się połączyć się z serwerem co jest krytyczne w dzisiejszych czasach. Opóźnienia wczytywania stron nawet kilku sekundowe są irytujące i mogą decydować	o tym czy produkt odniesie sukces czy też nie.		
		</li>
		<li>
			Argument powyżej również tyczy się sprzedaży produktu. Mamy przed klientem dowód dlaczego warto np kupić nasz produkt wykazując, że może on obsłużyć tyle i tyle klientów dzięku przeprowadzonemu testowi.
		</li>
		<li>
			Testy mogą być certyfikowane co oznacza, że produkt spełnia pewne normy co również działa na korzyść sprzedawanego produktu
		</li>
		<li>
			Godzina pracy testera jest tańsza niż programisty. Kiedy chcemy aby nasz programista testował nawet podstawowe funkcje to marnuje czas kiedy mógł np naprawiać te błędy, które wcześniej wykrył tester. 
		</li>
		<li>
			Zwiększa pewność siebie osób sprzedających ponieważ wiedzą oni, że ich produkt został przetestowany.
		</li>
		<li>
			Testy użytkowe. Oprogramowanie jest testowane pod względem łatowści obsługi produktu i nawigacji po nim. Napisany działający program nie musi być przyjazny dla użytkownika co może również wpłynąć na porażkę produktu. 
		</li>
		<li>
			Usługi internetowe są poddawane testom penetracyjnym. Zapewnia to bezpieczeństwo naszego produktu i że nie jest on podatny na ataki ze stron hackerów.
		</li>
		<li>
			Alpha testy pozwalają na dostarczenie produktu do realnego klienta i rzeczywisty feedback od niego. Nie zawsze tester będzie widział produkt w ten sam sposób jak klient.
		</li>
		<li>
			Odpowiednio zaplanowane testowanie generalnie zmniejsza koszt produkcji i przynosi zyski
		</li>
	</ol>
</p>