###################################################
#                    VARIABLES                    #
###################################################

CLASSES_DIR=cd classes
SRC_DIR=cd src
REMOVE=rm -rf
JAR= jar cvfm
DOCS_DIR= cd docs
NBRE_COMP=""
NBRE_POULES=""
ALL_TESTS= test/Competition/*.java \
           test/competitor/*.java \
           test/match/*.java \
           test/rule/*.java \
           test/speakers/*.java

JUNIT_JAR=jar/junit.jar


###################################################
#             COMPILATION DES CLASSES             #
###################################################

cls:
	@$(SRC_DIR) && javac */*.java -d ../classes

LeagueMain: cls
	
TournamentMain: cls

MasterMain: cls


###################################################
#             COMPILATION DES TESTS               #
###################################################

test: cls
	@cat "compiling tests..."
	@javac -d classes -cp classes:$(JUNIT_JAR) $(ALL_TESTS)




###################################################
#               EXECUTION DES TESTS               #
###################################################

run_tests: tests
	@java -jar $(JUNIT_JAR) --class-path classes --scan-class-path
    


###################################################
#                EXECUTION DES JEU                # 
###################################################

playLeagueGame: LeagueMain 
	@cat assets/loading
	$(CLASSES_DIR) && java Main.LeagueMain $(NBRE_COMP)
	
playTournamentGame: TournamentMain
	@cat assets/loading
	$(CLASSES_DIR) && java Main.TournamentMain $(NBRE_COMP)
	
playMasterGame: MasterMain
	@cat assets/loading
	$(CLASSES_DIR) && java Main.MasterMain $(NBRE_COMP) $(NBRE_POULES)


###################################################
#                  DOCUMENTATION                  #
###################################################
	
docs:
	@cat assets/loading
	@$(SRC_DIR) && javadoc  */*.java -d ../docs 
	
view-docs:
	xdg-open docs/index.html


###################################################
#                CREATION DES JAR                 #
###################################################
	
league.jar: LeagueMain 
	@cat assets/loading
	@$(CLASSES_DIR) && $(JAR) ../jar/$@ ../jar/manifest-MainLeague * >> /dev/null
	
tournament.jar: TournamentMain 
	@cat assets/loading
	@$(CLASSES_DIR) && $(JAR) ../jar/$@ ../jar/manifest-MainTournament * >> /dev/null
	
master.jar: MasterMain
	@cat assets/loading
	@$(CLASSES_DIR) && $(JAR) ../jar/$@ ../jar/manifest-MainMaster * >> /dev/null



###################################################

clean:
	@echo "cleaning..."
	@cat assets/loading
	@$(CLASSES_DIR) && $(REMOVE) */*.class
	@$(DOCS_DIR) && $(REMOVE) *
	@cat assets/cleaned

.PHONY:	clean docs cls



#AUTHORS : BARRY Alpha Oumar, Yao-Isidore Amevigbe
