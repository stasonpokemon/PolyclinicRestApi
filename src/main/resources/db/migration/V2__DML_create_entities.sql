INSERT INTO doctors(id, first_name, patronymic, last_name, gender, position, phone_number, created_at, updated_at)
VALUES ('011ebe9c-ced6-11ed-a81c-0242ac140002', 'Ivan', 'Ivanov', 'Ivanovich', 0, 'Dentist', '+375292934566', now(),
        now()),
       ('c2dc3f28-c401-4cb0-8ce6-9501fb82e166', 'Irina', 'Ivanova', 'Ivanovna', 1, 'Dentist', '+375291442221', now(),
        now()),
       ('d1c48c1e-99b4-41b5-8e50-1235ce728aaf', 'Ivan', 'Petrov', 'Petrovich', 0, 'Surgeon', '+375294322124', now(),
        now()),
       ('240184de-710e-4603-ac86-c150cca7b84b', 'Sergei', 'Zubov', 'Victorovich', 0, 'Therapist', '+375291234421',
        now(),
        now());

INSERT INTO patients(id, first_name, patronymic, last_name, gender, age, address, phone_number, created_at, updated_at)
VALUES ('d99e82f1-8bec-4961-b542-ce95ae1a287a', 'Vitalii', 'Tereh', 'Sergeevich', 0, 25, 'Vitebsk', '+375294322355',
        now(),
        now()),
       ('940a67c2-32e1-40f4-b9e6-ebb557a9391c', 'Ekaterina', 'Naumova', 'Victorovna', 1, 34, 'Vitebsk', '+375297783433',
        now(),
        now()),
       ('32d0f45b-5927-48b9-bdb7-faf9fef4463e', 'Grigoriy', 'Petrov', 'Ivanovich', 0, 44, 'Vitebsk', '+375291242233',
        now(),
        now()),
       ('ba39515d-0da5-4af9-a398-f5637777608d', 'Sergei', 'Evmenov', 'Vitalievich', 0, 32, 'Vitebsk', '+375299083322',
        now(),
        now());

INSERT INTO tickets(id, doctor_id, patient_id, date_Of_Receipt, ticket_number, created_at, updated_at)
VALUES ('6f93489f-6bdc-47ba-a04c-6cc47fb1533a', '011ebe9c-ced6-11ed-a81c-0242ac140002',
        'd99e82f1-8bec-4961-b542-ce95ae1a287a', '2023-07-12', '1233', now(), now()),
       ('8c091ab8-ed54-4b64-9931-cf9fcb1081d5', 'c2dc3f28-c401-4cb0-8ce6-9501fb82e166',
        '940a67c2-32e1-40f4-b9e6-ebb557a9391c', '2023-07-22', '2155', now(), now()),
       ('a61bf792-7646-4811-ba55-40a706f81094', 'd1c48c1e-99b4-41b5-8e50-1235ce728aaf',
        '32d0f45b-5927-48b9-bdb7-faf9fef4463e', '2023-07-24', '4214', now(), now()),
       ('695fedf4-bd75-4b38-bfcc-5f498b333028', '240184de-710e-4603-ac86-c150cca7b84b',
        'ba39515d-0da5-4af9-a398-f5637777608d', '2023-07-25', '3411', now(), now());

