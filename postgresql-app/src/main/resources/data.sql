INSERT INTO Fruit (id, name, quantity) VALUES ('d37f4fae-b572-47b3-93e0-17daf798f9d5', 'Banana', '0') ON CONFLICT (ID) DO NOTHING;
INSERT INTO Fruit (id, name, quantity) VALUES ('51661376-0a07-449b-a3bd-9db79cd4ead4', 'Apple', '0') ON CONFLICT (ID) DO NOTHING;
INSERT INTO Fruit (id, name, quantity) VALUES ('69f6cd81-59fc-493b-8ebf-1b9f150ecead', 'Blueberry','0') ON CONFLICT (ID) DO NOTHING;