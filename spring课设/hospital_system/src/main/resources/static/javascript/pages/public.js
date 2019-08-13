$(function () {
    $('#classify').on('change', function () {
        window.location.href = 'drug_classify?classify=' + $('#classify').val();
    })

    $('#purchase_classify').on('change', function () {
        window.location.href = 'drug_purchase_classify?classify=' + $('#purchase_classify').val();
    })

    $('#btn_purchase').click(function () {
        $('#purchaseform').submit();
    })

    $('#btn_diagnose').click(function () {
        $('#diagnoseform').submit();
    })

    $('#btn_injection').click(function () {
        window.location.href = '/completeInjection';
    })

    $('#prescription_classify').on('change', function () {
        window.location.href = 'prescription_classify?classify=' + $('#prescription_classify').val();
    })

    $('#btn_prescription').click(function () {
        window.location.href = '/completeDiagnose';
    })
});
