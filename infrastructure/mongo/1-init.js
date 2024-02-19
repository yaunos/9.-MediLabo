db = db.getSiblingDB('preventDiabets');
db.createCollection('doctorsNotes');
db.doctorsNotes.insertMany(
    [{
        "patId": 1,
        "patient": "TestNone",
        "note": "Le patient déclare qu'il 'se sent très bien'. Poids égal ou inférieur au poids recommandé",
        "date": new Date("2022-01-01T10:14:35.871Z")
    },
        {
            "patId": 2,
            "patient": "TestBorderline",
            "note": "Le patient déclare qu'il ressent beaucoup de stress au travail. Il se plaint également que son audition est anormale dernièrement ",
            "date": new Date("2022-01-04T10:14:35.871Z")
        },
        {
            "patId": 2,
            "patient": "TestBorderline",
            "note": "Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois. Il remarque également que son audition continue d'être anormale",
            "date": new Date("2023-05-16T10:14:35.871Z")
        },
        {
            "patId": 3,
            "patient": "TestInDanger",
            "note": "Le patient déclare qu'il fume depuis peu",
            "date": new Date("2022-08-06T10:14:35.871Z")
        },
        {
            "patId": 3,
            "patient": "TestInDanger",
            "note": "Le patient déclare qu'il est fumeur et qu'il a cessé de fumer l'année dernière. Il se plaint également de crises d'apnée respiratoire anormales. Tests de laboratoire indiquant un taux de cholestérol élevé",
            "date": new Date("2022-12-16T10:14:35.871Z")
        },
        {
            "patId": 4,
            "patient": "TestEarlyOnset",
            "note": "Le patient déclare qu'il lui est difficile de monter les escaliers. Il se plaint également d'être essouflé. Tests de laboratoire indiquant que les anticorps sont élevés. Réaction aux médicaments",
            "date": new Date("2023-06-12T10:14:35.871Z")
        },
        {
            "patId": 4,
            "patient": "TestEarlyOnset",
            "note": "Le patient déclare qu'il a mal au dos lorsqu'il reste assis pendant longtemps",
            "date": new Date("2024-01-09T10:14:35.871Z")
        },
        {
            "patId": 4,
            "patient": "TestEarlyOnset",
            "note": "Le patient déclare avoir commencé à fumer depuis peu. Hémoglobine A1C supérieure au niveau recommandé",
            "date": new Date("2024-02-09T10:14:35.871Z")
        },
        {
            "patId": 4,
            "patient": "TestEarlyOnset",
            "note": "Taille, Poids, Cholestérol, Vertige et Réaction",
            "date": new Date("2024-02-09T23:17:23.808Z")
        },
        {
            "patId": 3,
            "patient": "Hugo",
            "note": "Le gars dit qu'il joue dans la base medilabo2",
            "date": new Date("2024-02-09T21:22:52.167Z")
        },
        {
            "patId": 3,
            "patient": "TestInDanger",
            "note": "Le patient a vraiment de plus en plus de mal à dormir",
            "date": new Date("2024-01-29T10:16:21.050Z")
        },
        {
            "patId": 3,
            "patient": "Hugo",
            "note": "dada di da da Da 2",
            "date": new Date("2024-02-06T04:43:24.502Z")
        },
        {
            "patId": 3,
            "patient": "Hugo",
            "note": "dada di da da Da etc etc",
            "date": new Date("2024-02-11T08:14:08.378Z")
        }]
);