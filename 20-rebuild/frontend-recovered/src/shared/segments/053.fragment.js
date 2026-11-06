const D3 = { title: "气体期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVatFreight", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], amount: [{ required: true, message: "含税金额不能为空" }], amountExcludingVatFreight: [{ required: true, message: "不含税金额不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var f;
  if (!gi(e, D3.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((m) => m.basicClass === Pe.GAS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [], b = [], V = [];
  _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2"), _e.state.project.loaded || await _e.dispatch("project/fetchUserProjects");
  const M = _e.state.config.workshopNameV2, g = _e.state.config.warehouseV2, h = _e.state.project.userProjectsMap[Ot].map((m) => (m.fullName = di(m, null, false), m));
  u.forEach((m, R) => {
    let v = false;
    const N = pi(m.classifyName.split("/"));
    if (N.length === 1) {
      const L = n.filter((O) => O.name === m.classifyName) || [];
      if (A(L)) if (L.length === 1) v = true, m.classifyId = L[0].id, r.push(L[0].id);
      else {
        const O = [];
        for (const I of L) if (I.isLeaf) for (let Y = 0; Y < I.fullPathId.length; Y++) I.id !== I.fullPathId[Y] && O.push(I.fullPathId[Y]);
        const x = L.find((I) => Ae(I.parent) && !O.includes(I.id));
        if (A(x)) v = true, m.classifyId = x.id, r.push(x.id);
        else {
          const I = L.filter((Y) => Y.isLeaf) || [];
          if (I.length === 1) {
            let Y = true;
            L.forEach((ee) => {
              I[0].fullPathId.includes(ee.id) || (Y = false);
            }), Y && (v = true, m.classifyId = I[0].id, r.push(I[0].id));
          } else for (const Y of L) A(Y.parent) && !O.includes(Y.id) && y.push(Y);
        }
      }
      y.length > 1 && V.push({ rowIndex: R + 1, error: `科目名称"${m.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const L of n) if (L.fullPathName.length >= N.length && mi(L.fullPathName.slice(-N.length), N)) {
      v = true, m.classifyId = L.id, r.push(L.id);
      break;
    }
    v || (E.push(m.classifyName), b.some((L) => L.classifyName === m.classifyName) || b.push({ rowIndex: R + 1, classifyName: m.classifyName }));
    const P = Pe.GAS.V;
    eo(m, R, { workshopNameV2List: M, warehouseV2List: g, arr: h, errorList: V, basicClass: P });
  }), E = Array.from(new Set(E)), E.length > 0 && (V.push({ rowIndex: b[0].rowIndex, error: `${b.map((m) => `"${m.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const T = _e.state.config.classifySpec, _ = [];
  for (let m = 0; m < r.length; m++) T[r[m]] === void 0 && !_.includes(r[m]) && _.push(r[m]);
  _.length > 0 && (_.forEach((m) => {
    T[m] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", _));
  for (const m of u) {
    if (((f = c == null ? void 0 : c[m.classifyId]) == null ? void 0 : f.isLeaf) === false) {
      V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}不是末级科目` });
      continue;
    }
    const R = T[m.classifyId];
    if ((R == null ? void 0 : R.hasUnitConfig) === false) {
      V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}未配置核算单位` });
      continue;
    }
    let v;
    const N = m.specification ?? "";
    if (R && Array.isArray(R.specList)) {
      for (const P of R.specList) if (N === P.spec) {
        if (v = P, m.measureUnit && m.measureUnit !== "-") {
          if (!v.classify.measureUnit) {
            V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}不存在计量单位` });
            continue;
          }
          await ti(v.classify.measureUnit, m.measureUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的计量单位错误，单位应为：“${v.classify.measureUnit}”` });
        }
        m.accountingUnit && (await ti(v.classify.accountingUnit, m.accountingUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的核算单位错误，单位应为：“${v.classify.accountingUnit}”` }));
        break;
      }
    }
    if (v) m.uid = Tt(), m.sn = v.sn, m.specificationLabels = v.specificationLabels, m.serialNumber = v.serialNumber, m.classifySerialNumber = v.classify.serialNumber, m.classifyId = v.classify.id, m.classifyFullPathId = v.classify.fullPathId, m.classifyFullName = v.classify.fullName, m.classifyName = v.classify.name, m.classifyParentFullName = v.classify.parentFullName, m.basicClass = v.classify.basicClass, m.specification = v.spec, m.specificationMap = v.specKV, m.measureUnit = v.classify.measureUnit, m.accountingUnit = v.classify.accountingUnit, m.accountingPrecision = v.classify.accountingPrecision, m.measurePrecision = v.classify.measurePrecision, m.measureUnit || (m.quantity = void 0), m.quantity && (m.quantity = Be(m.quantity, m.measurePrecision)), m.mete && (m.mete = Be(m.mete, m.accountingPrecision)), m.measureUnit || (m.quantity = void 0);
    else {
      const P = `${m.classifyName}下不存在规格为"${N}"的材料，请联系管理员/仓库人员添加`;
      V.some((L) => L.error === P) || V.push({ rowIndex: u.indexOf(m) + 1, error: P });
    }
  }
  if (V.length > 0) I$(V);
  else return u;
} };
const C$ = { class: "inbound-application-header flex-rbc" }, P$ = { style: { display: "flex", gap: "20px", "align-items": "center" } }, O$ = { key: 0, class: "child-mr-7 flex-rsc" }, k$ = { __name: "common-header", props: { purchaseId: { type: String }, basicClass: { type: Number }, validate: { type: Function }, importAmountRules: { type: Object, default: () => {
} }, currentBasicClass: { type: Number }, isManuf: { type: Boolean, default: false }, edit: { type: Boolean, default: false }, hideenBegin: { type: Boolean, default: false }, permission: { type: Object, default: () => {
} } }, emits: ["update:purchaseId", "purchase-order-change"], setup(e, { expose: o, emit: n }) {
  const { inboundFillWayCfg: c } = aa(), u = Ee(() => c.value.saveInboundState === Sl.MODIFY.V), r = Ht(), E = n;
  Wa();
  const y = e, b = jn(), V = Z(false), M = Z([]), g = Z([]), S = Z(false), h = ft("matSpecRef"), { cu: T, form: _, FORM: f } = Wi(), { weightOverDiff: m, diffSubmitValidate: R } = c3(), v = Ee(() => _.inboundWay === si.OPENING_RECEIPT.V), N = (ge, Le, Ie) => {
    if (Le == null) {
      Ie();
      return;
    }
    R(B.value.hasOver) ? Ie() : Ie(new Error("超出误差允许范围"));
  }, P = { purchaseId: [{ required: true, message: "请选择订单", trigger: "change" }], licensePlate: [{ pattern: uc, message: "请填写正确的车牌号", trigger: "blur" }], loadingWeight: [{ validator: N, trigger: "blur" }] }, L = { loadingWeight: [{ required: true, message: "请填写过磅重量", trigger: "blur" }, { validator: N, trigger: "blur" }] }, O = { licensePlate: [{ required: true, message: "请填写车牌号", trigger: "blur" }, { pattern: uc, message: "请填写正确的车牌号", trigger: "blur" }] }, x = Ee(() => {
    const ge = Object.assign({}, P);
    return q.value.logisticsTransportType === Xa.FREIGHT.V && q.value.logisticsPayerType === Bi.DEMAND.V && Object.assign(ge, O), y.basicClass & sl && q.value.weightMeasurementMode === Wt.OVERWEIGHT.V && Object.assign(ge, L), ge;
  }), I = Ee(() => {
    if (v.value) switch (y.currentBasicClass ?? y.basicClass) {
      case Pe.STEEL_PLATE.V:
        return p3;
      case Pe.SECTION_STEEL.V:
        return f3;
      case Pe.STEEL_COIL.V:
        return C3;
      case Pe.MATERIAL.V:
        return O3;
      case Pe.OTHER.V:
        return k3;
      case Pe.GAS.V:
        return D3;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return P3;
      default:
        return null;
    }
    else switch (y.currentBasicClass ?? y.basicClass) {
      case Pe.STEEL_PLATE.V:
        return m3;
      case Pe.SECTION_STEEL.V:
        return h3;
      case Pe.STEEL_COIL.V:
        return g3;
      case Pe.MATERIAL.V:
        return Tm;
      case Pe.OTHER.V:
        return E3;
      case Pe.GAS.V:
        return y3;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return T3;
      default:
        return Tm;
    }
  }), Y = Ee(() => {
    switch (y.currentBasicClass ?? y.basicClass) {
      case Pe.STEEL_PLATE.V:
        return u.value ? R3 : _3;
      case Pe.SECTION_STEEL.V:
        return u.value ? M3 : b3;
      case Pe.STEEL_COIL.V:
        return u.value ? A3 : V3;
      case Pe.MATERIAL.V:
        return u.value ? bm : _m;
      case Pe.OTHER.V:
        return u.value ? N3 : w3;
      case Pe.GAS.V:
        return S3;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return u.value ? L3 : v3;
      default:
        return u.value ? bm : _m;
    }
  }), ee = Z(), B = Z({}), q = Z({}), ae = Ee(() => _.supplyType === Ni.PARTY_A.V);
  Ce(() => _.inboundWay, (ge) => {
    _.purchaseId = null, _.supplierId = null, _.licensePlate = null, _.steelPlateList = [], _.sectionSteelList = [], _.steelCoilList = [], _.otherSteelMaterialList = [];
  }), Dt(() => {
    B.value = m(_.loadingWeight, T.props.totalWeight);
  }), f.HOOK.afterSubmit = async () => {
    j(), pt(() => {
      ee.value && ee.value.resetFields();
    }), await r.dispatch("approval_list/fetchApprovalNum");
  };
  function j() {
    B.value = {}, q.value = {};
    const ge = Dt(() => {
      h.value && (h.value.clear(), pt(() => {
        ge();
      }));
    });
  }
  function le(ge) {
    pt(() => {
      var Le;
      B.value = {}, (Le = ee == null ? void 0 : ee.value) == null || Le.clearValidate();
    }), _.purchaseId = ge, E("update:purchaseId", ge);
  }
  async function oe(ge, Le) {
    var Ie;
    if (S.value = true, T.props.requisitions = {}, _.selectObj || (_.selectObj = {}), y.edit || (_.selectObj = {}), ge && (ge.originInboundTotalMete = ge.originInboundTotalMete || ge.inboundTotalMete, ge.requisitionsSN && ye(ge.requisitionsSN), ge.logisticsTransportType === Xa.POST.V && (_.licensePlate = void 0), ge.logisticsTransportType === Xa.FREIGHT.V && (_.shipmentNumber = void 0), ge.mete && (ge.mete = Be(ge.mete, ei.weight.precision)), ge.inboundTotalMete && ge.basicClass & sl && (ge.inboundTotalMete = St(ge.originInboundTotalMete, "g", "t", ei.weight.precision), ge.unit = "t"), (Ie = ge.applyPurchase) != null && Ie.length ? ge.boolApplyPurchase = true : ge.boolApplyPurchase = false, ge.id)) {
      const { content: Se = [] } = await yw(ge.id);
      let X = Se;
      if (X = X.filter(($) => $.basicClass & y.basicClass), !(ge.materialType & ho)) {
        const $ = [];
        X.forEach((k) => {
          !$.includes(k.classifyId) && k.classifyId && $.push(k.classifyId);
        }), await r.dispatch("config/fetchFinalMatClsByIdList", $);
      }
      if (await Qt(X), ge.materialType & ho) {
        await fo(X, { toNum: true }, { mete: ["mete"], quantity: ["quantity"] });
        const $ = X == null ? void 0 : X.map((k) => {
          var z, F, G, ie, ue, ne, te, de, pe, re, we, Ke, Me, Ne;
          k.mergeId = k.id, k.purchaseOrderDetailId = k.id, k.purchaseQuantity = k.quantity, k.purchaseMete = k.mete, k.boolApplyPurchase = true;
          let J = 0;
          return y.edit && ((z = _ == null ? void 0 : _.editObj) != null && z[k.mergeId]) && (J += ((G = (F = _ == null ? void 0 : _.editObj) == null ? void 0 : F[k.mergeId]) == null ? void 0 : G.quantity) || 0), k.canPurchaseQuantity = (k.purchaseQuantity || 0) - k.inboundQuantity + J > 0 ? k.purchaseQuantity - k.inboundQuantity + J : 0, k.quantity = null, k.mete = null, k.totalWeight = null, y.edit && ((ie = _ == null ? void 0 : _.editObj) != null && ie[k.mergeId]) && (k.quantity = (ne = (ue = _ == null ? void 0 : _.editObj) == null ? void 0 : ue[k.mergeId]) == null ? void 0 : ne.quantity, k.totalWeight = (de = (te = _ == null ? void 0 : _.editObj) == null ? void 0 : te[k.mergeId]) == null ? void 0 : de.totalWeight, k.mete = (re = (pe = _ == null ? void 0 : _.editObj) == null ? void 0 : pe[k.mergeId]) == null ? void 0 : re.mete, k.workshopId = (Ke = (we = _ == null ? void 0 : _.editObj) == null ? void 0 : we[k.mergeId]) == null ? void 0 : Ke.workshopId, k.warehouseId = (Ne = (Me = _ == null ? void 0 : _.editObj) == null ? void 0 : Me[k.mergeId]) == null ? void 0 : Ne.warehouseId), k.originQuantity = k.quantity, k.originMete = k.totalWeight, y.edit && (k.needFirstCalcTheoryWeight = true, _.selectObj[k.mergeId] = {}, _.selectObj[k.mergeId] = { ...k, _isSelected: true }), k;
        });
        ge.details = $.filter((k) => k.canPurchaseQuantity > 0);
      } else await Ut(X, { toNum: true }, { mete: ["mete", "inboundMete"], quantity: ["inboundQuantity", "quantity"] }), ge.details = X == null ? void 0 : X.map(($) => {
        var F, G, ie, ue, ne, te, de, pe, re, we, Ke, Me, Ne, He, ze, Oe, Re, fe;
        const k = {};
        $.mergeId = $.id, $.purchaseOrderDetailId = $.id, $.purchaseQuantity = $.quantity, $.purchaseMete = $.mete, $.boolApplyPurchase = true, $.canPurchaseQuantity = ($.purchaseQuantity || 0) - $.inboundQuantity > 0 ? $.purchaseQuantity - $.inboundQuantity : 0, $.originBoolApplyPurchase = !!A($.applyPurchase);
        let J = false;
        (F = _.selectObj) != null && F[$.mergeId] ? J = (G = _.selectObj[$.mergeId]) == null ? void 0 : G.isSelected : y.edit && ((ie = _ == null ? void 0 : _.editObj) != null && ie[$.mergeId]) && (J = (ne = (ue = _ == null ? void 0 : _.editObj) == null ? void 0 : ue[$.mergeId]) == null ? void 0 : ne.isSelected);
        let z = $;
        if (J && (z = { ...z, ...(te = _ == null ? void 0 : _.selectObj) == null ? void 0 : te[$.mergeId], ...(de = _ == null ? void 0 : _.editObj) == null ? void 0 : de[$.mergeId] }), _.selectObj[$.mergeId] = { ...z, isSelected: J }, z.applyPurchase = A(z.applyPurchase) ? z.applyPurchase : [{ id: z.mergeId, serialNumber: "" }], (pe = z.applyPurchase) != null && pe.length) {
          z.boolApplyPurchase = true;
          let Ue = 0, Je = 0;
          const Xe = [];
          z.applyPurchase.forEach((Ye) => {
            var et, lt, bt, gt, qt, kt, Ii, ra, wa, Eo, da, Tl, os, ns, Cn, ao;
            Ye.applyPurchaseId = Ye.applyPurchaseId || z.applyPurchaseId || z.mergeId, Ye.applyPurchaseSN = Ye.serialNumber, k[Ye.id] = Ye, Ye.originBoolApplyPurchase = z.originBoolApplyPurchase;
            const Fe = y.edit ? (et = _ == null ? void 0 : _.editObj) == null ? void 0 : et[z.mergeId] : z;
            if (Ye.sn = Fe == null ? void 0 : Fe.sn, Ye.specificationLabels = Fe == null ? void 0 : Fe.specificationLabels, Ye.serialNumber = Fe == null ? void 0 : Fe.serialNumber, Ye.classifyId = Fe == null ? void 0 : Fe.classifyId, Ye.classifyFullName = Fe == null ? void 0 : Fe.classifyFullName, Ye.classifyName = Fe == null ? void 0 : Fe.classifyName, Ye.classifyParentFullName = Fe == null ? void 0 : Fe.classifyParentFullName, Ye.basicClass = Fe == null ? void 0 : Fe.basicClass, Ye.specification = Fe == null ? void 0 : Fe.specification, Ye.specificationMap = Fe == null ? void 0 : Fe.specKV, Ye.measureUnit = Fe == null ? void 0 : Fe.measureUnit, Ye.accountingUnit = Fe == null ? void 0 : Fe.accountingUnit, Ye.measurePrecision = Fe == null ? void 0 : Fe.measurePrecision, Ye.accountingPrecision = Fe == null ? void 0 : Fe.accountingPrecision, Ye.unitWeight = Fe == null ? void 0 : Fe.unitWeight, Ye.length = Fe == null ? void 0 : Fe.length, Ye.width = Fe == null ? void 0 : Fe.width, Ye.thickness = Fe == null ? void 0 : Fe.thickness, Ye.projectId = Ye.projectId || ((lt = Ye.project) == null ? void 0 : lt.id) || (Fe == null ? void 0 : Fe.projectId) || ((bt = Fe == null ? void 0 : Fe.project) == null ? void 0 : bt.id), Ye.workshopId = Ye.workshopId || ((gt = Ye.workshop) == null ? void 0 : gt.id) || (Fe == null ? void 0 : Fe.workshopId) || ((qt = Fe == null ? void 0 : Fe.workshop) == null ? void 0 : qt.id), Ye.warehouseId = Ye.warehouseId || ((kt = Ye.warehouse) == null ? void 0 : kt.id) || (Fe == null ? void 0 : Fe.warehouseId) || ((Ii = Fe == null ? void 0 : Fe.warehouse) == null ? void 0 : Ii.id), z.basicClass & Pe.MATERIAL.V) {
              const Vl = y.edit ? (ra = _ == null ? void 0 : _.editObj) == null ? void 0 : ra[z.mergeId] : z;
              (wa = z.applyPurchase) != null && wa.length && (Ye.measureUnit = Vl == null ? void 0 : Vl.measureUnit, Ye.accountingUnit = Vl == null ? void 0 : Vl.accountingUnit);
            }
            if ((!J || y.edit) && (Ye.applyPurchaseId = Ye.id, Ye.purchaseQuantity = Ye.quantity, Ye.purchaseMete = Ye.mete, Ye.quantity = z.basicClass & Pe.STEEL_COIL.V ? 1 : null, Ye.mete = null), y.edit && ((os = (Tl = (da = (Eo = _ == null ? void 0 : _.editObj) == null ? void 0 : Eo[z.mergeId]) == null ? void 0 : da.applyPurchaseObj) == null ? void 0 : Tl[Ye.applyPurchaseId]) != null && os.length)) {
              const Vl = (ao = (Cn = (ns = _ == null ? void 0 : _.editObj) == null ? void 0 : ns[z.mergeId]) == null ? void 0 : Cn.applyPurchaseObj) == null ? void 0 : ao[Ye.applyPurchaseId];
              for (let Qo = 0; Qo < Vl.length; Qo++) {
                const Sa = Vl[Qo];
                Sa.basicClass & va.STEEL.V && (Ye.weighingTotalWeight = Sa.mete), Ye.unitWeight = Sa == null ? void 0 : Sa.unitWeight, Ye.length = Sa == null ? void 0 : Sa.length, Ye.width = Sa == null ? void 0 : Sa.width, Ye.thickness = Sa == null ? void 0 : Sa.thickness;
                const it = Sa.quantity, tt = Sa.mete;
                Ye.quantity = it, Je += it, Ye.mete = tt, Ue += tt, Ye.originQuantity = Ye.quantity, Ye.originMete = Ye.mete, Ye.theoryWeight = Sa.theoryWeight, Ye.theoryTotalWeight = Sa.theoryTotalWeight, Ye.theoryLength = Sa.theoryLength, Ye.unitPrice = Sa.unitPrice, Ye.amount = Sa.amount, Ye.spanMerge = Qo === 0 ? Vl.length : 0, Ye.isBranch = Qo > 0, Xe.push(JSON.parse(JSON.stringify(Ye)));
              }
            } else Je += Ye.quantity || 0, Ue += Ye.mete || 0, Ye.originQuantity = Ye.quantity, Ye.originMete = Ye.mete, Xe.push(JSON.parse(JSON.stringify(Ye)));
          }), z.applyPurchase = Xe, z.basicClass & Pe.MATERIAL.V && (y.edit ? (Qt(z.applyPurchase), Ut(z.applyPurchase, { toNum: true }, { mete: ["inboundMete", "purchaseMete"], quantity: ["inboundQuantity", "purchaseQuantity"] })) : (Qt(z.applyPurchase), Ut(z.applyPurchase, { toNum: true }, { mete: ["mete", "inboundMete", "purchaseMete"], quantity: ["inboundQuantity", "quantity", "purchaseQuantity"] }))), z.firstApplyPurchase = JSON.parse(JSON.stringify(z.applyPurchase)), z.quantity = Je, z.mete = Ue;
        } else z.quantity = null, z.mete = null;
        return y.edit && ((re = _ == null ? void 0 : _.editObj) != null && re[z.mergeId]) ? (z.quantity = (Ke = (we = _ == null ? void 0 : _.editObj) == null ? void 0 : we[z.mergeId]) == null ? void 0 : Ke.quantity, z.mete = (Ne = (Me = _ == null ? void 0 : _.editObj) == null ? void 0 : Me[z.mergeId]) == null ? void 0 : Ne.mete) : J && (z.quantity = (ze = (He = _ == null ? void 0 : _.selectObj) == null ? void 0 : He[z.mergeId]) == null ? void 0 : ze.quantity, z.mete = (Re = (Oe = _ == null ? void 0 : _.selectObj) == null ? void 0 : Oe[z.mergeId]) == null ? void 0 : Re.mete), z.originQuantity = z.quantity, z.originMete = z.mete, y.edit && (z.needFirstCalcTheoryWeight = true), (fe = $.inboundList) != null && fe.length && (Qt($.inboundList), Ut($.inboundList, { toNum: true }), $.inboundList.forEach((Ue) => {
          var Je;
          Ue.applyPurchaseSN = (Je = k[Ue.applyPurchaseId]) == null ? void 0 : Je.applyPurchaseSN;
        })), z;
      });
    }
    q.value = ge || {}, console.log(ge), E("purchase-order-change", ge, Le), S.value = false;
  }
  async function ye(ge) {
    if (Ae(ge)) return;
    const Le = [];
    ge.forEach((Ie) => {
      const Se = _w(Ie).then((X) => {
        T.props.requisitions[Ie] = X;
      });
      Le.push(Se);
    }), await Promise.all(Le);
  }
  function ce(ge, Le = false) {
    var Se;
    const Ie = [];
    if (A(y.importAmountRules) && !Le && !v.value) {
      for (let X = 0; X < ge.length; X++) {
        const $ = ge[X];
        for (const k in y.importAmountRules) L_(k, y.importAmountRules[k], $) || ($.mete = $.mete ?? $.weighingTotalWeight, $.amount = +$.amount, Ie.push({ ...$, originIndex: X }));
      }
      if (Ie.length) {
        g.value = Ie, M.value = ge, V.value = true;
        return;
      }
    }
    try {
      (Se = T == null ? void 0 : T.submitResult) != null && Se.data && (T.submitResult.data = null), T.props.import(ge), y.validate();
    } catch (X) {
      ot.error({ message: X.message, duration: 5e3 });
    }
  }
  function se(ge) {
    var Le;
    try {
      (Le = T == null ? void 0 : T.submitResult) != null && Le.data && (T.submitResult.data = null), T.props.detailImport(ge);
    } catch (Ie) {
      ot.error({ message: Ie.message, duration: 5e3 });
    }
  }
  function he(ge) {
    for (let Le = 0; Le < ge.length; Le++) {
      const Ie = ge[Le];
      M.value[Ie.originIndex].amount = Ie.amount, M.value[Ie.originIndex].unitPrice = Ie.unitPrice;
    }
    ce(M.value, true);
  }
  function be() {
    ci.set("ROUTER_PARAMS", { basicClass: y.basicClass }), b.push({ name: "RawMatInboundApplicationRecord" });
  }
  async function me() {
    try {
      return ee.value ? await ee.value.validate() : false;
    } catch {
      return false;
    }
  }
  return o({ validate: me, contentLoading: S, form: _ }), (ge, Le) => {
    var z, F, G, ie, ue, ne, te, de, pe, re, we, Ke;
    const Ie = Ve("common-radio-button"), Se = Zi, X = Mt, $ = Li, k = jt, J = Ve("common-button");
    return w(), Q("div", C$, [C("div", P$, [y.hideenBegin ? H("", true) : (w(), U(Ie, { key: 0, modelValue: l(_).inboundWay, "onUpdate:modelValue": Le[0] || (Le[0] = (Me) => l(_).inboundWay = Me), disabled: y.edit, options: l(si).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])), l(_).inboundWay === l(si).ORDINARY_STORAGE.V || e.isManuf ? (w(), U($, { key: 1, ref_key: "formRef", ref: ee, model: l(_), rules: x.value, inline: "", "label-position": "right", "label-width": "80px" }, { default: p(() => [ae.value ? H("", true) : (w(), U(Se, { key: 0, "label-width": 120, label: "当前采购合同", prop: "purchaseId" }, { default: p(() => [l(_).inboundWay === l(si).ORDINARY_STORAGE.V || e.isManuf ? (w(), U(XX, { key: 0, purchaseId: l(_).purchaseId, "onUpdate:purchaseId": Le[1] || (Le[1] = (Me) => l(_).purchaseId = Me), supplierId: l(_).supplierId, "onUpdate:supplierId": Le[2] || (Le[2] = (Me) => l(_).supplierId = Me), workshopId: l(_).workshopId, "onUpdate:workshopId": Le[3] || (Le[3] = (Me) => l(_).workshopId = Me), "basic-class": y.basicClass, defaultForm: l(_), disabled: e.edit, workshopReload: !e.edit, class: "input-underline", style: { width: "340px" }, edit: e.edit, clearable: "", onChange: le, onInfoChange: oe }, null, 8, ["purchaseId", "supplierId", "workshopId", "basic-class", "defaultForm", "disabled", "workshopReload", "edit"])) : H("", true)]), _: 1 })), l(A)(q.value) ? (w(), Q(Qe, { key: 1 }, [(l(_).inboundWay === l(si).ORDINARY_STORAGE.V || e.isManuf) && q.value.logisticsTransportType === l(Xa).FREIGHT.V ? (w(), U(Se, { key: 0, label: "车牌号", "label-width": "70px", prop: "licensePlate" }, { default: p(() => [s(X, { modelValue: l(_).licensePlate, "onUpdate:modelValue": Le[4] || (Le[4] = (Me) => l(_).licensePlate = Me), modelModifiers: { trim: true }, class: "input-underline", placeholder: "车牌号", style: { width: "125px" } }, null, 8, ["modelValue"])]), _: 1 })) : H("", true), q.value.logisticsTransportType === l(Xa).POST.V ? (w(), U(Se, { key: 1, label: "物流单号", "label-width": "70px", prop: "shipmentNumber" }, { default: p(() => [s(X, { modelValue: l(_).shipmentNumber, "onUpdate:modelValue": Le[5] || (Le[5] = (Me) => l(_).shipmentNumber = Me), modelModifiers: { trim: true }, class: "input-underline", maxlength: "100", placeholder: "物流单号", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })) : H("", true)], 64)) : H("", true)]), _: 1 }, 8, ["model", "rules"])) : H("", true)]), e.isManuf ? H("", true) : (w(), Q("div", O$, [l(_).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), Q(Qe, { key: 0 }, [ae.value || l(Ae)((z = q.value) == null ? void 0 : z.details) ? (w(), U(k, { key: 0, content: l(A)((G = (F = l(T)) == null ? void 0 : F.submitResult) == null ? void 0 : G.data) ? "请删除全部标红数据" : "请先选择采购合同编号", disabled: !!l(_).purchaseId && l(_).supplyType === l(Ni).SELF.V && !l(A)((ue = (ie = l(T)) == null ? void 0 : ie.submitResult) == null ? void 0 : ue.data), effect: "light", placement: "bottom" }, { default: p(() => {
      var Me, Ne;
      return [s(Ro, { disabled: l(_).inboundWay === l(si).ORDINARY_STORAGE.V ? !l(_).purchaseId && l(_).supplyType === l(Ni).SELF.V || l(Ae)(q.value) || l(A)((Ne = (Me = l(T)) == null ? void 0 : Me.submitResult) == null ? void 0 : Ne.data) : false, template: I.value, "btn-name": "批量导入", "btn-size": "default", "btn-type": "success", icon: "el-icon-upload", "open-loading": "", onSuccess: ce }, null, 8, ["disabled", "template"])];
    }), _: 1 }, 8, ["content", "disabled"])) : (w(), U(k, { key: 1, content: l(A)((te = (ne = l(T)) == null ? void 0 : ne.submitResult) == null ? void 0 : te.data) ? "请删除全部标红数据" : "请先选择采购合同编号", disabled: !!l(_).purchaseId && l(_).supplyType === l(Ni).SELF.V && !l(A)((pe = (de = l(T)) == null ? void 0 : de.submitResult) == null ? void 0 : pe.data), effect: "light", placement: "bottom" }, { default: p(() => {
      var Me, Ne;
      return [s(Ro, { disabled: !l(_).purchaseId && l(_).supplyType === l(Ni).SELF.V || l(Ae)(q.value) || l(A)((Ne = (Me = l(T)) == null ? void 0 : Me.submitResult) == null ? void 0 : Ne.data), template: Y.value, "btn-name": "批量导入", "btn-size": "default", "btn-type": "success", icon: "el-icon-upload", "open-loading": "", onSuccess: se }, null, 8, ["disabled", "template"])];
    }), _: 1 }, 8, ["content", "disabled"]))], 64)) : H("", true), l(Ai)((re = y.permission) == null ? void 0 : re.import) && l(_).inboundWay === l(si).OPENING_RECEIPT.V && !y.edit ? (w(), U(Ro, { key: 1, disabled: l(_).inboundWay === l(si).ORDINARY_STORAGE.V ? !l(_).purchaseId && l(_).supplyType === l(Ni).SELF.V || l(Ae)(q.value) || l(A)((Ke = (we = l(T)) == null ? void 0 : we.submitResult) == null ? void 0 : Ke.data) : false, template: I.value, "btn-name": "期初批量导入", "btn-size": "default", "btn-type": "success", icon: "el-icon-upload", "open-loading": "", onSuccess: ce }, null, 8, ["disabled", "template"])) : H("", true), y.edit ? H("", true) : (w(), U(J, { key: 2, icon: "el-icon-clock", size: "default", type: "info", onClick: be }))])), l(_).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(l(I3), { key: 1, visible: V.value, "onUpdate:visible": Le[6] || (Le[6] = (Me) => V.value = Me), amountRules: e.importAmountRules, basicClass: y.currentBasicClass ?? y.basicClass, list: g.value, onApply: he }, null, 8, ["visible", "amountRules", "basicClass", "list"])) : H("", true)]);
  };
} }, x3 = ut(k$, [["__scopeId", "data-v-655b6b8f"]]), D$ = Object.freeze(Object.defineProperty({ __proto__: null, default: x3 }, Symbol.toStringTag, { value: "Module" }));
const x$ = { class: "inbound-application-footer" }, U$ = { class: "total-box" }, Y$ = { class: "total-item" }, K$ = { class: "total-item" }, W$ = { class: "total-name" }, j$ = { class: "total-item" }, F$ = { class: "total-item" }, z$ = { __name: "common-footer", props: { permission: { type: Array, default: void 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "确认并提交" }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, contractUnit: { type: String, default: "" }, contractValue: { type: [Number, String], default: 0 }, showContractTotal: { type: Boolean, default: false }, inboundUnit: { type: String, default: "" }, inboundValue: { type: [Number, String], default: 0 }, showInboundTotal: { type: Boolean, default: false }, showTotal: { type: Boolean, default: true }, showTotalAmount: { type: Boolean, default: false }, totalAmount: { type: [Number, String], default: 0 }, isSubmit: { type: Boolean, default: false } }, emits: ["submit"], setup(e, { emit: o }) {
  const n = Ht(), c = o, u = e, { cu: r, FORM: E } = Wi(), y = Z(false), b = Nc(async function() {
    if (u.isSubmit) try {
      if (!r.form.purchaseId) return;
      y.value = true, r.form.clickTime = n.state.config.getTreeClickTime, await r.submit(), c("submit");
    } catch (V) {
      console.log("入库表单提交", V);
    } finally {
      y.value = false;
    }
    else y.value = false, c("submit");
  }, 350, true);
  return (V, M) => {
    const g = Ve("common-button");
    return w(), Q("div", x$, [C("div", U$, [u.showContractTotal ? (w(), Q(Qe, { key: 0 }, [M[0] || (M[0] = C("div", { class: "total-name" }, "合同量", -1)), C("div", Y$, K(`${u.contractValue || 0} ${u.contractUnit || ""}`), 1)], 64)) : H("", true), u.showInboundTotal ? (w(), Q(Qe, { key: 1 }, [M[1] || (M[1] = C("div", { class: "total-name" }, "已入库量", -1)), C("div", K$, K(`${u.inboundValue || 0} ${u.inboundUnit || ""}`), 1)], 64)) : H("", true), u.showTotal ? (w(), Q(Qe, { key: 2 }, [C("div", W$, K(u.totalName), 1), C("div", j$, K(`${u.totalValue || 0} ${u.unit || ""}`), 1)], 64)) : H("", true), u.showTotalAmount ? (w(), Q(Qe, { key: 3 }, [M[2] || (M[2] = C("div", { class: "total-name" }, "金额合计", -1)), C("div", F$, K(`${u.totalAmount || 0} 元`), 1)], 64)) : H("", true)]), C("div", null, [xt(V.$slots, "calculator", {}, void 0, true), s(g, { loading: y.value, size: "default", style: { "margin-left": "10px" }, type: "primary", onClick: l(b) }, { default: p(() => [Te(K(e.btnName), 1)]), _: 1 }, 8, ["loading", "onClick"])])]);
  };
} }, o2 = ut(z$, [["__scopeId", "data-v-e2e6a0dd"]]), B$ = Object.freeze(Object.defineProperty({ __proto__: null, default: o2 }, Symbol.toStringTag, { value: "Module" })), H$ = { __name: "steel-plate", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, showWidth: { type: Boolean, default: true }, showLength: { type: Boolean, default: true }, showThickness: { type: Boolean, default: true }, sortable: { type: [String, Boolean], default: false }, returnSortable: { type: [String, Boolean], default: false }, warehouseSort: { type: [String, Boolean], default: false }, specificationLable: { type: String, default: "规格" } }, setup(e) {
  const o = e, { loaded: n, baseUnit: c } = ai(o.basicClass), u = Ee(() => Ae(o.columns) || o.columns.visible("specification")), r = Ee(() => o.showThickness && n.value && (Ae(o.columns) || o.columns.visible("thickness"))), E = Ee(() => o.showWidth && n.value && (Ae(o.columns) || o.columns.visible("width"))), y = Ee(() => o.showLength && n.value && (Ae(o.columns) || o.columns.visible("length")));
  return (b, V) => {
    const M = Ve("vxe-tooltip"), g = Ve("vxe-column");
    return o.specMerge ? (w(), Q(Qe, { key: 0 }, [u.value ? (w(), U(g, { key: 0, align: "center", field: "specificationMerge", fixed: e.fixed, "min-width": "180", title: "规格" }, { default: p(({ row: S }) => [s(M, { content: l(Ma)(S), "show-after": 500, placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(S)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [u.value ? (w(), U(g, { key: 0, align: "center", field: "specification", fixed: e.fixed, "min-width": "140", title: o.specificationLable }, { default: p(({ row: S }) => [C("span", null, K(S.specification || "-"), 1)]), _: 1 }, 8, ["fixed", "title"])) : H("", true), r.value ? (w(), U(g, { key: 1, align: "center", field: "thickness", fixed: e.fixed, width: "100", title: `厚 (${l(c).thickness.unit})` }, null, 8, ["fixed", "title"])) : H("", true), E.value ? (w(), U(g, { key: 2, align: "center", field: "width", fixed: e.fixed, width: "120", title: `宽 (${l(c).width.unit})` }, null, 8, ["fixed", "title"])) : H("", true), y.value ? (w(), U(g, { key: 3, align: "center", field: "length", fixed: e.fixed, width: "120", title: `长 (${l(c).length.unit})` }, null, 8, ["fixed", "title"])) : H("", true)], 64));
  };
} }, q$ = { __name: "section-steel", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, showLength: { type: Boolean, default: true }, sortable: { type: [String, Boolean], default: false }, returnSortable: { type: [String, Boolean], default: false }, warehouseSort: { type: [String, Boolean], default: false }, specificationLable: { type: String, default: "规格" }, isShowSpec: { type: Boolean, default: false } }, setup(e) {
  const o = e, { loaded: n, baseUnit: c } = ai(o.basicClass), u = Ee(() => Ae(o.columns) || o.columns.visible("specification")), r = Ee(() => o.showLength && n.value && (Ae(o.columns) || o.columns.visible("length")));
  return (E, y) => {
    const b = Ve("vxe-column"), V = Ve("vxe-tooltip");
    return w(), Q(Qe, null, [o.isShowSpec ? (w(), U(b, { key: 0, align: "center", field: "doNotSectionSteelSpec", fixed: e.fixed, width: "120", title: "材质" }, null, 8, ["fixed"])) : H("", true), o.specMerge ? (w(), Q(Qe, { key: 1 }, [u.value ? (w(), U(b, { key: 0, align: "center", field: "specificationMerge", fixed: e.fixed, "min-width": "180", title: "规格" }, { default: p(({ row: M }) => [s(V, { content: l(Ma)(M), "show-after": 500, placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(M)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 2 }, [u.value ? (w(), U(b, { key: 0, align: "center", field: "specification", fixed: e.fixed, "min-width": "140", title: o.specificationLable }, { default: p(({ row: M }) => [C("span", null, K(M.specification || "-"), 1)]), _: 1 }, 8, ["fixed", "title"])) : H("", true), r.value ? (w(), U(b, { key: 1, align: "center", field: "length", fixed: e.fixed, width: "120", title: `长 (${l(c).length.unit})` }, null, 8, ["fixed", "title"])) : H("", true)], 64))], 64);
  };
} }, G$ = { __name: "steel-coil", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, showWidth: { type: Boolean, default: true }, showThickness: { type: Boolean, default: true }, sortable: { type: [String, Boolean], default: false }, returnSortable: { type: [String, Boolean], default: false }, specificationLable: { type: String, default: "规格" } }, setup(e) {
  const o = e, { loaded: n, baseUnit: c } = ai(o.basicClass), u = Ee(() => Ae(o.columns) || o.columns.visible("specification")), r = Ee(() => o.showThickness && n.value && (Ae(o.columns) || o.columns.visible("thickness"))), E = Ee(() => o.showWidth && n.value && (Ae(o.columns) || o.columns.visible("width"))), y = Ee(() => Ae(o.columns) || o.columns.visible("color"));
  function b({ cellValue: V }) {
    return V || "-";
  }
  return (V, M) => {
    const g = Ve("vxe-tooltip"), S = Ve("vxe-column");
    return o.specMerge ? (w(), Q(Qe, { key: 0 }, [u.value ? (w(), U(S, { key: 0, align: "center", field: "specificationMerge", fixed: e.fixed, "min-width": "180", title: "规格" }, { default: p(({ row: h }) => [s(g, { content: l(Ma)(h), "show-after": 500, placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(h)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [u.value ? (w(), U(S, { key: 0, align: "center", field: "specification", fixed: e.fixed, "min-width": "140", title: o.specificationLable }, { default: p(({ row: h }) => [C("span", null, K(h.specification || "-"), 1)]), _: 1 }, 8, ["fixed", "title"])) : H("", true), r.value ? (w(), U(S, { key: 1, align: "center", field: "thickness", fixed: e.fixed, width: "100", title: `厚 (${l(c).thickness.unit})` }, null, 8, ["fixed", "title"])) : H("", true), E.value ? (w(), U(S, { key: 2, align: "center", field: "width", fixed: e.fixed, width: "120", title: `宽 (${l(c).width.unit})` }, null, 8, ["fixed", "title"])) : H("", true), y.value ? (w(), U(S, { key: 3, align: "center", field: "color", fixed: e.fixed, width: "120", title: "颜色", formatter: b }, null, 8, ["fixed"])) : H("", true)], 64));
  };
} }, Q$ = { __name: "aux-mat", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, returnSortable: { type: [String, Boolean], default: false }, sortable: { type: [String, Boolean], default: false }, specificationLable: { type: String, default: "规格" } }, setup(e) {
  const o = e, n = Ee(() => Ae(o.columns) || o.columns.visible("specification")), c = Ee(() => Ae(o.columns) || o.columns.visible("color"));
  function u({ cellValue: r }) {
    return r || "-";
  }
  return (r, E) => {
    const y = Ve("vxe-tooltip"), b = Ve("vxe-column");
    return o.specMerge ? (w(), Q(Qe, { key: 0 }, [n.value ? (w(), U(b, { key: 0, align: "center", field: "specificationMerge", fixed: e.fixed, "min-width": "180", title: "规格" }, { default: p(({ row: V }) => [s(y, { content: l(Ma)(V), "show-after": 500, placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(V)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [n.value ? (w(), U(b, { key: 0, align: "center", field: "specification", fixed: e.fixed, "min-width": "140", title: "规格" }, { default: p(({ row: V }) => [C("span", null, K(V.specification || "-"), 1)]), _: 1 }, 8, ["fixed"])) : H("", true), c.value ? (w(), U(b, { key: 1, align: "center", field: "color", fixed: e.fixed, width: "120", title: "颜色", formatter: u }, null, 8, ["fixed"])) : H("", true)], 64));
  };
} }, Z$ = { __name: "gas", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, sortable: { type: [String, Boolean], default: false }, returnSortable: { type: [String, Boolean], default: false }, specificationLable: { type: String, default: "规格" } }, setup(e) {
  const o = e, n = Ee(() => Ae(o.columns) || o.columns.visible("specification"));
  return (c, u) => {
    const r = Ve("vxe-tooltip"), E = Ve("vxe-column");
    return o.specMerge ? (w(), Q(Qe, { key: 0 }, [n.value ? (w(), U(E, { key: 0, align: "center", field: "specificationMerge", fixed: e.fixed, "min-width": "180", title: e.specificationLable }, { default: p(({ row: y }) => [s(r, { content: l(Ma)(y), "show-after": 500, placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(y)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed", "title"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [n.value ? (w(), U(E, { key: 0, align: "center", field: "specification", fixed: e.fixed, "min-width": "140", title: o.specificationLable }, { default: p(({ row: y }) => [C("span", null, K(y.specification || "-"), 1)]), _: 1 }, 8, ["fixed", "title"])) : H("", true)], 64));
  };
} }, J$ = { __name: "structure", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, sortable: { type: [String, Boolean], default: false } }, setup(e) {
  const o = e, n = Ee(() => Ae(o.columns) || o.columns.visible("specification"));
  return (c, u) => {
    const r = Ve("vxe-tooltip"), E = Ve("vxe-column");
    return o.specMerge ? (w(), Q(Qe, { key: 0 }, [n.value ? (w(), U(E, { key: 0, align: "center", field: "specificationMerge", fixed: e.fixed, "min-width": "180", title: "规格" }, { default: p(({ row: y }) => [s(r, { content: l(Ma)(y), "show-after": 500, placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(y)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [n.value ? (w(), U(E, { key: 0, align: "center", field: "specification", fixed: e.fixed, "min-width": "180", title: "规格" }, { default: p(({ row: y }) => [C("span", null, K(y.specification || "-"), 1)]), _: 1 }, 8, ["fixed"])) : H("", true)], 64));
  };
} }, X$ = { __name: "enclosure", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, sortable: { type: [String, Boolean], default: false } }, setup(e) {
  const o = e, n = Ee(() => Ae(o.columns) || o.columns.visible("specification"));
  return (c, u) => {
    const r = Ve("vxe-tooltip"), E = Ve("vxe-column");
    return o.specMerge ? (w(), Q(Qe, { key: 0 }, [n.value ? (w(), U(E, { key: 0, align: "center", field: "specificationMerge", fixed: e.fixed, "min-width": "180", title: c.specificationLable }, { default: p(({ row: y }) => [s(r, { content: l(Ma)(y), "show-after": 500, placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(y)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed", "title"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [n.value ? (w(), U(E, { key: 0, align: "center", field: "specification", fixed: e.fixed, "min-width": "140", title: "规格" }, { default: p(({ row: y }) => [C("span", null, K(y.specification || "-"), 1)]), _: 1 }, 8, ["fixed"])) : H("", true)], 64));
  };
} }, $$ = { __name: "raw-mat", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String }, sortable: { type: [String, Boolean], default: false }, specificationLable: { type: String, default: "规格" } }, setup(e) {
  const o = e, n = Ee(() => Ae(o.columns) || o.columns.visible("specification"));
  return (c, u) => {
    const r = Ve("vxe-tooltip"), E = Ve("vxe-column");
    return n.value ? (w(), U(E, { key: 0, align: "center", field: "specificationMerge", fixed: e.fixed, "min-width": "180", title: e.specificationLable }, { default: p(({ row: y }) => [s(r, { content: l(Ma)(y), "show-after": 500, placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(y)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed", "title"])) : H("", true);
  };
} };
const eee = { key: 1 }, tee = { key: 2 }, iee = { key: 0, class: "table-cell-triangle-frozen" }, aee = ["onClick"], lee = { key: 1 }, oee = { __name: "index", props: { specMerge: { type: Boolean, default: false }, specOnly: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, showIndex: { type: Boolean, default: true }, showClassification: { type: Boolean, default: false }, showSerialNumber: { type: Boolean, default: true }, showProject: { type: Boolean, default: false }, showRejectStatus: { type: Boolean, default: false }, showPartyA: { type: Boolean, default: true }, showPartyATransfer: { type: Boolean, default: false }, partyAPosition: { type: String, default: "index" }, showIsWhole: { type: Boolean, default: false }, showOutboundMode: { type: Boolean, default: false }, showOddmentByHalfOut: { type: Boolean, default: false }, showFrozenTip: { type: Boolean, default: false }, frozenViewable: { type: Boolean, default: false }, rejectDetailViewable: { type: Boolean, default: false }, fixed: { type: String }, sortable: { type: Boolean, default: false }, returnSortable: { type: Boolean, default: false }, classifyNameAlias: { type: String, default: "物料种类" }, showTip: { type: Boolean, default: false }, specificationLable: { type: String, default: "规格" }, isSerialNumber: { type: Boolean, default: true }, showOtherIndex: { type: Boolean, default: false } }, emits: ["refresh", "unfreeze-success"], setup(e, { emit: o }) {
  const n = o, c = e, u = ft("isBegin", false), r = Z({}), E = Z(false), y = Z(false), b = Z(0), V = Ee(() => !!(c.basicClass & ho)), M = Ee(() => !c.basicClass || c.basicClass > ua ? 160 : 120), g = Ee(() => Ae(c.columns) || c.columns.visible("classifyName")), S = Ee(() => c.showSerialNumber && (Ae(c.columns) || c.columns.visible("serialNumber"))), h = Ee(() => c.frozenViewable && Ai(sd.frozenDetail)), T = Ee(() => c.sortable === true ? "custom" : false), { maxHeight: _ } = Kt({ mainBox: ".wms-material-freeze-record-view", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, Ee(() => E.value || y.value));
  function f(P) {
    const L = P.sourceRow ? P.sourceRow : P;
    b.value = 0, r.value = JSON.parse(JSON.stringify(L)), E.value = true;
  }
  function m(P) {
    if (!c.rejectDetailViewable) return;
    const L = P.sourceRow ? P.sourceRow : P;
    r.value = JSON.parse(JSON.stringify(L)), y.value = true;
  }
  function R(P, L, O) {
    ++b.value, n("unfreeze-success", P, L, O);
  }
  function v(P) {
    b.value > 0 && n("refresh"), P();
  }
  const N = Ee(() => {
    switch (c.basicClass) {
      case Pe.STEEL_PLATE.V:
        return H$;
      case Pe.SECTION_STEEL.V:
        return q$;
      case Pe.STEEL_COIL.V:
        return G$;
      case Pe.MATERIAL.V:
        return Q$;
      case Pe.GAS.V:
        return Z$;
      case Pe.STRUC_MANUFACTURED.V:
        return X$;
      case Pe.ENCL_MANUFACTURED.V:
        return J$;
      default:
        return $$;
    }
  });
  return (P, L) => {
    var ee;
    const O = Ve("table-cell-tag"), x = Ve("vxe-column"), I = Ve("vxe-tooltip"), Y = Ve("common-dialog");
    return w(), Q(Qe, null, [xt(P.$slots, "indexTag", {}, void 0, true), e.showIndex ? (w(), U(x, { key: 0, align: "center", field: "seq", type: "seq", fixed: e.fixed, title: "序号", width: "55" }, { default: p(({ row: B, rowIndex: q }) => [e.showPartyA && e.partyAPosition === "index" ? (w(), U(O, { key: 0, show: !!B.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : H("", true), e.showOtherIndex ? (w(), Q("span", eee, K(B.showIndex), 1)) : (w(), Q("span", tee, K(q + 1), 1))]), _: 1 }, 8, ["fixed"])) : H("", true), xt(P.$slots, "afterIndex", {}, void 0, true), e.showProject ? (w(), U(x, { key: 1, align: "left", field: "project", fixed: e.fixed, "min-width": "120", title: "项目" }, { default: p(({ row: B }) => [e.showPartyA && e.partyAPosition === "project" ? (w(), U(O, { key: 0, offset: 15, show: !!B.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : H("", true), C("span", null, K(B.project), 1)]), _: 1 }, 8, ["fixed"])) : H("", true), S.value ? (w(), U(x, { key: 2, align: "center", field: e.isSerialNumber ? "serialNumber" : "materialSn", fixed: e.fixed, width: "110", title: "物料编号" }, { default: p(({ row: B }) => [xt(P.$slots, "snTag", { row: B }, void 0, true), e.showPartyATransfer && B.partyATransferType ? (w(), U(O, { key: 0, color: l(Mo).V[B.partyATransferType].COLOR, name: l(Mo).VL[B.partyATransferType], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showIsWhole && B.materialIsWhole === l(Dl).ODDMENT.V ? (w(), U(O, { key: 1, color: l(Dl).V[B.materialIsWhole].COLOR, name: l(Dl).VL[B.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showOddmentByHalfOut ? (w(), U(O, { key: 2, color: B.outboundRelationType === l(gl).CUT.V || B.outboundRelationType === l(gl).CUT_TRANSFER.V ? "#214283" : "#e6a23c", name: B.outboundRelationType === l(gl).CUT.V || B.outboundRelationType === l(gl).CUT_TRANSFER.V ? "切割半出" : "半出余料", show: !!B.boolOddmentByHalfOut }, null, 8, ["color", "name", "show"])) : H("", true), e.showOutboundMode && B.materialOutboundMode === l(Oa).HALF.V ? (w(), U(O, { key: 3, color: l(Oa).V[B.materialOutboundMode].COLOR, name: l(Oa).VL[B.materialOutboundMode], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showOutboundMode && B.basicClass & l(Ci).STEEL_COIL.V && B.length ? (w(), U(O, { key: 4, name: B.boolBasicClassChange ? "出至钢板库" : "条板出库", offset: 15, color: "#e6a23c" }, null, 8, ["name"])) : H("", true), e.showRejectStatus ? (w(), Q(Qe, { key: 5 }, [l(A)(B.rejectStatus) && B.rejectStatus !== l(Wl).NONE.V ? (w(), U(O, { key: 0, class: Zt({ pointer: e.rejectDetailViewable }), color: l(Wl).V[B.rejectStatus].COLOR, name: l(Wl).VL[B.rejectStatus], onClick: (q) => m(B) }, null, 8, ["class", "color", "name", "onClick"])) : H("", true)], 64)) : H("", true), e.showTip && (B.basicClass === l(Ci).STEEL_PLATE.V || B.basicClass === l(Ci).SECTION_STEEL.V) ? (w(), U(O, { key: 6, color: "#f23c3c", offset: 15, show: B.boolReturns || B.boolRemnant, name: "退余料" }, null, 8, ["show"])) : H("", true), C("span", null, K(e.isSerialNumber ? B.serialNumber : B.materialSn), 1)]), _: 3 }, 8, ["field", "fixed"])) : H("", true), e.showClassification && !V.value ? (w(), U(x, { key: 3, align: "center", field: "classification", fixed: e.fixed, width: "100", title: "分类" }, null, 8, ["fixed"])) : H("", true), g.value ? (w(), U(x, { key: 4, align: "center", field: "project", fixed: e.fixed, width: M.value, title: e.classifyNameAlias }, { default: p(({ row: B }) => [e.showFrozenTip && B.boolHasFrozen ? (w(), Q("span", iee)) : H("", true), s(I, { content: B.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [C("span", null, [h.value && B.boolHasFrozen ? (w(), Q("span", { key: 0, class: "freeze-text", onClick: (q) => f(B) }, K(B.classifyName), 9, aee)) : (w(), Q("span", lee, K(B.classifyName), 1))])]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["fixed", "width", "title"])) : H("", true), (w(), U(Ri(N.value), ii({ "basic-class": e.basicClass, columns: e.columns, fixed: e.fixed, "is-show-spec": l(u), returnSortable: e.returnSortable, sortable: T.value, "spec-merge": e.specMerge, "spec-only": e.specOnly, specificationLable: c.specificationLable }, P.$attrs), null, 16, ["basic-class", "columns", "fixed", "is-show-spec", "returnSortable", "sortable", "spec-merge", "spec-only", "specificationLable"])), s(Y, { modelValue: E.value, "onUpdate:modelValue": L[0] || (L[0] = (B) => E.value = B), "before-close": v, title: `冻结记录：${r.value.classifyName} ${((ee = r.value) == null ? void 0 : ee.specification) || ""}`, "custom-class": "wms-material-freeze-record-view", "show-close": "", top: "10vh", width: "1300px" }, { default: p(() => [s(Eu, { material: r.value, "max-height": l(_), onUnfreezeSuccess: R }, null, 8, ["material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"]), s(Y, { modelValue: y.value, "onUpdate:modelValue": L[1] || (L[1] = (B) => y.value = B), title: `退货记录：${r.value.classifyName} ${r.value.specification}`, "custom-class": "wms-material-reject-material-record-view", "show-close": "", top: "10vh", width: "80%" }, { default: p(() => [s(yu, { "basic-class": r.value.basicClass, list: r.value.rejectList, material: r.value, "max-height": l(_), "has-border": "" }, null, 8, ["basic-class", "list", "material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"])], 64);
  };
} }, hc = ut(oee, [["__scopeId", "data-v-b5bb9905"]]), Fb = { __name: "steel", props: { basicClass: { type: Number }, columns: { type: Object }, showBatchNo: { type: Boolean, default: true }, fixed: { type: String, default: "left" } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
        return "炉批号";
      case dt.STEEL_COIL.V:
        return "卷号";
      default:
        return "炉批号/卷号";
    }
  }), c = Ee(() => Ae(o.columns) || o.columns.visible("brand")), u = Ee(() => o.showBatchNo && (Ae(o.columns) || o.columns.visible("heatNoAndBatchNo")));
  function r({ cellValue: E }) {
    return E || "-";
  }
  return (E, y) => {
    const b = Ve("vxe-column");
    return w(), Q(Qe, null, [c.value ? (w(), U(b, { key: "brand", fixed: e.fixed, formatter: r, align: "left", field: "brand", "min-width": "100px", title: "品牌" }, null, 8, ["fixed"])) : H("", true), u.value ? (w(), U(b, { key: "heatNoAndBatchNo", fixed: e.fixed, formatter: r, title: n.value, align: "left", field: "heatNoAndBatchNo", "min-width": "150px" }, null, 8, ["fixed", "title"])) : H("", true)], 64);
  };
} }, nee = { __name: "raw-mat", props: { basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String } }, setup(e) {
  const o = e, n = Ee(() => Ae(o.columns) || o.columns.visible("brand"));
  function c({ cellValue: u }) {
    return u || "-";
  }
  return (u, r) => {
    const E = Ve("vxe-column");
    return n.value ? (w(), U(E, { key: "brand", fixed: e.fixed, formatter: c, align: "left", field: "brand", "min-width": "100px", title: "品牌" }, null, 8, ["fixed"])) : H("", true);
  };
} }, zb = { __name: "manuf-mat", props: { basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String } }, setup(e) {
  const o = e, n = Ee(() => Ae(o.columns) || o.columns.visible("length"));
  function c({ cellValue: u }) {
    return u || "-";
  }
  return (u, r) => {
    const E = Ve("vxe-column");
    return n.value ? (w(), U(E, { key: "length", fixed: e.fixed, formatter: c, align: "center", field: "length", "min-width": "100px", title: "长度 (mm)" }, null, 8, ["fixed"])) : H("", true);
  };
} }, fc = { __name: "index", props: { basicClass: { type: Number }, columns: { type: Object }, showBatchNo: { type: Boolean, default: true }, fixed: { type: String }, isVxe: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = Ee(() => {
    if (o.basicClass & ua) return Fb;
    if (o.basicClass & ho) return zb;
    switch (o.basicClass) {
      case Ge.STEEL_PLATE.V:
      case Ge.SECTION_STEEL.V:
      case Ge.STEEL_COIL.V:
        return Fb;
      case Ge.STRUC_MANUFACTURED.V:
      case Ge.ENCL_MANUFACTURED.V:
        return zb;
      case Ge.MATERIAL.V:
      case Ge.GAS.V:
      default:
        return nee;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), { basicClass: e.basicClass, columns: e.columns, fixed: e.fixed, "show-batch-no": e.showBatchNo }, null, 8, ["basicClass", "columns", "fixed", "show-batch-no"]));
} };
const see = { key: 0, class: "logistics-form form" }, ree = { __name: "logistics-form", props: { disabled: { type: Boolean, default: false }, form: { type: Object, default: () => ({}) }, showType: { type: String, default: "submit" } }, setup(e, { expose: o }) {
  const n = e, { inboundFillWayCfg: c } = aa(), u = Z(), r = Z({});
  Dt(() => {
    r.value = n.form;
  });
  const E = Ee(() => n.showType === "submit" && (y.value || b.value || V.value || M.value || g.value) || n.showType !== "submit"), y = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.money === m : true;
  }), b = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.weight === m : true;
  }), V = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.loadingFee === m : true;
  }), M = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.invoiceTax === m : true;
  }), g = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.logisticsUnit === m : true;
  }), _ = { freight: [{ required: true, message: "请输入运费", trigger: "blur" }, { validator: (m, R, v) => {
    A(r.value.supplierId) && Ae(r.value.freight) && v(new Error("请输入运费")), v();
  }, trigger: "blur" }], freightWeight: [{ validator: (m, R, v) => {
    A(r.value.freightWeight) && (r.value.freightWeight || v(new Error("运输重量必须大于0"))), v();
  }, trigger: "blur" }], supplierId: [{ validator: (m, R, v) => {
    A(r.value.freight) && Ae(r.value.supplierId) && v(new Error("请选择供应商")), v();
  }, trigger: "change" }] };
  async function f() {
    try {
      return u.value ? await u.value.validate() : true;
    } catch {
      return false;
    }
  }
  return o({ validate: f }), (m, R) => {
    const v = Ml, N = Ve("common-input-number"), P = Zi, L = Li;
    return E.value ? (w(), Q("div", see, [s(v, null, { default: p(() => R[6] || (R[6] = [C("span", { class: "title" }, "物流信息", -1)])), _: 1, __: [6] }), s(L, { ref_key: "formRef", ref: u, model: r.value, disabled: n.disabled, rules: _, size: "default", inline: "", "label-position": "right", "label-width": "80px" }, { default: p(() => [e.showType === "submit" && y.value || e.showType !== "submit" ? (w(), U(P, { key: 0, label: "运费", prop: "freight", "label-width": "60px" }, { default: p(() => [s(N, { class: "input-underline", modelValue: r.value.freight, "onUpdate:modelValue": R[0] || (R[0] = (O) => r.value.freight = O), type: "text", min: 0, max: 999999999, disabled: !y.value, precision: l(Ze).YUAN, controls: false, placeholder: "运费", style: { width: "150px" } }, null, 8, ["modelValue", "disabled", "precision"])]), _: 1 })) : H("", true), e.showType === "submit" && b.value || e.showType !== "submit" ? (w(), U(P, { key: 1, label: "运输重量（kg）", prop: "freightWeight", "label-width": "120px" }, { default: p(() => [s(N, { class: "input-underline", modelValue: r.value.freightWeight, "onUpdate:modelValue": R[1] || (R[1] = (O) => r.value.freightWeight = O), type: "text", disabled: !b.value, min: 0, max: 999999999, precision: l(Ze).COM_WT__KG, controls: false, placeholder: "运输重量", style: { width: "150px" } }, null, 8, ["modelValue", "disabled", "precision"])]), _: 1 })) : H("", true), e.showType === "submit" && V.value || e.showType !== "submit" ? (w(), U(P, { key: 2, label: "装车费", prop: "loadingCharge" }, { default: p(() => [s(N, { class: "input-underline", modelValue: r.value.loadingCharge, "onUpdate:modelValue": R[2] || (R[2] = (O) => r.value.loadingCharge = O), min: 0, max: 999999999, disabled: !V.value, precision: l(Ze).YUAN, controls: false, size: "default", placeholder: "装车费", style: { width: "150px" } }, null, 8, ["modelValue", "disabled", "precision"])]), _: 1 })) : H("", true), e.showType === "submit" && M.value || e.showType !== "submit" ? (w(), U(P, { key: 3, class: "el-form-item-10", label: "发票及税率", prop: "invoiceType", "label-width": "100px" }, { default: p(() => [s(Xn, { class: "input-underline", invoiceType: r.value.invoiceType, "onUpdate:invoiceType": R[3] || (R[3] = (O) => r.value.invoiceType = O), taxRate: r.value.taxRate, "onUpdate:taxRate": R[4] || (R[4] = (O) => r.value.taxRate = O), disabled: r.value.boolUsed || !M.value, default: M.value, taxDefault: M.value, classification: l(Yn).LOGISTICS.V }, null, 8, ["invoiceType", "taxRate", "disabled", "default", "taxDefault", "classification"])]), _: 1 })) : H("", true), e.showType === "submit" && g.value || e.showType !== "submit" ? (w(), U(P, { key: 4, label: "物流单位", prop: "supplierId" }, { default: p(() => [s(k_, { class: "input-underline", modelValue: r.value.supplierId, "onUpdate:modelValue": R[5] || (R[5] = (O) => r.value.supplierId = O), type: l(vo).LOGISTICS.V, disabled: !g.value, placeholder: "可选择供应商搜索", style: { width: "250px" }, "logistics-createable": "", "show-type": false, clearable: "" }, null, 8, ["modelValue", "type", "disabled"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["model", "disabled"])])) : H("", true);
  };
} }, U3 = ut(ree, [["__scopeId", "data-v-9a0ff727"]]), uee = Object.freeze(Object.defineProperty({ __proto__: null, default: U3 }, Symbol.toStringTag, { value: "Module" })), n2 = { __name: "project-select-storage", props: { modelValue: { type: [Number, String], default: void 0 }, dataStructure: { type: Object, default: () => ({ key: "id", label: "name", value: "id" }) }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择项目" }, defaultOptions: { type: Array, default: () => [] }, isFirst: { type: Boolean, default: false } }, emits: ["update:modelValue", "change", "projectChange"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(false), r = Z(), E = Ee(() => c.defaultOptions || []);
  Ce(() => c.modelValue, (b) => {
    r.value = b, y(r.value);
  }, { immediate: true });
  function y(b) {
    var V;
    if (c.isFirst) {
      const M = !el(b, c.modelValue), g = Ae(b) && Ae(c.modelValue);
      if (M && !g) {
        n("update:modelValue", b), n("change", b);
        const S = E.value.find((h) => h.id === b) || {};
        n("projectChange", S);
      }
    } else {
      n("update:modelValue", b), n("change", b);
      const M = ((V = E.value) == null ? void 0 : V.find((g) => g.id === b)) || {};
      n("projectChange", M);
    }
  }
  return (b, V) => {
    const M = jt, g = Ve("common-select-v2");
    return w(), U(g, { modelValue: r.value, "onUpdate:modelValue": V[0] || (V[0] = (S) => r.value = S), clearable: e.clearable, "data-structure": e.dataStructure, disabled: c.disabled, loading: u.value, multiple: e.multiple, options: E.value, placeholder: e.placeholder, size: e.size, type: "other", filterable: "", onChange: y }, { view: p(({ data: S }) => [s(M, { class: "item", effect: "dark", content: S[e.dataStructure.label], placement: "left" }, { default: p(() => [C("span", null, K(S[e.dataStructure.label]), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["modelValue", "clearable", "data-structure", "disabled", "loading", "multiple", "options", "placeholder", "size"]);
  };
} }, go = { __name: "project-set-columns-vxe", props: { order: { type: Object, default: () => ({}) }, requisitions: { type: Object, default: () => ({}) }, list: { type: Array, default: () => [] }, form: { type: Object, default: () => ({}) }, unShowExtra: { type: Boolean, default: false } }, setup(e) {
  const { projectAllType: o } = Wa(), n = e;
  ud();
  const c = Ee(() => {
    const u = n.order;
    if (A(u)) {
      if (A(u.projects)) return u.projects.map((r) => ({ id: r.id, name: di(r, { showSerialNumber: true }) }));
      {
        const r = [];
        return o.value.forEach((E) => {
          (E.projectAttribute === u.projectAttribute && E.level === Bt.FACTORY.V || E.level === 3) && r.push(E);
        }), (r == null ? void 0 : r.map((E) => ({ id: E.id, name: di(E, { showSerialNumber: true }) }))) || [];
      }
    } else {
      const r = [];
      return o.value.forEach((E) => {
        E.level === Bt.FACTORY.V && r.push(E);
      }), r.map((E) => ({ id: E.id, name: di(E, { showSerialNumber: true }) }));
    }
  });
  return (u, r) => {
    const E = Ve("vxe-column");
    return w(), U(E, { align: "center", title: "所属项目", "min-width": "180px", field: "projectId" }, { default: p(({ row: y, rowIndex: b }) => [s(n2, { modelValue: y.projectId, "onUpdate:modelValue": (V) => y.projectId = V, "show-extra": b !== 0 && !e.unShowExtra, defaultOptions: c.value, clearable: "", placeholder: "所属项目", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "defaultOptions"])]), _: 1 });
  };
} }, cee = Object.freeze(Object.defineProperty({ __proto__: null, default: go }, Symbol.toStringTag, { value: "Module" })), dee = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.workshopNameV3);
  if (n.value || o.dispatch("config/fetchWorkshopNameV3"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { workshopNameV3: Ee(() => o.state.config.workshopNameV3), workshopNameV3KV: Ee(() => o.state.config.workshopNameV3KV), loaded: n };
}, Mr = { __name: "workshop-select-v3", props: { modelValue: { type: [Array, Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择车间" }, type: { type: [Number, String], default: void 0 }, showExtra: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), { loaded: r, workshopNameV3: E } = dee(), y = Ee(() => {
    let V = E.value;
    return c.type && (V = c.type === lu.NORMAL.V ? V.filter((M) => !M.workshopId) : V.filter((M) => M.workshopId)), V;
  });
  Ce(() => c.modelValue, (V) => {
    u.value = V;
  }, { immediate: true });
  function b(V) {
    let M = V;
    Ae(M) && (M = void 0);
    const g = !el(M, c.modelValue), S = Ae(M) && Ae(c.modelValue);
    g && !S && (n("update:modelValue", M), n("change", M));
    const h = y.value.find((T) => T.id === M);
    n("changeData", h);
  }
  return (V, M) => {
    const g = jt, S = Ve("common-select-v2");
    return w(), U(S, ii({ modelValue: u.value, "onUpdate:modelValue": M[0] || (M[0] = (h) => u.value = h), allLabelText: "全部", clearable: e.clearable, disabled: e.disabled, loading: !l(r), multiple: e.multiple, options: y.value, placeholder: e.placeholder, showExtra: e.showExtra, showOptionAll: e.showOptionAll, size: e.size, filterable: "" }, V.$attrs, { onChange: b }), { view: p(({ data: h }) => [s(g, { class: "item", effect: "dark", content: h.name, placement: "left" }, { default: p(() => [C("span", null, K(h.name), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 16, ["modelValue", "clearable", "disabled", "loading", "multiple", "options", "placeholder", "showExtra", "showOptionAll", "size"]);
  };
} }, Vm = { __name: "warehouse-set-columns-vxe-dialog", props: { boolManuf: { type: Boolean, default: false }, showWarehouse: { type: Boolean, default: true }, list: { type: Array, default: () => {
} } }, setup(e) {
  const o = e, n = Z({ list: [] });
  Dt(() => {
    n.value = { list: o.list };
  });
  function c(u) {
    u.warehouseId = void 0;
  }
  return (u, r) => {
    const E = Ve("vxe-column");
    return w(), Q(Qe, null, [s(E, { align: "center", field: "workshopId", "min-width": "140px", title: "仓库" }, { default: p(({ row: y }) => [s(Mr, { modelValue: y.workshopId, "onUpdate:modelValue": (b) => y.workshopId = b, placeholder: "请选择仓库", style: { width: "100%" }, onChange: (b) => c(y) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), e.showWarehouse ? (w(), U(E, { key: 0, align: "center", field: "warehouseId", "min-width": "140px", title: "存储位置" }, { default: p(({ row: y }) => [s(xs, { modelValue: y.warehouseId, "onUpdate:modelValue": (b) => y.warehouseId = b, "basic-class": y.basicClass, "workshop-id": y.workshopId, placeholder: "存储位置", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "workshop-id"])]), _: 1 })) : H("", true)], 64);
  };
} }, mee = Object.freeze(Object.defineProperty({ __proto__: null, default: Vm }, Symbol.toStringTag, { value: "Module" }));
function Rn(e, o = -1) {
  const n = Z([]);
  return { scopeList: n, getNotDittoArr: () => n.value.map((c) => c.start), initScopeList: (c, u) => pee(c, u, { scopeList: n, dittoKey: e, dittoVal: o }), handleValueChange: (c, u) => hee(c, u, { scopeList: n, dittoVal: o }), getRealVal: (c) => fee(c, { scopeList: n }) };
}
function pee(e, o, { scopeList: n, dittoKey: c, dittoVal: u }) {
  if (typeof o == "function" && o({ scopeList: n, dittoKey: c, dittoVal: u }), n.value = [], Ae(e)) return;
  let r = 0, E = -1, y;
  for (let b = 0; b < e.length; b++) {
    const V = e[b][c];
    V === u ? ++E : (E !== -1 && n.value.push({ start: r, end: E, val: y }), r = b, E = b, y = V);
  }
  n.value.push({ start: r, end: E, val: y });
}
function hee(e, o, { scopeList: n, dittoVal: c }) {
  const u = n.value.findIndex((E) => o >= E.start && o <= E.end), r = n.value[u];
  if (!Ae(r)) if (e !== c) if (o === r.start) r.val = e;
  else {
    const E = { start: o, end: r.end, val: e };
    r.end = o - 1, n.value.splice(u + 1, 0, E);
  }
  else {
    const E = u - 1;
    if (o === r.start) if (E > -1) {
      const y = n.value[E];
      y.end = r.end, y.val = void 0, n.value.splice(u, 1);
    } else r.val = void 0;
  }
}
function fee(e, { scopeList: o }) {
  for (const n of o.value) if (e >= n.start && e <= n.end) return n.val;
}
const Y3 = { __name: "warehouse-set-columns-manuf-vxe", props: { parentList: { type: Array, default: () => [] }, boolManuf: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = Z([]);
  Dt(() => {
    n.value = o.parentList;
  });
  const { getNotDittoArr: c, initScopeList: u, handleValueChange: r, getRealVal: E } = Rn("workshopId"), y = Ee(() => c()), b = Ee(() => n.value || []);
  Dt(() => u(b.value));
  function V(M, g, S) {
    r(M, g), M !== -1 ? S.warehouseId = void 0 : pt(() => {
      Ae(S.warehouseId) && (S.warehouseId = -1);
    });
  }
  return (M, g) => {
    const S = Ve("vxe-column");
    return w(), Q(Qe, null, [s(S, { field: "workshopId", align: "center", "min-width": "140px", title: "仓库" }, { default: p(({ row: h, rowIndex: T }) => [s(Mr, { modelValue: h.workshopId, "onUpdate:modelValue": (_) => h.workshopId = _, placeholder: "请选择仓库", "show-extra": T !== 0, style: { width: "100%" }, onChange: (_) => V(_, T, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), s(S, { field: "warehouseId", title: "存储位置", "min-width": "140px", align: "center" }, { default: p(({ row: h, rowIndex: T }) => {
      var _, f;
      return [s(xs, { modelValue: h.warehouseId, "onUpdate:modelValue": (m) => h.warehouseId = m, "workshop-id": l(E)(T), "basic-class": h.basicClass, style: { width: "100%" }, "show-extra": b.value[T - 1] && ((_ = b.value[T]) == null ? void 0 : _.basicClass) === ((f = b.value[T - 1]) == null ? void 0 : f.basicClass) && !y.value.includes(T), placeholder: "存储位置" }, null, 8, ["modelValue", "onUpdate:modelValue", "workshop-id", "basic-class", "show-extra"])];
    }), _: 1 })], 64);
  };
} }, gee = Object.freeze(Object.defineProperty({ __proto__: null, default: Y3 }, Symbol.toStringTag, { value: "Module" }));
const Eee = { __name: "title-after-info", props: { order: { type: Object, default: () => ({}) }, detail: { type: Object, default: () => ({}) } }, setup(e) {
  const o = e, n = Ee(() => o.detail.basicClass & ua && o.order.weightMeasurementMode !== Wt.THEORY.V && o.detail.loadingWeight !== null && o.detail.loadingWeight !== void 0);
  return (c, u) => {
    const r = wi, E = _t("parse-enum");
    return w(), Q(Qe, null, [e.detail.licensePlate ? (w(), U(r, { key: 0, effect: "plain" }, { default: p(() => [Te(K(`车牌：${e.detail.licensePlate}`), 1)]), _: 1 })) : H("", true), e.detail.shipmentNumber ? (w(), U(r, { key: 1, effect: "plain" }, { default: p(() => [Te(K(`物流单号：${e.detail.shipmentNumber}`), 1)]), _: 1 })) : H("", true), n.value ? (w(), U(r, { key: 2, effect: "plain" }, { default: p(() => [Te(K(`过磅重量：${e.detail.loadingWeight}${l(ei).weight.unit}`), 1)]), _: 1 })) : H("", true), e.order.supplyType ? qe((w(), U(r, { key: 3, type: "info", effect: "plain" }, null, 512)), [[E, { e: l(Ni), v: e.order.supplyType }]]) : H("", true), e.order.weightMeasurementMode ? qe((w(), U(r, { key: 4, type: "info", effect: "plain" }, null, 512)), [[E, { e: l(Wt), v: e.order.weightMeasurementMode }]]) : H("", true), e.order.purchaseOrderPaymentMode ? qe((w(), U(r, { key: 5, type: "info", effect: "plain" }, null, 512)), [[E, { e: l(Jl), v: e.order.purchaseOrderPaymentMode }]]) : H("", true)], 64);
  };
} }, s2 = ut(Eee, [["__scopeId", "data-v-f56bf9b9"]]), yee = Object.freeze(Object.defineProperty({ __proto__: null, default: s2 }, Symbol.toStringTag, { value: "Module" }));
function K3(e, { weightField: o = "weighingTotalWeight", compareWeightField: n = "theoryTotalWeight", weightTip: c = "理论重量" } = {}) {
  const { loaded: u, inboundSteelCfg: r } = aa(), E = Ee(() => r.value), y = Ee(() => u ? E.value.steelDiffType === bo.PERCENTAGE.V ? `实际重量与${c}的误差不可超过${c}的${E.value.steelDiff || 0}%` : `实际重量与${c}的误差不可超过${E.value.steelDiff || 0} ${nr}` : "请等待wms钢材入库重量配置信息加载后再试");
  function b(M, g) {
    return !!(g || !M);
  }
  function V(M, g, { weightCfg: S, baseUnit: h }) {
    if (!u) return "请等待wms钢材入库重量配置信息加载后再试";
    if (Ae(M) && Ae(g)) return;
    let T = false;
    const _ = M - g, f = S.value.steelDiff, m = S.value.steelDiffType;
    return m === bo.PERCENTAGE.V && (T = Math.abs(parseInt(M / g * Math.pow(10, 5) - 1 * Math.pow(10, 5))) / Math.pow(10, 5) * 100 > f), m === bo.NUMBER.V && (T = St(Math.abs(M - g), h.value.weight.unit, nr, h.value.weight.precision) > f), { hasOver: T, overNum: _ };
  }
  return { transOverDiffTip: y, currentCfg: E, transWeightOverDiff: (M, g) => V(M, g, { weightCfg: E, baseUnit: e }), transDiffSubmitValidate: (M) => b(M, r.value.overDiffSubmittable) };
}
function Us({ quantityField: e = "quantity", meteField: o = "mete" }) {
  return { handleOverQuantity: (u, r = false, E = "purchaseQuantity") => {
    u[e] > u[E] && u[e] !== u.originQuantity && (u.mergeId || r) ? zi.confirm("本次实收数大于采购数，请确认", "提示", { confirmButtonText: "是", cancelButtonText: "否", type: "warning" }).then(() => {
      u.originQuantity = u[e];
    }).catch(() => {
      u[e] = u.originQuantity;
    }) : u.originQuantity = u[e];
  }, handleOverMete: (u) => {
    u[o] > u.purchaseMete && u[o] !== u.originMete && u.mergeId ? zi.confirm("本次实收量大于采购量，请确认", "提示", { confirmButtonText: "是", cancelButtonText: "否", type: "warning" }).then(() => {
      u.originMete = u[o];
    }).catch(() => {
      u[o] = u.originMete;
    }) : u.originMete = u[o];
  } };
}
const W3 = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.closeTimes);
  if (n.value || o.dispatch("config/fetchCloseTime"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { closeTimes: Ee(() => o.state.config.closeTimes), lastTime: Ee(() => A(o.state.config.closeTimes) ? o.state.config.closeTimes[o.state.config.closeTimes.length - 1] : {}), loaded: n };
}, gc = { __name: "closing-time-form-vxe", props: { columns: { type: Object }, fixed: { type: String }, showLabel: { type: String, default: "实际时间" }, showSourceRow: { type: Boolean, default: false } }, setup(e) {
  const { loaded: o, lastTime: n } = W3();
  function c(E) {
    return A(n.value) && n.value.endTime ? E.getTime() < Number(n.value.endTime) + 1 * 1e3 || E.getTime() > (/* @__PURE__ */ new Date()).getTime() : E.getTime() > (/* @__PURE__ */ new Date()).getTime();
  }
  const u = e, r = Ee(() => {
    const E = fr();
    return E && E === Qn.SELF.V && (Ae(u.columns) || u.columns.visible("realTime"));
  });
  return (E, y) => {
    const b = Rl, V = Ve("vxe-column");
    return r.value ? (w(), U(V, { key: 0, align: "right", field: "realTime", title: e.showLabel, width: "230px" }, { default: p(({ row: M }) => [s(b, { modelValue: M.realTime, "onUpdate:modelValue": (g) => M.realTime = g, type: "datetime", "value-format": "x", disabled: !l(o), disabledDate: c, placeholder: e.showLabel, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "placeholder"])]), _: 1 }, 8, ["title"])) : H("", true);
  };
} };
function as() {
  const e = fr();
  function o(n) {
    return e === Qn.SELF.V ? !!n : true;
  }
  return { realTimeValidate: (n, c) => o(n) };
}
const Tee = { key: 0 }, _ee = { class: "inventory" }, bee = { class: "right-box" }, Vee = { key: 0, class: "head-container", style: { "margin-top": "15px" } }, wee = { class: "filter-item" }, See = { key: 1 }, vee = { __name: "confirm-dialog", props: { modelValue: { type: Boolean, default: false }, basicClass: { type: Number }, isManuf: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:modelValue"], setup(e, { emit: o }) {
  const { realTimeValidate: n } = as(), { user: c } = ka(["user"]);
  Z(false);
  const u = Ee(() => ei), { overDiffTip: r, weightOverDiff: E, diffSubmitValidate: y } = Va(u, { cfgType: "inbound", weightField: "weighingTotalWeight", compareWeightField: "theoryTotalWeight", weightTip: "理论重量" }), { handleOverMete: b } = Us({ meteField: "weighingTotalWeight" }), V = Ht(), M = o, { transOverDiffTip: g, transWeightOverDiff: S } = K3(u, { cfgType: "inbound", weightField: "loadingWeight", compareWeightField: "theoryTotalWeight", weightTip: "理论重量" }), h = e, T = Z([]), _ = Z([]), f = Z([]), m = Z(false), { visible: R, handleClose: v } = Ta({ emit: M, props: h, showHook: de, closeHook: we }), { cu: N, form: P, FORM: L } = Wi(), { inboundFillWayCfg: O } = aa(), { projectsAll: x } = Er(), I = Z([{ seq: "合计", quantity: "-", mete: "-", weighingTotalWeight: "-", showManufWeight: "-", amount: "-" }]), Y = Z([{ seq: "合计", quantity: "-", theoryTotalWeight: "-", weighingTotalWeight: "-", amount: "-" }]), ee = Z({ resizable: true }), B = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: false, threshold: 80 }), q = Z(), ae = Ee(() => Ae(N.props.order) ? {} : N.props.order.supplyType === Ni.PARTY_A.V ? { ...N.props.order, projects: x.value } : N.props.order), j = Ee(() => O.value ? Ae(ae.value.detail) ? O.value.amountFillWay === $l.APPLICATION.V : O.value.saveInboundState === Sl.MODIFY.V || O.value.saveInboundState === Sl.SHOW.V || O.value.saveInboundState === Sl.UNSHOW.V && O.value.passedInboundState === Sl.UNSHOW.V : false), le = Z(true), oe = Ee(() => ae.value.logisticsPayerType === Bi.DEMAND.V), ye = Ee(() => {
    var Oe;
    return ((Oe = ae.value) == null ? void 0 : Oe.supplyType) === Ni.PARTY_A.V;
  }), ce = Ee(() => h.isManuf || ae.value.materialType === va.MANUFACTURED.V), se = Ee(() => {
    const Oe = j.value && !ye.value && (ae.value.projects && ae.value.requisitionsSN || le.value), Re = j.value && ye.value && ae.value.projects && ae.value.requisitionsSN && le.value;
    return !(Oe || Re);
  }), he = Z({}), be = (Oe, Re) => !!A(Oe), me = (Oe, Re) => !!A(Oe), Le = { weighingTotalWeight: [{ validator: (Oe, Re) => Re.weightMeasurementMode === Wt.OVERWEIGHT.V && (Re.basicClass & Ge.STEEL_PLATE.V || Re.basicClass & Ge.SECTION_STEEL.V) ? Oe ? y(Oe, Re) : false : true, message: "超出误差允许范围,不可提交", trigger: "blur" }] }, Ie = { workshopId: [{ validator: be, message: "请选择仓库", trigger: "change" }], warehouseId: [{ validator: me, message: "请选择存储位置", trigger: "change" }] }, Se = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, X = {}, $ = Ee(() => {
    var fe;
    const Oe = { ...Ie };
    return j.value && !ye.value && Object.assign(Oe, Se), A(ae.value.projects) && (ye.value || !((fe = ae.value) != null && fe.boolApplyPurchase)) && Object.assign(Oe, X), Object.assign(Oe, { realTime: [{ validator: n, message: "请选择实际入库时间", trigger: "change" }] }), ce.value || Object.assign(Oe, Le), Oe;
  }), { maxHeight: k } = Kt({ mainBox: ".inbound-application-preview", extraBox: [".el-dialog__header", ".logistics-form-content", ".footer"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, R), J = Ee(() => A(T.value) && A(_.value) ? (k.value - 80) / 2 : k.value - 80);
  function z(Oe) {
    if (Ae(Oe)) return;
    const Re = /* @__PURE__ */ new Map([["workshopId", -1]]);
    let fe = Oe[0].basicClass;
    for (let Ue = 1; Ue < Oe.length; Ue++) {
      const Je = Oe[Ue];
      fe === Je.basicClass ? G.forEach((Xe, Ye) => {
        Ae(Je[Ye]) && (Je[Ye] = Xe);
      }) : (Re.forEach((Xe, Ye) => {
        Ae(Je[Ye]) && (Je[Ye] = Xe);
      }), fe = Je.basicClass);
    }
  }
  function F(Oe, Re = /* @__PURE__ */ new Map()) {
    const fe = _s(Oe);
    Oe.length = 0, fe.forEach((Je, Xe) => {
      Re.forEach((et, lt) => {
        Je[lt] === et && delete Je[lt];
      }), delete Je.uid, Ps(Je).some((et) => A(et)) && Oe.push(Je);
    });
    const Ue = /* @__PURE__ */ new Map();
    return Oe.forEach((Je) => {
      delete Je.verify, Re.forEach((Xe, Ye) => {
        Ae(Je[Ye]) ? Je[Ye] = Ue.get(Ye) : Ue.set(Ye, Je[Ye]), ["projectId", "monomerId", "areaId"].indexOf(Ye) > -1 && A(Je.purchaseProjectDisabled) && Je.purchaseProjectDisabled && (Je[Ye] = void 0);
      });
    }), Oe;
  }
  const G = /* @__PURE__ */ new Map([["workshopId", -1], ["warehouseId", -1]]);
  yi("ditto", G);
  const ie = Z(false), { tableValidate: ue, wrongCellMask: ne } = ui({ rules: $, ditto: G });
  Ce(() => N == null ? void 0 : N.submitResult, () => {
    var Oe;
    ((Oe = N == null ? void 0 : N.submitResult) == null ? void 0 : Oe.code) === 40206 && (V.dispatch("config/fetchMatClsTree"), N.submitResult.code = null, V.state.config.classifySpec = { specKV: [] });
  }, { deep: true });
  function te({ row: Oe, rowIndex: Re }) {
    var fe, Ue, Je;
    if ((Ue = (fe = N == null ? void 0 : N.submitResult) == null ? void 0 : fe.data) != null && Ue.includes(Oe.classifyId) && ((Je = N == null ? void 0 : N.submitResult) == null ? void 0 : Je.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  function de() {
    ie.value = true, P.originLoadingWeight = P.loadingWeight, _.value = [], T.value = [], P.list.map((Xe) => {
      var Ye, Fe;
      Xe.originMete = Xe.mete, Xe.realTime = (/* @__PURE__ */ new Date()).getTime(), (ye.value || (Ye = P.selectObj[Xe.mergeId]) != null && Ye.isSelected || !ye.value && Ae((Fe = ae.value) == null ? void 0 : Fe.details)) && (Xe.weightMeasurementMode === Wt.OVERWEIGHT.V && (Xe.basicClass & Ge.STEEL_PLATE.V || Xe.basicClass & Ge.SECTION_STEEL.V) ? (Xe.showIndex = _.value.length + 1, _.value.push(Xe)) : (Xe.showIndex = T.value.length + 1, T.value.push(Xe)));
    });
    let Oe = 0, Re = 0, fe = 0, Ue = 0, Je = 0;
    T.value.forEach((Xe) => {
      Oe += Xe.quantity || 0, Re += Xe.mete || 0, fe += Xe.weighingTotalWeight || 0, Ue += Xe.amount || 0, Je += Xe.showManufWeight || 0;
    }), Re = Re.toFixed(ei.weight.precision), fe = fe.toFixed(ei.weight.precision), Ue = Ue.toFixed(Ze.YUAN), Je = Je.toFixed(3), I.value = [{ seq: "合计", quantity: Oe, mete: Re, weighingTotalWeight: fe, showManufWeight: Je, amount: Ue }], Me(), ce.value && z(T.value), N.status.edit >= 1 && P.loadingWeight && (m.value = true), setTimeout(() => {
      ie.value = false;
    }, 100);
  }
  const pe = Ee(() => {
    let Oe = 0;
    return P.list.forEach((Re) => {
      A(Re.mete) && (Oe += +Re.mete);
    }), Oe ? Oe.toFixed(ei.weight.precision) : 0;
  });
  N.submitFormFormat = async (Oe) => {
    m.value || (Oe.loadingWeight = null), Oe.loginUserId = c.value.id;
    const Re = At(Oe.list);
    return Oe.list = await Ut(Re, { toSmallest: true, toNum: true }), Oe.list.forEach((fe) => {
      var Ue;
      ce.value && (fe.projectId = (Ue = ae.value.projects) != null && Ue.length ? ae.value.projects[0].id : void 0), fe.originBoolApplyPurchase || (fe.applyPurchaseId = void 0);
    }), Oe.supplyType & Ni.PARTY_A.V && (Oe.purchaseId = void 0), Ae(Oe.logistics) && (Oe.logistics = void 0), ae.value.logisticsPayerType === Bi.SUPPLIER.V && (Oe.logistics = void 0), Oe;
  };
  const re = ft("steelDensityCfg");
  L.HOOK.beforeSubmit = async () => {
    if (await V.dispatch("wms/fetchSteelDensityCfg"), P.loadingWeight && he.value.hasOver && m.value) return ot.error("超出误差允许范围"), false;
    if (h.basicClass & ct.STEEL.V) {
      const Ue = [];
      let Je = [];
      if (P.list.forEach((Xe) => {
        (Xe.basicClass === Pe.STEEL_PLATE.V || Xe.basicClass === Pe.STEEL_COIL.V) && Xe.steelDensity !== re.value[Xe.classifyId] && (Ue.push(`<div>【${Xe.classifyName}】最新设置密度与该单据创建时设置密度不一致！！！</div>`), Xe.steelDensity = re.value[Xe.classifyId]);
      }), Je = Array.from(new Set(Ue)), Je.length) {
        const Xe = Je.join("");
        ot({ message: Xe, dangerouslyUseHTMLString: true, type: "warning", duration: 5e3 });
      }
    }
    let Oe = true;
    if (A(_.value)) {
      const { validResult: Ue, dealList: Je } = ue(_.value);
      Oe = Ue, Ue && (_.value = Je, _.value.forEach((Xe) => {
        Xe.mete = Xe.weighingTotalWeight;
      }));
    }
    if (A(T.value)) {
      const { validResult: Ue, dealList: Je } = ue(T.value);
      Oe = Ue, Ue && (T.value = Je);
    }
    let Re = true;
    if (ce.value && T.value) {
      const { validResult: Ue } = ue(T.value);
      if (Re = Ue, Ue) {
        const Je = At(T.value);
        F(Je, G), Je.forEach((Xe, Ye) => {
          T.value[Ye].workshopId = Xe.workshopId, T.value[Ye].warehouseId = Xe.warehouseId;
        });
      }
    }
    let fe = true;
    return oe.value && q.value && (fe = await q.value.validate()), Oe && fe && Re;
  }, L.HOOK.afterSubmit = () => {
    P.selectObj = {}, v();
  };
  function we() {
    f.value = [];
  }
  const Ke = Ee(() => () => {
    let Oe = 0;
    return A(_.value) && _.value.filter((Re) => {
      Oe += Re.theoryTotalWeight ? Re.theoryTotalWeight : 0;
    }), Oe;
  });
  function Me() {
    let Oe = 0, Re = 0, fe = 0, Ue = 0;
    _.value.forEach((Je) => {
      Oe += Je.quantity || 0, Re += Je.theoryTotalWeight || 0, fe += Je.weighingTotalWeight || 0, Ue += Je.amount || 0;
    }), Re = Re.toFixed(ei.weight.precision), fe = fe.toFixed(ei.weight.precision), Ue = Ue.toFixed(Ze.YUAN), Y.value = [{ seq: "合计", quantity: Oe, theoryTotalWeight: Re, weighingTotalWeight: fe, amount: Ue }];
  }
  function Ne() {
    if (!P.loadingWeight) {
      ot.warning("请先输入过磅重量");
      return;
    }
    let Oe = [], Re = 0;
    if (A(_.value) && (Oe = _.value.filter((Je) => (Re += Je.theoryTotalWeight ? Je.theoryTotalWeight : 0, Je.theoryTotalWeight))), he.value = S(P.loadingWeight, Re), he.value.hasOver) {
      ot.error("超出误差允许范围");
      return;
    }
    let fe = P.loadingWeight - Re;
    const Ue = (Je) => {
      Je.weighingTotalWeight = fe ? ji(Je.theoryTotalWeight / Re * fe + Je.theoryTotalWeight, ei.weight.precision, { toNum: true }) : Je.theoryTotalWeight, fe -= Je.weighingTotalWeight - Je.theoryTotalWeight, Re -= Je.theoryTotalWeight, ze(Je);
    };
    Oe.forEach((Je) => Ue(Je)), ot.warning("已分配过磅重量"), _.value.forEach((Je) => {
      Je.mete = Je.weighingTotalWeight;
    }), Me();
  }
  function He() {
    _.value.map((Oe) => {
      Oe.weighingTotalWeight = Oe.originMete, Oe.mete = Oe.originMete, A(Oe.unitPrice) && A(Oe.weighingTotalWeight) ? Oe.amount = Be(Oe.weighingTotalWeight * Oe.unitPrice, Ze.YUAN) : Oe.amount = void 0;
    }), Me(), P.loadingWeight = P.originLoadingWeight;
  }
  function ze(Oe) {
    E(Oe), A(Oe.unitPrice) && A(Oe.weighingTotalWeight) ? Oe.amount = Be(Oe.weighingTotalWeight * Oe.unitPrice, Ze.YUAN) : Oe.amount = void 0, Me();
  }
  return (Oe, Re) => {
    const fe = wi, Ue = Ve("vxe-column"), Je = Ve("vxe-table"), Xe = Fo, Ye = Ve("common-input-number"), Fe = jt, et = Zi, lt = Ve("common-button"), bt = Li, gt = Ve("common-dialog"), qt = oi;
    return w(), U(gt, { modelValue: l(R), "onUpdate:modelValue": Re[3] || (Re[3] = (kt) => Gt(R) ? R.value = kt : null), "before-close": l(v), title: ae.value.serialNumber ? `订单：${ae.value.serialNumber}（${ae.value.supplier ? ae.value.supplier.name : ""}）` : "甲供入库", top: "5vh", "append-to-body": "", "custom-class": "inbound-application-preview", fullscreen: "", width: "1200px" }, { titleAfter: p(() => [ye.value ? H("", true) : (w(), U(s2, { key: 0, detail: l(P), order: ae.value }, null, 8, ["detail", "order"]))]), titleRight: p(() => [j.value ? (w(), U(br, { key: 0, "purchase-id": ae.value.id, size: "default" }, null, 8, ["purchase-id"])) : H("", true)]), default: p(() => [l(R) ? qe((w(), U(bt, { key: 0, ref: "formRef", disabled: l(N).status.edit === l(L).STATUS.PROCESSING, model: l(P) }, { default: p(() => [h.basicClass & l(sl) ? (w(), Q("div", Tee, [C("div", _ee, [Re[4] || (Re[4] = C("div", { class: "left-box" }, "汇总", -1)), C("div", bee, K(pe.value || 0) + K(l(ei).weight.unit), 1)])])) : H("", true), l(A)(T.value) ? (w(), Q(Qe, { key: 1 }, [s(fe, { style: { "margin-bottom": "15px" }, type: "success" }, { default: p(() => Re[5] || (Re[5] = [Te("理计汇总")])), _: 1, __: [5] }), s(Je, { key: "`inbound_formList`", "column-config": ee.value, data: T.value, "empty-text": "暂无数据", "footer-data": I.value, "max-height": J.value, "row-style": te, "scroll-y": B.value, border: "", "show-footer": "", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(Ue, { type: "expand", width: "60" }, { content: p(({ row: kt }) => [se.value ? H("", true) : (w(), U(Xl, { key: 0, "basic-class": kt.basicClass, row: kt, "show-brand": "" }, null, 8, ["basic-class", "row"])), C("p", null, [Re[6] || (Re[6] = Te(" 备注：")), C("span", null, K(kt.remark), 1)])]), _: 1 }), ce.value ? (w(), Q(Qe, { key: 1 }, [s(Ue, { title: "名称", align: "center", field: "manufacturedName", "min-width": "100px", "show-overflow-tooltip": "" }), s(Ue, { title: "编号", align: "center", field: "manufacturedSn", "min-width": "100px", "show-overflow-tooltip": "" }), s(Ue, { title: "规格", align: "center", field: "specification", "min-width": "100px", "show-overflow-tooltip": "" }), s(Ue, { title: "材质", align: "center", field: "material", "min-width": "100px", "show-overflow-tooltip": "" })], 64)) : (w(), Q(Qe, { key: 0 }, [s(hc, { "basic-class": h.basicClass, showOtherIndex: "" }, null, 8, ["basic-class"]), se.value ? (w(), U(fc, { key: 0, "basic-class": h.basicClass, fixed: false }, null, 8, ["basic-class"])) : H("", true)], 64)), s(Ue, { title: "收货数量", align: "center", field: "quantity", width: "100" }), s(Ue, { title: "核算单位", align: "center", field: "accountingUnit", width: "100" }), ce.value ? (w(), U(Ue, { key: 3, title: "核算量", align: "center", field: "showManufWeight", width: "100" })) : (w(), U(Ue, { key: 2, title: "总重", align: "center", field: "mete", width: "100" }, { default: p(({ row: kt }) => [C("span", null, K(kt.mete ? kt.mete.toFixed(kt.accountingPrecision) : "-"), 1)]), _: 1 })), j.value && !ye.value ? (w(), Q(Qe, { key: 4 }, [s(Ue, { align: "right", field: "unitPrice", title: "含税单价", width: "135px" }, { default: p(({ row: kt }) => [C("span", null, K(kt == null ? void 0 : kt.unitPrice), 1)]), _: 1 }), s(Ue, { align: "right", field: "amount", title: "金额", width: "135px" }, { default: p(({ row: kt }) => [C("span", null, K(kt.amount ? l(Be)(kt.amount, l(Ze).YUAN) : "-"), 1)]), _: 1 })], 64)) : H("", true), ce.value ? H("", true) : (w(), U(go, { key: 5, list: T.value, order: ae.value, unShowExtra: "" }, null, 8, ["list", "order"])), ce.value ? (w(), U(Y3, { key: 6, boolManuf: ce.value, parentList: T.value, showWarehouse: "" }, null, 8, ["boolManuf", "parentList"])) : (w(), U(Vm, { key: 7, list: T.value, showWarehouse: "" }, null, 8, ["list"])), s(gc, { label: "实际入库时间" })]), _: 1 }, 8, ["column-config", "data", "footer-data", "max-height", "scroll-y"])], 64)) : H("", true), l(A)(_.value) ? (w(), Q(Qe, { key: 2 }, [h.basicClass & l(sl) ? (w(), Q("div", Vee, [s(fe, { class: "filter-item" }, { default: p(() => Re[7] || (Re[7] = [Te("磅计汇总")])), _: 1, __: [7] }), C("span", wee, [s(Xe, { modelValue: m.value, "onUpdate:modelValue": Re[0] || (Re[0] = (kt) => m.value = kt) }, null, 8, ["modelValue"]), C("span", null, "重量分摊模式(" + K(l(ei).weight.unit) + ")", 1)]), m.value ? (w(), Q(Qe, { key: 0 }, [s(et, { label: "", class: "filter-item", "label-width": "0", prop: "loadingWeight" }, { default: p(() => [s(Fe, { content: `重量误差：${he.value.overNum} kg， ${l(g)}`, disabled: !he.value.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(Ye, { modelValue: l(P).loadingWeight, "onUpdate:modelValue": Re[1] || (Re[1] = (kt) => l(P).loadingWeight = kt), class: Zt([{ "over-weight-tip": he.value.hasOver }, "input-underline"]), controls: false, max: 999999999, min: 0, placeholder: "输入该车次重量", precision: 0, mode: "input", style: { width: "135px" }, onBlur: Re[2] || (Re[2] = (kt) => l(S)(l(P).loadingWeight, Ke.value)) }, null, 8, ["modelValue", "class"])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 }), s(lt, { class: "filter-item", type: "primary", onClick: Ne }, { default: p(() => Re[8] || (Re[8] = [Te("计算")])), _: 1, __: [8] })], 64)) : H("", true), s(lt, { class: "filter-item", type: "warning", onClick: He }, { default: p(() => Re[9] || (Re[9] = [Te("重置")])), _: 1, __: [9] })])) : H("", true), s(Je, { key: "`inbound_weightList`", "cell-class-name": l(ne), "column-config": ee.value, data: _.value, "empty-text": "暂无数据", "footer-data": Y.value, "max-height": J.value, "row-style": te, "scroll-y": B.value, border: "", class: "myTable-style", "show-footer": "", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(Ue, { type: "expand", width: "60" }, { content: p(({ row: kt }) => [se.value ? H("", true) : (w(), U(Xl, { key: 0, "basic-class": kt.basicClass, row: kt, "show-brand": "" }, null, 8, ["basic-class", "row"])), C("p", null, [Re[10] || (Re[10] = Te(" 备注：")), C("span", null, K(kt.remark), 1)])]), _: 1 }), s(hc, { "basic-class": h.basicClass, showOtherIndex: "" }, null, 8, ["basic-class"]), se.value ? (w(), U(fc, { key: 0, "basic-class": h.basicClass, fixed: false, isVxe: "" }, null, 8, ["basic-class"])) : H("", true), s(Ue, { title: "收货数量", align: "center", field: "quantity", width: "100" }), s(Ue, { title: "理论重量", align: "center", field: "theoryTotalWeight", "min-width": "110" }), s(Ue, { align: "center", field: "weighingTotalWeight", title: "实收重量", width: "135px" }, { default: p(({ row: kt }) => [m.value ? (w(), Q("span", See, K(kt.weighingTotalWeight ? kt.weighingTotalWeight.toFixed(l(ei).weight.precision) : "-"), 1)) : (w(), U(Fe, { key: 0, content: `理论重量：${kt.theoryTotalWeight} kg， ${l(r)}`, disabled: !kt.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(Ye, { modelValue: kt.weighingTotalWeight, "onUpdate:modelValue": (Ii) => kt.weighingTotalWeight = Ii, class: Zt({ "over-weight-tip": kt.hasOver }), controls: false, max: 999999999, min: 0, style: { width: "100%" }, precision: l(ei).weight.precision, "controls-position": "right", placeholder: "实收量", size: "default", onBlur: (Ii) => l(b)(kt), onChange: (Ii) => ze(kt) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onBlur", "onChange"])]), _: 2 }, 1032, ["content", "disabled"]))]), _: 1 }), j.value && !ye.value ? (w(), Q(Qe, { key: 1 }, [s(Ue, { align: "right", field: "unitPrice", title: "含税单价", width: "135px" }, { default: p(({ row: kt }) => [C("span", null, K(kt == null ? void 0 : kt.unitPrice), 1)]), _: 1 }), s(Ue, { align: "right", field: "amount", title: "金额", width: "135px" }, { default: p(({ row: kt }) => [C("span", null, K(kt.amount ? l(Be)(kt.amount, l(Ze).YUAN) : "-"), 1)]), _: 1 })], 64)) : H("", true), s(go, { list: _.value, order: ae.value, unShowExtra: "" }, null, 8, ["list", "order"]), s(Vm, { list: _.value, showWarehouse: "" }, null, 8, ["list"]), s(gc, { label: "实际入库时间" })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "footer-data", "max-height", "scroll-y"])], 64)) : H("", true), oe.value ? (w(), U(U3, { key: 3, ref_key: "logisticsRef", ref: q, disabled: l(N).status.edit === l(L).STATUS.PROCESSING, form: l(P).logistics, showType: "submit", class: "logistics-form-content" }, null, 8, ["disabled", "form"])) : H("", true)]), _: 1 }, 8, ["disabled", "model"])), [[qt, ie.value]]) : H("", true), s(o2, { "show-total": false, class: "footer", "is-submit": "" })]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, j3 = ut(vee, [["__scopeId", "data-v-4c0c1057"]]), Ree = Object.freeze(Object.defineProperty({ __proto__: null, default: j3 }, Symbol.toStringTag, { value: "Module" }));
const Mee = { class: "main-content" }, Aee = { __name: "common-wrapper", props: { basicClass: { type: Number }, currentBasicClass: { type: Number }, validate: { type: Function }, importAmountRules: { type: Object, default: () => {
} }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, contractUnit: { type: String, default: "" }, contractValue: { type: [Number, String], default: 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "下一步" }, inboundUnit: { type: String, default: "" }, inboundValue: { type: [Number, String], default: 0 }, showInboundTotal: { type: Boolean, default: false }, showContractTotal: { type: Boolean, default: false }, showTotal: { type: Boolean, default: true }, showTotalAmount: { type: Boolean, default: true }, isManuf: { type: Boolean, default: false }, totalAmount: { type: [Number, String], default: 0 }, edit: { type: Boolean, default: false }, beginValidate: { type: Function }, hideenBegin: { type: Boolean, default: false }, beginPermission: { type: Object, default: () => {
} } }, emits: ["purchase-order-change", "submit"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z(false), E = Z(false);
  let y = {};
  c.edit ? y = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false } : y = { extraBox: null, wrapperBox: null };
  const { heightStyle: b } = Kt(y);
  async function V() {
    if (u.value.form.inboundWay === si.ORDINARY_STORAGE.V || c.isManuf) {
      const g = await u.value.validate();
      let S = true;
      typeof c.validate == "function" && (S = await c.validate()), g && S && (r.value = true);
    } else await c.beginValidate() && (E.value = true);
  }
  function M(g, S) {
    n("purchase-order-change", g, S);
  }
  return (g, S) => {
    var T;
    const h = oi;
    return w(), Q("div", { style: ri(l(b)), class: "inbound-application-container" }, [s(x3, { ref_key: "headerRef", ref: u, "basic-class": c.basicClass, "current-basic-class": c.currentBasicClass ?? c.basicClass, edit: c.edit, "hideen-begin": c.hideenBegin, importAmountRules: e.importAmountRules, isManuf: e.isManuf, permission: e.beginPermission, validate: e.validate, class: "header", onPurchaseOrderChange: M }, null, 8, ["basic-class", "current-basic-class", "edit", "hideen-begin", "importAmountRules", "isManuf", "permission", "validate"]), qe((w(), Q("div", Mee, [xt(g.$slots, "default", {}, void 0, true)])), [[h, (T = u.value) == null ? void 0 : T.contentLoading]]), s(o2, { "btn-name": c.btnName, "contract-unit": c.contractUnit, "contract-value": c.contractValue, "inbound-unit": c.inboundUnit, "inbound-value": c.inboundValue, "show-total": c.showTotal, "show-total-amount": c.showTotalAmount, showContractTotal: e.showContractTotal, showInboundTotal: e.showInboundTotal, "total-amount": c.totalAmount, "total-name": c.totalName, "total-value": c.totalValue, unit: c.unit, class: "footer", onSubmit: V }, null, 8, ["btn-name", "contract-unit", "contract-value", "inbound-unit", "inbound-value", "show-total", "show-total-amount", "showContractTotal", "showInboundTotal", "total-amount", "total-name", "total-value", "unit"]), s(j3, { modelValue: r.value, "onUpdate:modelValue": S[0] || (S[0] = (_) => r.value = _), "basic-class": c.basicClass, isManuf: c.isManuf }, null, 8, ["modelValue", "basic-class", "isManuf"]), xt(g.$slots, "beginPreview", { onUpdateVisible: (_) => E.value = _, visible: E.value }, void 0, true)], 4);
  };
} }, Ar = ut(Aee, [["__scopeId", "data-v-b4a0fceb"]]), Nee = Object.freeze(Object.defineProperty({ __proto__: null, default: Ar }, Symbol.toStringTag, { value: "Module" })), qo = { __name: "price-set-columns-vxe", props: { weightAttribute: { type: String, default: "weighingTotalWeight" } }, setup(e) {
  const o = e, { handleUnitPriceChange: n, handleAmountChange: c } = Al(o.weightAttribute);
  return (u, r) => {
    const E = Ve("common-input-number"), y = Ve("vxe-column");
    return w(), Q(Qe, null, [s(y, { field: "unitPrice", align: "center", width: "135px", title: "含税单价" }, { default: p(({ row: b }) => [b ? (w(), U(E, { key: 0, modelValue: b.unitPrice, "onUpdate:modelValue": (V) => b.unitPrice = V, min: 0, max: 9999999999, controls: false, style: { width: "100%" }, step: 1, size: "default", placeholder: "含税单价", onChange: (V) => l(n)(V, b) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : H("", true)]), _: 1 }), s(y, { field: "amount", align: "center", width: "135px", title: "金额" }, { default: p(({ row: b }) => [b ? (w(), U(E, { key: 0, modelValue: b.amount, "onUpdate:modelValue": (V) => b.amount = V, min: 0, max: 9999999999, controls: false, style: { width: "100%" }, step: 1, size: "default", precision: l(Ze).YUAN, placeholder: "金额", onChange: (V) => l(c)(V, b) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : H("", true)]), _: 1 })], 64);
  };
} }, Lee = Object.freeze(Object.defineProperty({ __proto__: null, default: qo }, Symbol.toStringTag, { value: "Module" }));
const Iee = { __name: "inbound-info-table", props: { hasBorder: { type: Boolean, default: false }, material: { type: Object, default: () => ({}) }, basicClass: { type: Number }, list: { type: Array, default: () => [] } }, emits: ["del"], setup(e, { emit: o }) {
  const n = e, c = Z([...ld, ["inboundTime", ["parse-time", "{y}-{m}-{d}"]]]);
  function u(r) {
    const E = n.material.measurePrecision || 0, y = n.material.accountingPrecision || 2;
    return Hi(r, { props: [["quantity", E], ["mete", y]] });
  }
  return (r, E) => {
    const y = vt, b = Ve("common-table");
    return w(), U(b, { data: e.list, "data-format": c.value, "show-summary": false, "summary-method": u, "row-key": "id", style: { width: "100%" }, class: Zt({ "table-border-none": !e.hasBorder }) }, { default: p(() => [s(fa, { "basic-class": e.basicClass }, { afterIndex: p(() => [s(y, { prop: "inboundTime", "show-overflow-tooltip": "", align: "center", width: "100", label: "入库时间" }), s(y, { prop: "applyPurchaseSN", "show-overflow-tooltip": "", align: "center", "min-width": "120", label: "申购单" })]), _: 1 }, 8, ["basic-class"]), s(za, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), s(Ba, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), s(y, { prop: "remark", "show-overflow-tooltip": "", align: "left", "min-width": "120", label: "备注" })]), _: 1 }, 8, ["data", "data-format", "class"]);
  };
} }, al = ut(Iee, [["__scopeId", "data-v-33986bfd"]]), Cee = Object.freeze(Object.defineProperty({ __proto__: null, default: al }, Symbol.toStringTag, { value: "Module" })), r2 = { __name: "project-set-columns-v2", props: { order: { type: Object, default: () => ({}) }, requisitions: { type: Object, default: () => ({}) }, list: { type: Array, default: () => [] }, form: { type: Object, default: () => ({}) } }, setup(e) {
  const { projectAllType: o } = Wa(), n = e, c = Z({ list: [] });
  ud();
  const u = Ee(() => {
    const V = n.order;
    if (A(V)) {
      if (A(V.projects)) return V.projects.map((M) => ({ id: M.id, name: di(M, { showSerialNumber: true }) }));
      {
        const M = [];
        return o.value.forEach((g) => {
          (g.projectAttribute === V.projectAttribute && g.level === Bt.FACTORY.V || g.level === 3) && M.push(g);
        }), (M == null ? void 0 : M.map((g) => ({ id: g.id, name: di(g, { showSerialNumber: true }) }))) || [];
      }
    } else return [];
  });
  Dt(() => {
    c.value = { list: n.list };
  });
  const { initScopeList: r, handleValueChange: E, getNotDittoArr: y, getRealVal: b } = Rn("projectId");
  return Dt(() => {
    r(c.value.list || []);
  }), (V, M) => {
    const g = vt;
    return w(), U(g, { align: "center", label: "所属项目", "min-width": "170px", prop: "projectId" }, { default: p(({ row: S, $index: h }) => [s(n2, { modelValue: S.projectId, "onUpdate:modelValue": (T) => S.projectId = T, "show-extra": h !== 0, defaultOptions: u.value, clearable: "", placeholder: "所属项目", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "defaultOptions"])]), _: 1 });
  };
} }, Pee = Object.freeze(Object.defineProperty({ __proto__: null, default: r2 }, Symbol.toStringTag, { value: "Module" })), u2 = { __name: "warehouse-set-columns-v2", props: { boolManuf: { type: Boolean, default: false }, showWarehouse: { type: Boolean, default: true }, list: { type: Array, default: () => ({}) } }, setup(e) {
  const o = e, n = Z({ list: [] });
  Dt(() => {
    n.value = { list: o.list };
  });
  const { getNotDittoArr: c, initScopeList: u, handleValueChange: r, getRealVal: E } = Rn("workshopId"), y = Ee(() => c()), b = Ee(() => n.value.list || []);
  Dt(() => u(b.value));
  function V(M, g, S) {
    r(M, g), M !== -1 ? S.warehouseId = void 0 : pt(() => {
      Ae(S.warehouseId) && (S.warehouseId = -1);
    });
  }
  return (M, g) => {
    const S = vt;
    return w(), Q(Qe, null, [s(S, { prop: "workshopId", align: "center", "min-width": "140px", label: "仓库" }, { default: p(({ row: h, $index: T }) => [s(Mr, { modelValue: h.workshopId, "onUpdate:modelValue": (_) => h.workshopId = _, placeholder: "请选择仓库", "show-extra": T !== 0, onChange: (_) => V(_, T, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), e.showWarehouse ? (w(), U(S, { key: 0, prop: "warehouseId", label: "存储位置", "min-width": "140px", align: "center" }, { default: p(({ row: h, $index: T }) => [s(xs, { modelValue: h.warehouseId, "onUpdate:modelValue": (_) => h.warehouseId = _, "workshop-id": l(E)(T), "basic-class": h.basicClass, "show-extra": b.value[T - 1] && !y.value.includes(T), placeholder: "存储位置" }, null, 8, ["modelValue", "onUpdate:modelValue", "workshop-id", "basic-class", "show-extra"])]), _: 1 })) : H("", true)], 64);
  };
} }, Oee = Object.freeze(Object.defineProperty({ __proto__: null, default: u2 }, Symbol.toStringTag, { value: "Module" })), kee = ["onClick"], c2 = { __name: "inbound-quantity-column", props: { baseUnit: { type: Object, required: true }, currentCfg: { type: Object, required: true }, form: { type: Object, required: true }, list: { type: Array, required: () => [] }, basicClass: { type: Number, required: true }, handleOverQuantity: { type: Function, required: true }, order: { type: Object, default: () => {
} } }, emits: ["save"], setup(e, { emit: o }) {
  const { inboundFillWayCfg: n } = aa(), c = Ee(() => n.value.saveInboundState === Sl.MODIFY.V), u = e, r = Ee(() => u.baseUnit), { overDiffTip: E, weightOverDiff: y, diffSubmitValidate: b } = Va(r), V = Z({}), M = Z(false), g = o, { maxHeight: S } = Kt({ mainBox: ".inbound-requisition-dialog", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, Ee(() => M.value)), h = Ee(() => {
    const ge = [];
    let Le = 0, Ie = 0;
    return V.value.applyPurchase.forEach((Se, X) => {
      Se.isBranch ? Le += Se.quantity : (Ie && ge.push(...Array(Ie).fill(Le)), Le = Se.quantity, Ie = Se.spanMerge), X === V.value.applyPurchase.length - 1 && ge.push(...Array(Ie).fill(Le));
    }), ge;
  });
  async function T(ge) {
    var Le, Ie, Se;
    if (V.value = ge, (Le = V.value.applyPurchase) == null || Le.forEach((X) => {
      X.specification = X.specification || ge.specification, X.thickness = X.thickness || ge.thickness, X.length = X.length || ge.length, X.width = X.width || ge.width, X.brand = X.brand || ge.brand, X.heatNoAndBatchNo = X.heatNoAndBatchNo || ge.heatNoAndBatchNo, X.projectId = X.origin_projectId ? X.projectId : X.projectId || ge.projectId, X.workshopId = X.workshopId || ge.workshopId, X.warehouseId = X.warehouseId || ge.warehouseId, X.standardId = X.standardId || ge.standardId, X.model = X.specification, X.sn = X.sn || ge.sn, X.specificationLabels = X.specificationLabels || ge.specificationLabels, X.serialNumber = X.serialNumber || ge.serialNumber, X.classifyId = X.classifyId || ge.classifyId, X.classifyFullName = X.classifyFullName || ge.classifyFullName, X.classifyName = X.classifyName || ge.classifyName, X.classifyParentFullName = X.classifyParentFullName || ge.classifyParentFullName, X.basicClass = X.basicClass || ge.basicClass, X.specification = X.specification || ge.specification, X.specificationMap = X.specKV || ge.specKV, X.measureUnit = X.measureUnit || ge.measureUnit, X.accountingUnit = X.accountingUnit || ge.accountingUnit, X.measurePrecision = X.measurePrecision || ge.measurePrecision, X.accountingPrecision = X.accountingPrecision || ge.accountingPrecision, X.unitWeight = X.unitWeight || ge.unitWeight, X.unitPrice = X.unitPrice || ge.unitPrice, m(X);
    }), u.basicClass & Ge.SECTION_STEEL.V) {
      let X;
      const $ = [];
      for (const k in V.value.specificationMap) k.indexOf("standard") > -1 ? X = V.value.specificationMap[k] : $.push(V.value.specificationMap[k]);
      V.value.nationalStandardOptions = ge.nationalStandardOptions, V.value.standardId || (V.value.standardId = (Se = (Ie = V.value.nationalStandardOptions) == null ? void 0 : Ie.find((k) => k.boolDefault)) == null ? void 0 : Se.standardId), V.value.applyPurchase.forEach((k) => {
        k.standardId = k.standardId || V.value.standardId, k.sectionSteelSpec = k.sectionSteelSpec || X, k.doNotSectionSteelSpec = k.doNotSectionSteelSpec || $.join("*");
      });
    }
    V.value.originApplyPurchase = JSON.parse(JSON.stringify(V.value.applyPurchase)), M.value = true;
  }
  function _() {
    V.value.applyPurchase = V.value.originApplyPurchase, M.value = false;
  }
  function f() {
    var Le;
    V.value.applyPurchase = JSON.parse(JSON.stringify(V.value.firstApplyPurchase));
    const ge = (Le = u.form.selectObj) == null ? void 0 : Le[V.value.mergeId];
    ge.isSelected = false, M.value = false, g("save", V.value);
  }
  function m(ge) {
    const Le = !ge.theoryTotalWeight;
    u.basicClass & Ge.SECTION_STEEL.V && (Ce([() => ge.length, () => ge.unitWeight, u.baseUnit], async () => {
      ge.theoryWeight = await xa({ length: ge.length, unitWeight: ge.unitWeight });
    }, { immediate: Le }), Ce([() => ge.length, () => ge.quantity], async () => {
      R(ge);
    }, { immediate: Le })), u.basicClass & Ge.STEEL_PLATE.V && Ce([() => ge.length, () => ge.width, () => ge.thickness, u.baseUnit], async () => {
      ge.theoryWeight = await na({ classifyId: ge.classifyId, name: ge.classifyFullName, length: ge.length, width: ge.width, thickness: ge.thickness });
    }, { immediate: Le }), Ce([() => ge.theoryWeight, () => ge.quantity], () => {
      v(ge);
    }, { immediate: Le });
  }
  function R(ge) {
    A(ge.length) && ge.quantity ? ge.totalLength = Na({ length: ge.length, quantity: ge.quantity }) : ge.totalLength = void 0;
  }
  function v(ge) {
    A(ge.theoryWeight) && ge.quantity ? (ge.theoryTotalWeight = Be(ge.theoryWeight * ge.quantity, u.baseUnit.weight.precision), ge.weighingTotalWeight = ge.theoryTotalWeight) : ge.theoryTotalWeight = 0, N(ge);
  }
  function N(ge) {
    A(ge.unitPrice) && A(ge.weighingTotalWeight) ? ge.amount = Be(ge.weighingTotalWeight * ge.unitPrice, Ze.YUAN) : ge.amount = void 0;
  }
  function P(ge) {
    y(ge), N(ge);
  }
  const L = (ge, Le) => A(ge) ? ge > 0 : true, O = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { validator: L, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { validator: L, message: "厚度必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { validator: L, message: "长度必须大于0", trigger: "blur" }] }, x = { length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { validator: L, message: "长度必须大于0", trigger: "blur" }] }, I = (ge, Le) => (Le.measureUnit && A(Le.measurePrecision) && A(Le.quantity) && (Le.quantity = Be(Le.quantity, Le.measurePrecision)), u.basicClass & ct.STEEL.V || Le.measureUnit && A(Le.measurePrecision) ? !!Le.quantity : true), ee = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (ge, Le) => A(Le.weighingTotalWeight) && A(Le.unitPrice) ? +Be(Le.weighingTotalWeight * Le.unitPrice, Ze.YUAN) == +ge : false, message: "金额有误，请手动修改", trigger: "blur" }] }, B = { quantity: [{ validator: I, message: "请填写数量", trigger: "blur" }], theoryTotalWeight: [{ required: true, message: "请填写理论重量", trigger: "blur" }, { validator: L, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写实收量", trigger: "blur" }, { validator: b, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: L, message: "重量必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, q = Ee(() => {
    let ge = Object.assign({}, B);
    const Le = u.basicClass & Ge.STEEL_PLATE.V ? O : x;
    return ge = Object.assign(Le, B), c.value && (ge = Object.assign(ge, ee)), ge;
  }), ae = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: j, cleanUpData: le, wrongCellMask: oe } = ui({ rules: q, ditto: ae });
  function ye() {
    var Ie, Se;
    const ge = [];
    (Ie = V.value.applyPurchase) == null || Ie.forEach((X, $) => {
      X.currentIndex = $ + 1, y(X), (A(X.quantity) || A(X.weighingTotalWeight)) && ge.push(X);
    });
    const { validResult: Le } = j(ge);
    if (Le) {
      const X = (Se = u.form.selectObj) == null ? void 0 : Se[V.value.mergeId];
      X.isSelected = true, V.value.applyPurchase.forEach(($) => {
        Ae($.projectId) && ($.origin_projectId = true);
      }), le(ge), ge == null || ge.forEach(($) => {
        const k = V.value.applyPurchase.findIndex((J) => J.currentIndex === $.currentIndex);
        k > -1 && (V.value.applyPurchase[k].projectId = $.projectId, V.value.applyPurchase[k].workshopId = $.workshopId, V.value.applyPurchase[k].warehouseId = $.warehouseId);
      }), M.value = false, g("save", V.value);
    }
  }
  function ce(ge, Le, Ie) {
    var k;
    const Se = (k = u.form.selectObj) == null ? void 0 : k[V.value.mergeId], X = Ct({ ...Ie, sn: Se == null ? void 0 : Se.sn, specificationLabels: Se == null ? void 0 : Se.specificationLabels, serialNumber: Se == null ? void 0 : Se.serialNumber, classifyId: Se == null ? void 0 : Se.classifyId, classifyFullName: Se == null ? void 0 : Se.classifyFullName, classifyName: Se == null ? void 0 : Se.classifyName, classifyParentFullName: Se == null ? void 0 : Se.classifyParentFullName, basicClass: Se == null ? void 0 : Se.basicClass, specification: Se == null ? void 0 : Se.specification, specificationMap: Se == null ? void 0 : Se.specificationMap, measureUnit: Se == null ? void 0 : Se.measureUnit, accountingUnit: Se == null ? void 0 : Se.accountingUnit, measurePrecision: Se == null ? void 0 : Se.measurePrecision, accountingPrecision: Se == null ? void 0 : Se.accountingPrecision, unitWeight: Se == null ? void 0 : Se.unitWeight, length: Se == null ? void 0 : Se.length, width: Se == null ? void 0 : Se.width, thickness: Se == null ? void 0 : Se.thickness, theoryTotalWeight: null, quantity: null, weighingTotalWeight: null, originQuantity: null, projectId: ge >= 0 ? -1 : Se == null ? void 0 : Se.projectId, workshopId: ge >= 0 ? -1 : Se == null ? void 0 : Se.workshopId, warehouseId: ge >= 0 ? -1 : Se == null ? void 0 : Se.warehouseId, isBranch: true });
    m(X), Le.splice(ge + 1, 0, X);
    const $ = he(ge, Le);
    Le[$].spanMerge || (Le[$].spanMerge = 1), Le[$].spanMerge++;
  }
  function se(ge, Le, Ie) {
    if (Ie.isBranch) {
      const Se = he(ge, Le);
      Le[Se].spanMerge--;
    } else Le[ge + 1].spanMerge = Ie.spanMerge - 1, Le[ge + 1].isBranch = false;
    if (Le.splice(ge, 1), A(Le) && Le.length > 0) {
      const Se = Le[0];
      Le[0].projectId = Se.projectId && Se.projectId !== -1 ? Se.projectId : void 0, Le[0].workshopId = Se.workshopId && Se.workshopId !== -1 ? Se.workshopId : void 0, Le[0].warehouseId = Se.warehouseId && Se.warehouseId !== -1 ? Se.warehouseId : void 0;
    }
  }
  function he(ge, Le, Ie) {
    let Se = ge;
    for (let X = ge; X >= 0; X--) if (!Le[X].isBranch) {
      Se = X;
      break;
    }
    return Se;
  }
  function be({ row: ge, column: Le, rowIndex: Ie, columnIndex: Se }) {
    if (["serialNumber", "project", "purchaseQuantity", "inboundQuantity"].includes(Le.property)) return ge.isBranch ? { rowspan: 1, colspan: 0 } : { rowspan: ge.spanMerge || 1, colspan: 1 };
  }
  function me(ge) {
    return Hi(ge, { props: [["theoryTotalWeight", ei.weight.precision], ["weighingTotalWeight", ei.weight.precision]] });
  }
  return (ge, Le) => {
    const Ie = ya, Se = Ve("vxe-column"), X = Ve("common-button"), $ = vt, k = Ve("common-input-number"), J = jt, z = Mt, F = Ve("common-table"), G = Ve("common-dialog");
    return w(), Q(Qe, null, [s(Se, { title: "操作", align: "center", fixed: "right", width: "110px" }, { default: p(({ row: ie }) => [C("span", { style: { "margin-left": "5px", cursor: "pointer" }, onClick: (ue) => T(ie) }, [s(Ie, { class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle" } })], 8, kee)]), _: 1 }), s(G, { modelValue: M.value, "onUpdate:modelValue": Le[1] || (Le[1] = (ie) => M.value = ie), "before-close": () => {
      M.value = false;
    }, "close-on-click-modal": false, "show-close": false, title: `${V.value.classifyName}：${V.value.serialNumber}`, "custom-class": "inbound-requisition-dialog", top: "10vh", width: "98%" }, { titleRight: p(() => [s(X, { type: "primary", onClick: ye }, { default: p(() => Le[2] || (Le[2] = [Te("保存")])), _: 1, __: [2] }), s(X, { type: "warning", onClick: f }, { default: p(() => Le[3] || (Le[3] = [Te("清空还原")])), _: 1, __: [3] }), s(X, { type: "info", onClick: Le[0] || (Le[0] = (ie) => _()) }, { default: p(() => Le[4] || (Le[4] = [Te("关闭")])), _: 1, __: [4] })]), default: p(() => [s(F, { "cell-class-name": l(oe), data: V.value.applyPurchase, maxHeight: l(S), "show-empty-symbol": false, "span-method": be, "summary-method": me, "return-source-data": "", "show-summary": "", style: { width: "100%" } }, { default: p(() => [s($, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), V.value.originBoolApplyPurchase ? (w(), U($, { key: 0, "show-overflow-tooltip": true, align: "center", label: "申购单号", "min-width": "140", prop: "applyPurchaseSN" })) : H("", true), xt(ge.$slots, "editColumn", { row: V.value }), s($, { label: `本次实收数 (${e.baseUnit.measure.unit})`, "show-overflow-tooltip": true, align: "center", "min-width": "110px", prop: "quantity" }, { default: p(({ row: ie, $index: ue }) => [s(k, { modelValue: ie.quantity, "onUpdate:modelValue": (ne) => ie.quantity = ne, controls: false, max: 999999999, min: 0, precision: e.baseUnit.measure.precision, step: 1, "controls-position": "right", placeholder: "实收数", size: "default", onBlur: (ne) => e.handleOverQuantity(ie, true, "comparePurchaseQuantity"), onChange: () => {
      ie.comparePurchaseQuantity = ie.purchaseQuantity - h.value[ue] + ie.quantity;
    } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur", "onChange"])]), _: 1 }, 8, ["label"]), s($, { label: `理论重量 (${e.baseUnit.weight.unit})`, align: "center", "min-width": "100px", prop: "theoryTotalWeight" }, null, 8, ["label"]), s($, { align: "center", label: `实收量 (${e.baseUnit.weight.unit})`, "min-width": "100px", prop: "weighingTotalWeight" }, { default: p(({ row: ie }) => [s(J, { content: `理论重量：${ie.theoryTotalWeight} kg， ${l(E)}`, disabled: !ie.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(k, { modelValue: ie.weighingTotalWeight, "onUpdate:modelValue": (ue) => ie.weighingTotalWeight = ue, class: Zt({ "over-weight-tip": ie.hasOver }), controls: false, max: 999999999, min: 0, style: { width: "100%" }, precision: e.baseUnit.weight.precision, size: "default", "controls-position": "right", placeholder: "实收量", onChange: (ue) => P(ie) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onChange"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["label"]), c.value ? (w(), U(yd, { key: 1 })) : H("", true), s($, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: p(({ row: ie }) => [s(z, { modelValue: ie.brand, "onUpdate:modelValue": (ue) => ie.brand = ue, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), u.basicClass & l(ct).STEEL.V ? (w(), U($, { key: 2, align: "center", label: "炉批号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: p(({ row: ie }) => [s(z, { modelValue: ie.heatNoAndBatchNo, "onUpdate:modelValue": (ue) => ie.heatNoAndBatchNo = ue, modelModifiers: { trim: true }, maxlength: "200", placeholder: "炉批号", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : H("", true), s(r2, { list: V.value.applyPurchase, order: e.order }, null, 8, ["list", "order"]), s(u2, { list: V.value.applyPurchase, showWarehouse: "" }, null, 8, ["list"]), s($, { align: "center", fixed: "right", label: "操作", width: "100px" }, { default: p(({ row: ie, $index: ue }) => [ie.isBranch || ie.spanMerge > 1 ? (w(), U(X, { key: 0, class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (ne) => se(ue, V.value.applyPurchase, ie) }, null, 8, ["onClick"])) : H("", true), s(X, { class: "icon-button", icon: "el-icon-plus", size: "default", type: "success", onClick: (ne) => ce(ue, V.value.applyPurchase, ie) }, null, 8, ["onClick"])]), _: 1 })]), _: 3 }, 8, ["cell-class-name", "data", "maxHeight"])]), _: 3 }, 8, ["modelValue", "before-close", "title"])], 64);
  };
} }, Dee = Object.freeze(Object.defineProperty({ __proto__: null, default: c2 }, Symbol.toStringTag, { value: "Module" })), Go = { __name: "warehouse-set-columns-vxe", props: { boolManuf: { type: Boolean, default: false }, showWarehouse: { type: Boolean, default: true }, list: { type: Array, default: () => {
} } }, setup(e) {
  const o = e, n = Z({ list: [] });
  Dt(() => {
    n.value = { list: o.list };
  });
  const { getNotDittoArr: c, initScopeList: u, handleValueChange: r, getRealVal: E } = Rn("workshopId"), y = Ee(() => c()), b = Ee(() => n.value.list || []);
  Dt(() => u(b.value));
  function V(M, g, S) {
    S.warehouseId = void 0;
  }
  return (M, g) => {
    const S = Ve("vxe-column");
    return w(), Q(Qe, null, [s(S, { align: "center", field: "workshopId", "min-width": "140px", title: "仓库" }, { default: p(({ row: h, rowIndex: T }) => [s(Mr, { modelValue: h.workshopId, "onUpdate:modelValue": (_) => h.workshopId = _, "show-extra": T !== 0, placeholder: "请选择仓库", style: { width: "100%" }, onChange: (_) => V(_, T, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), e.showWarehouse ? (w(), U(S, { key: 0, align: "center", field: "warehouseId", "min-width": "140px", title: "存储位置" }, { default: p(({ row: h, rowIndex: T }) => [s(xs, { modelValue: h.warehouseId, "onUpdate:modelValue": (_) => h.warehouseId = _, "basic-class": h.basicClass, "show-extra": b.value[T - 1] && !y.value.includes(T), "workshop-id": l(E)(T), placeholder: "存储位置", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra", "workshop-id"])]), _: 1 })) : H("", true)], 64);
  };
} }, xee = Object.freeze(Object.defineProperty({ __proto__: null, default: Go }, Symbol.toStringTag, { value: "Module" }));
const Uee = { style: { padding: "20px" } }, Yee = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Kee = { key: 1 }, Wee = { key: 1 }, jee = { key: 1 }, Fee = { key: 1 }, zee = { class: "color-green" }, Bee = { class: "color-green" }, Hee = { key: 1 }, qee = { key: 1 }, Gee = { key: 1 }, Qee = { key: 1 }, Zee = { __name: "steel-plate-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_PLATE.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), { overDiffTip: b, weightOverDiff: V, diffSubmitValidate: M, currentCfg: g } = Va(r), { handleOverQuantity: S, handleOverMete: h } = Us({ meteField: "weighingTotalWeight" }), T = Z(), _ = Z(false), f = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const m = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), Y = (ie, ue) => n.noDetail ? !!ie : true, ee = (ie, ue) => A(ie) ? ie > 0 : true, B = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ validator: Y, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ validator: Y, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: M, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: ee, message: "重量必须大于0", trigger: "blur" }], length: [{ validator: Y, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: ee, message: "数量必须大于0", trigger: "blur" }], workshopId: [{ validator: Y, message: "请选择仓库", trigger: "change" }], warehouseId: [{ validator: Y, message: "请选择存储位置", trigger: "change" }] }, ae = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (ie, ue) => A(ue.weighingTotalWeight) && A(ue.unitPrice) ? +Be(ue.weighingTotalWeight * ue.unitPrice, Ze.YUAN) == +ie : false, message: "金额有误，请手动修改", trigger: "blur" }] }, j = Ee(() => {
    let ie = Object.assign({}, B);
    return !n.boolPartyA && n.fillableAmount && (ie = Object.assign(ie, ae)), ie;
  }), le = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: oe, cleanUpData: ye, wrongCellMask: ce } = ui({ rules: j, ditto: le, errorMsg: "请修正【钢板清单】中标红的信息" }), se = ft("steelDensityCfg");
  function he() {
  }
  function be({ row: ie, rowIndex: ue }) {
    var ne, te;
    if ((te = (ne = E == null ? void 0 : E.submitResult) == null ? void 0 : ne.data) != null && te.includes(ie.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function me(ie) {
    const ue = Ct({ uid: Tt(), sn: ie.sn, specificationLabels: ie.specificationLabels, classifySerialNumber: ie.classify.serialNumber, serialNumber: ie.serialNumber, classifyId: ie.classify.id, classifyFullName: ie.classify.fullName, classifyName: ie.classify.name, classifyParentFullName: ie.classify.parentFullName, basicClass: ie.classify.basicClass, specification: ie.spec, model: ie.spec, specificationMap: ie.specKV, measureUnit: ie.classify.measureUnit, accountingUnit: ie.classify.accountingUnit, accountingPrecision: ie.classify.accountingPrecision, measurePrecision: ie.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, projectId: y.steelPlateList.length > 0 ? -1 : void 0, workshopId: y.steelPlateList.length > 0 ? -1 : void 0, warehouseId: y.steelPlateList.length > 0 ? -1 : void 0, rowIndex: y.steelPlateList.length, weightMeasurementMode: n.order.weightMeasurementMode ? n.order.weightMeasurementMode === Wt.MIXTURE.V ? Wt.THEORY.V : n.order.weightMeasurementMode : void 0, steelDensity: A(ie.steelDensity) ? ie.steelDensity : se.value[ie.classify.id] });
    return console.log(ue, "_row"), !n.boolPartyA && n.fillableAmount && (ue.unitPrice = void 0, ue.amount = void 0), ge(ue), ue;
  }
  function ge(ie) {
    Dt(() => {
      var ue, ne, te, de;
      ie.needFirstCalcTheoryWeight && (ie.boolApplyPurchase || (Le(ie), Ie(ie)), ie.boolApplyPurchase && ((ne = (ue = y.selectObj) == null ? void 0 : ue[ie.mergeId]) != null && ne.isSelected) && (ie.quantity = (te = ie == null ? void 0 : ie.applyPurchase) == null ? void 0 : te.reduce((pe, re) => pe + (re.quantity || 0), 0), ie.theoryTotalWeight = (de = ie == null ? void 0 : ie.applyPurchase) == null ? void 0 : de.reduce((pe, re) => pe + (re.theoryTotalWeight || 0), 0)), ie.needFirstCalcTheoryWeight = false), V(ie);
    }), Ce([() => ie.boolApplyPurchase, () => ie == null ? void 0 : ie.applyPurchase], () => {
      var ue, ne, te, de;
      ie.boolApplyPurchase && ((ne = (ue = y.selectObj) == null ? void 0 : ue[ie.mergeId]) != null && ne.isSelected ? (ie.quantity = (te = ie == null ? void 0 : ie.applyPurchase) == null ? void 0 : te.reduce((pe, re) => pe + (re.quantity || 0), 0), ie.theoryTotalWeight = (de = ie == null ? void 0 : ie.applyPurchase) == null ? void 0 : de.reduce((pe, re) => pe + (re.theoryTotalWeight || 0), 0)) : (ie.quantity = 0, ie.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => ie, () => {
      var ue, ne, te;
      if (!n.boolPartyA && !n.noDetail && ((ne = (ue = y.selectObj) == null ? void 0 : ue[ie.mergeId]) != null && ne.isSelected)) {
        const de = (te = y.selectObj[ie.mergeId]) == null ? void 0 : te.isSelected;
        y.selectObj[ie.mergeId] = { ...y.selectObj[ie.mergeId], ...ie, mete: ie.weighingTotalWeight, isSelected: de };
      }
    }, { deep: true }), ie.boolApplyPurchase || (Ce([() => ie.length, () => ie.width, () => ie.thickness, r], () => Le(ie)), Ce([() => ie.theoryWeight, () => ie.quantity], () => Ie(ie))), Ce(() => ie.weighingTotalWeight, () => {
      X(ie);
    });
  }
  async function Le(ie) {
    ie.theoryWeight = await na({ classifyId: ie.classifyId, name: ie.classifyFullName, length: ie.length, width: ie.width, thickness: ie.thickness });
  }
  function Ie(ie) {
    A(ie.theoryWeight) && ie.quantity ? (ie.theoryTotalWeight = Be(ie.theoryWeight * ie.quantity, r.value.weight.precision), (n.boolPartyA || n.noDetail) && (ie.weighingTotalWeight = Be(ie.theoryWeight * ie.quantity, r.value.weight.precision))) : (ie.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (ie.weighingTotalWeight = void 0));
  }
  function Se(ie) {
    var ue;
    if (A(ie.weighingTotalWeight) && (ue = ie.applyPurchase) != null && ue.length) {
      let ne = ie.weighingTotalWeight;
      ie.applyPurchase.forEach((te, de) => {
        if (te.quantity) {
          let pe = 0;
          de !== ie.applyPurchase.length - 1 && ne !== 0 ? (pe = ji(te.theoryTotalWeight / ie.theoryTotalWeight * ie.weighingTotalWeight, r.value.weight.precision, { toNum: true }), ne -= pe) : pe += ne, te.weighingTotalWeight = pe;
        }
      });
    }
    X(ie);
  }
  function X(ie) {
    A(ie.unitPrice) && A(ie.weighingTotalWeight) ? ie.amount = Be(ie.weighingTotalWeight * ie.unitPrice, Ze.YUAN) : ie.amount = void 0;
  }
  function $(ie, ue, ne) {
    var te, de, pe, re;
    if ((de = (te = E == null ? void 0 : E.submitResult) == null ? void 0 : te.data) != null && de.includes(ne.classifyId)) {
      const we = (pe = E == null ? void 0 : E.submitResult) == null ? void 0 : pe.data.findIndex((Me) => Me === ne.classifyId);
      y.steelPlateList.filter((Me) => Me.classifyId === ne.classifyId).length === 1 && ((re = E == null ? void 0 : E.submitResult) == null || re.data.splice(we, 1));
    }
    if (u.value ? u.value.delListItem(ie, ue) : y.steelPlateList.splice(ue, 1), A(y.steelPlateList) && y.steelPlateList.length > 0) {
      const we = y.steelPlateList[0];
      y.steelPlateList[0].projectId = we.projectId && we.projectId !== -1 ? we.projectId : void 0, y.steelPlateList[0].workshopId = we.workshopId && we.workshopId !== -1 ? we.workshopId : void 0, y.steelPlateList[0].warehouseId = we.warehouseId && we.warehouseId !== -1 ? we.warehouseId : void 0;
    }
  }
  function k(ie, ue) {
    var de;
    const ne = JSON.parse(JSON.stringify(ie)), te = Ct({ uid: Tt(), sn: ne.sn, specificationLabels: ne.specificationLabels, classifySerialNumber: ne.classifySerialNumber, serialNumber: ne.serialNumber, classifyId: ne.classifyId, classifyFullName: ne.classifyFullName, classifyName: ne.classifyName, classifyParentFullName: ne.classifyParentFullName, basicClass: ne.basicClass, specification: ne.specification, model: ne.spec, specificationMap: ne.specificationMap, measureUnit: ne.measureUnit, accountingUnit: ne.accountingUnit, accountingPrecision: ne.accountingPrecision, measurePrecision: ne.measurePrecision, quantity: ne.quantity, thickness: ne.thickness, length: ne.length, width: ne.width, theoryWeight: ne.theoryWeight, theoryTotalWeight: ne.theoryTotalWeight, weighingTotalWeight: ne.weighingTotalWeight, projectId: ne.projectId, workshopId: ne.workshopId, warehouseId: ne.warehouseId, rowIndex: y.steelPlateList.length, weightMeasurementMode: ne.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : ne.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : ne.amount, steelDensity: A(ne.steelDensity) ? ne.steelDensity : se.value[ne.classifyId] });
    y.steelPlateList.push(te), ge(te), (de = u.value) == null || de.initSelected([te]);
  }
  function J() {
    const ie = y.steelPlateList.filter((ne, te) => {
      var de;
      return ne.dataIndex = te, !!(n.boolPartyA || n.noDetail || (de = y.selectObj[ne.mergeId]) != null && de.isSelected);
    });
    if (Ae(ie)) return true;
    const { validResult: ue } = oe(ie);
    return ue && (ye(ie), ie.forEach((ne) => {
      var te, de;
      y.steelPlateList[ne.dataIndex].projectId = ne.projectId, y.steelPlateList[ne.dataIndex].workshopId = ne.workshopId || ((te = ne.workshop) == null ? void 0 : te.id), y.steelPlateList[ne.dataIndex].warehouseId = ne.warehouseId || ((de = ne.warehouse) == null ? void 0 : de.id);
    })), ue;
  }
  function z(ie, ue) {
  }
  function F(ie) {
    var ue;
    ie.weighingTotalWeight = (ue = ie == null ? void 0 : ie.applyPurchase) == null ? void 0 : ue.reduce((ne, te) => ne + (te.weighingTotalWeight || 0), 0);
  }
  Ce(() => y.steelPlateList, (ie) => {
    n.noDetail && T.value && T.value.updateFooter();
  }, { deep: true, immediate: true });
  function G(ie) {
    var ue;
    return [(ue = ie.columns) == null ? void 0 : ue.map((ne, te) => {
      if (te === 0) return "合计";
      if (ne.property === "quantity") return ie.data.reduce((pe, re) => pe + (Number(re.quantity) || 0), 0);
      if (ne.property === "weighingTotalWeight") {
        const de = ie.data.reduce((pe, re) => pe + (Number(re.weighingTotalWeight) || 0), 0);
        return de == null ? void 0 : de.toFixed(r.value.weight.precision);
      }
      if (ne.property === "amount") {
        const de = ie.data.reduce((pe, re) => pe + (Number(re.amount) || 0), 0);
        return Mi(de || 0);
      }
      return null;
    })];
  }
  return o({ rowInit: me, rowWatch: ge, toggleRowSelection: z, validate: J, setSelect: he }), (ie, ue) => {
    const ne = Mt, te = Ve("vxe-column"), de = Ve("vxe-tooltip"), pe = ya, re = Ve("common-input-number"), we = jt, Ke = vt, Me = Ve("common-radio-button"), Ne = Ve("common-button"), He = Ve("vxe-table"), ze = Ve("common-drawer"), Oe = _t("empty-text"), Re = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(He, { key: `inbound_${l(c)}`, ref_key: "tableRef", ref: T, "cell-class-name": l(ce), columnConfig: f.value, data: l(y).steelPlateList, "empty-text": "暂无数据", "footer-method": G, "max-height": e.maxHeight, "row-style": be, "scroll-y": m.value, border: "", class: "myTable-style", "show-overflow": "tooltip" }, { default: p(() => [s(te, { type: "expand", width: "60" }, { content: p(({ row: fe }) => [C("div", Uee, [s(ne, { modelValue: fe.remark, "onUpdate:modelValue": (Ue) => fe.remark = Ue, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(fe.inboundList) ? (w(), Q("div", Yee, [s(l(al), { "basic-class": l(c), list: fe.inboundList, material: fe, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(te, { title: "序号", type: "seq", width: "55" }), s(te, { align: "center", field: "serialNumber", title: "编号", width: "100" }), s(te, { align: "center", field: "classifyName", "min-width": "120", title: "物料种类" }, { default: p(({ row: fe }) => [s(de, { content: fe.classifyParentFullName, disabled: !fe.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[Oe, fe.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(te, { align: "center", field: "specification", "min-width": "100px", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: fe }) => {
      var Ue, Je, Xe;
      return [(Je = (Ue = l(y).selectObj) == null ? void 0 : Ue[fe.mergeId]) != null && Je.isSelected && ((Xe = l(g)) == null ? void 0 : Xe.spec) & l(c) && !fe.boolApplyPurchase ? (w(), U(pe, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Ye) => l(x)(fe) }, null, 8, ["onClick"])) : H("", true), s(de, { content: fe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(fe.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(te, { title: `厚 (${l(r).thickness.unit})`, align: "center", field: "thickness", "min-width": "100px", sortable: "" }, { default: p(({ row: fe }) => {
      var Ue, Je, Xe;
      return [n.boolPartyA || n.noDetail || (Je = (Ue = l(y).selectObj) == null ? void 0 : Ue[fe.mergeId]) != null && Je.isSelected && ((Xe = l(g)) == null ? void 0 : Xe.thickness) & l(c) && !fe.boolApplyPurchase ? (w(), U(re, { key: 0, modelValue: fe.thickness, "onUpdate:modelValue": (Ye) => fe.thickness = Ye, controls: false, max: 99999999, min: 0, precision: l(r).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Kee, K(fe.thickness), 1))];
    }), _: 1 }, 8, ["title"]), s(te, { title: `宽 (${l(r).width.unit})`, align: "center", field: "width", "min-width": "135px" }, { default: p(({ row: fe }) => {
      var Ue, Je;
      return [n.boolPartyA || n.noDetail || (Je = (Ue = l(y).selectObj) == null ? void 0 : Ue[fe.mergeId]) != null && Je.isSelected && !fe.boolApplyPurchase ? (w(), U(re, { key: 0, modelValue: fe.width, "onUpdate:modelValue": (Xe) => fe.width = Xe, controls: false, max: 99999999, min: 0, precision: l(r).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" }, onBlur: (Xe) => l(h)(fe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", Wee, K(fe.width), 1))];
    }), _: 1 }, 8, ["title"]), s(te, { title: `长 (${l(r).length.unit})`, align: "center", field: "length", "min-width": "135px" }, { default: p(({ row: fe }) => {
      var Ue, Je;
      return [n.boolPartyA || n.noDetail || (Je = (Ue = l(y).selectObj) == null ? void 0 : Ue[fe.mergeId]) != null && Je.isSelected && !fe.boolApplyPurchase ? (w(), U(re, { key: 0, modelValue: fe.length, "onUpdate:modelValue": (Xe) => fe.length = Xe, controls: false, max: 99999999, min: 0, precision: l(r).length.precision, placeholder: "长", size: "default", style: { width: "100%" }, onBlur: (Xe) => l(h)(fe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", jee, K(fe.length), 1))];
    }), _: 1 }, 8, ["title"]), n.boolPartyA || n.noDetail ? (w(), Q(Qe, { key: 0 }, [s(te, { title: `数量 (${l(r).measure.unit})`, align: "center", field: "quantity", "min-width": "135px" }, { default: p(({ row: fe }) => [s(re, { modelValue: fe.quantity, "onUpdate:modelValue": (Ue) => fe.quantity = Ue, controls: false, max: 999999999, min: 1, precision: l(r).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(te, { key: "weighingTotalWeight", title: `总重 (${l(r).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "135px" }, { default: p(({ row: fe }) => [s(we, { content: `理论重量：${fe.theoryTotalWeight} ${l(r).weight.unit}， ${l(b)}`, disabled: !fe.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(re, { modelValue: fe.weighingTotalWeight, "onUpdate:modelValue": (Ue) => fe.weighingTotalWeight = Ue, class: Zt({ "over-weight-tip": fe.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, "controls-position": "right", placeholder: "重量", size: "default", style: { width: "100%" }, onChange: (Ue) => X(fe) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onChange"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"])], 64)) : (w(), Q(Qe, { key: 1 }, [s(te, { title: "关联项目", align: "right", field: "projects", "min-width": "100px" }, { default: p(({ row: fe }) => [l(A)(fe.projects) ? (w(true), Q(Qe, { key: 0 }, ki(fe.projects, (Ue, Je) => {
      var Xe;
      return w(), Q("span", { key: Je }, K(l(di)(Ue)) + " " + K(Je + 1 === ((Xe = fe.projects) == null ? void 0 : Xe.length) ? "" : "、"), 1);
    }), 128)) : (w(), Q("span", Fee, "-"))]), _: 1 }), s(te, { title: `采购数量 (${l(r).measure.unit})`, align: "right", field: "purchaseQuantity", "min-width": "100px" }, { default: p(({ row: fe }) => [C("span", null, [s(de, { content: "已入库数量", placement: "top" }, { default: p(() => [C("span", zee, K(fe.inboundQuantity), 1)]), _: 2 }, 1024), Te(" / " + K(fe.purchaseQuantity), 1)])]), _: 1 }, 8, ["title"]), s(te, { title: `采购重量 (${l(r).weight.unit})`, align: "right", field: "purchaseMete", "min-width": "110px" }, { default: p(({ row: fe }) => [C("span", null, [s(de, { content: "已入库量", placement: "top" }, { default: p(() => [C("span", Bee, K(fe.inboundMete), 1)]), _: 2 }, 1024), Te(" / " + K(fe.purchaseMete), 1)])]), _: 1 }, 8, ["title"])], 64)), !n.boolPartyA && e.fillableAmount && e.noDetail ? (w(), U(qo, { key: 2 })) : H("", true), s(te, { align: "center", field: "brand", "min-width": "100px", title: "品牌" }, { default: p(({ row: fe }) => [n.boolPartyA || n.noDetail ? (w(), U(ne, { key: 0, modelValue: fe.brand, "onUpdate:modelValue": (Ue) => fe.brand = Ue, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", Hee, [Te(K(fe.brand), 1)])), [[Oe]])]), _: 1 }), n.boolPartyA || n.noDetail ? (w(), U(te, { key: 3, align: "center", field: "heatNoAndBatchNo", "min-width": "150px", title: "炉批号" }, { default: p(({ row: fe }) => {
      var Ue, Je;
      return [n.boolPartyA || n.noDetail || !n.boolPartyA && !n.noDetail && ((Je = (Ue = l(y).selectObj) == null ? void 0 : Ue[fe.mergeId]) != null && Je.isSelected) ? (w(), U(ne, { key: 0, modelValue: fe.heatNoAndBatchNo, "onUpdate:modelValue": (Xe) => fe.heatNoAndBatchNo = Xe, modelModifiers: { trim: true }, maxlength: "200", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", qee, [Te(K(fe.heatNoAndBatchNo), 1)])), [[Oe]])];
    }), _: 1 })) : H("", true), !n.boolPartyA && !n.noDetail ? (w(), Q(Qe, { key: 4 }, [s(te, { title: `理论重量 (${l(r).weight.unit})`, align: "center", field: "theoryTotalWeight", "min-width": "100px" }, { default: p(({ row: fe }) => [C("span", null, K(fe.theoryTotalWeight.toFixed(l(r).weight.precision)), 1)]), _: 1 }, 8, ["title"]), s(te, { key: "weighingTotalWeight", title: `实收量 (${l(r).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "150px" }, { default: p(({ row: fe }) => [s(we, { content: `理论重量：${fe.theoryTotalWeight} ${l(r).weight.unit}， ${l(b)}`, disabled: !fe.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => {
      var Ue, Je;
      return [(Je = (Ue = l(y).selectObj) == null ? void 0 : Ue[fe.mergeId]) != null && Je.isSelected ? (w(), U(re, { key: 0, modelValue: fe.weighingTotalWeight, "onUpdate:modelValue": (Xe) => fe.weighingTotalWeight = Xe, class: Zt({ "over-weight-tip": fe.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, "controls-position": "right", placeholder: "实收量", size: "default", style: { width: "100%" }, onBlur: (Xe) => l(h)(fe), onChange: (Xe) => Se(fe) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onBlur", "onChange"])) : (w(), Q("span", Gee, K(fe.weighingTotalWeight ? fe.weighingTotalWeight.toFixed(l(r).weight.precision) : "-"), 1))];
    }), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"]), s(te, { title: `本次实收数 (${l(r).measure.unit})`, align: "center", field: "quantity", width: "110px" }, { default: p(({ row: fe }) => [C("span", null, K(fe.quantity), 1)]), _: 1 }, 8, ["title"]), s(l(c2), { "base-unit": l(r), "basic-class": l(c), "current-cfg": l(g), form: l(y), handleOverQuantity: l(S), list: l(y).steelPlateList, order: e.order, onSave: F }, { editColumn: p(({ row: fe }) => [s(Ke, { align: "center", label: "规格", "min-width": "100px", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: Ue }) => {
      var Je;
      return [((Je = l(g)) == null ? void 0 : Je.spec) & l(c) ? (w(), U(pe, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Xe) => l(x)(Ue) }, null, 8, ["onClick"])) : H("", true), s(we, { content: Ue.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Ue.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(Ke, { label: `厚 (${l(r).thickness.unit})`, align: "center", "min-width": "100px", prop: "thickness" }, { default: p(({ row: Ue }) => {
      var Je;
      return [((Je = l(g)) == null ? void 0 : Je.thickness) & l(c) ? (w(), U(re, { key: 0, modelValue: Ue.thickness, "onUpdate:modelValue": (Xe) => Ue.thickness = Xe, controls: false, max: 99999999, min: 0, precision: l(r).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Qee, K(Ue.thickness), 1))];
    }), _: 1 }, 8, ["label"]), s(Ke, { label: `宽 (${l(r).width.unit})`, align: "center", "min-width": "100px", prop: "width" }, { default: p(({ row: Ue }) => [s(re, { modelValue: Ue.width, "onUpdate:modelValue": (Je) => Ue.width = Je, controls: false, max: 99999999, min: 0, precision: l(r).width.precision, "controls-position": "right", placeholder: "宽", size: "default", onBlur: (Je) => l(h)(Ue) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["label"]), s(Ke, { label: `长 (${l(r).length.unit})`, align: "center", "min-width": "100px", prop: "length" }, { default: p(({ row: Ue }) => [s(re, { modelValue: Ue.length, "onUpdate:modelValue": (Je) => Ue.length = Je, controls: false, max: 999999999, min: 0, precision: l(r).length.precision, placeholder: "长", size: "default", onBlur: (Je) => l(h)(Ue) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["base-unit", "basic-class", "current-cfg", "form", "handleOverQuantity", "list", "order"])], 64)) : H("", true), !n.boolPartyA && e.noDetail ? (w(), Q(Qe, { key: 5 }, [s(go, { list: l(y).steelPlateList, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: l(y).steelPlateList, showWarehouse: "" }, null, 8, ["list"]), s(te, { align: "center", field: "weightMeasurementMode", title: "计量方式", width: "140px" }, { default: p(({ row: fe }) => {
      var Ue;
      return [s(Me, { modelValue: fe.weightMeasurementMode, "onUpdate:modelValue": (Je) => fe.weightMeasurementMode = Je, disabled: ((Ue = e.order) == null ? void 0 : Ue.weightMeasurementMode) !== l(Wt).MIXTURE.V, options: l(Wt).ENUM, props: { key: "K", label: "SL", value: "V" }, "unshow-val": [l(Wt).MIXTURE.V], default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options", "unshow-val"])];
    }), _: 1 }), n.boolPartyA || n.noDetail ? (w(), U(te, { key: 0, align: "center", fixed: "right", label: "操作", width: "160" }, { default: p(({ row: fe, rowIndex: Ue }) => [s(Ne, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Je) => k(fe, Ue) }, null, 8, ["onClick"]), s(Ne, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Je) => $(fe.sn, Ue, fe) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)], 64)) : H("", true)]), _: 1 }, 8, ["cell-class-name", "columnConfig", "data", "max-height", "scroll-y"]))])), [[Re, _.value]]), s(ze, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": ue[1] || (ue[1] = (fe) => Gt(O) ? O.value = fe : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": ue[0] || (ue[0] = (fe) => Gt(L) ? L.value = fe : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, F3 = ut(Zee, [["__scopeId", "data-v-a11107d1"]]), Jee = Object.freeze(Object.defineProperty({ __proto__: null, default: F3 }, Symbol.toStringTag, { value: "Module" }));
const Xee = { style: { "overflow-x": "auto", width: "100%" } }, $ee = { class: "customize-option-item" }, ete = { class: "label" }, tte = { class: "extra-label" }, ite = { __name: "warehouse-select", props: { modelValue: { type: [Array, Number, String] }, workshopId: { type: [Array, Number] }, showAll: { type: Boolean, default: false }, showForbidden: { type: Boolean, default: false }, basicClass: { type: Number }, viewsDetail: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, onlyOneDefault: { type: Boolean, default: false }, placeholder: { type: String, default: "选择存储位置" } }, emits: ["change", "update:modelValue", "infoChange", "changeData"], setup(e, { emit: o }) {
  const n = o, c = e, u = { value: "id", label: "name", key: "id" }, r = Z(), { loaded: E, warehouseV2: y } = Sr(), b = Ee(() => {
    let S = y.value;
    return c.showForbidden || (S = S.filter((h) => h.enabled)), c.workshopId ? Array.isArray(c.workshopId) ? S = S.filter((h) => c.workshopId.includes(h.workshopId)) : S = S.filter((h) => c.workshopId === h.workshopId) : S = c.showAll ? S : [], c.basicClass && (S = S.filter((h) => h.materialType & c.basicClass)), S;
  });
  Ce(() => b.value, (S) => {
    console.log(S, "=========>");
  }, { deep: true }), Ce(b, (S) => {
    M();
  }), Ce(() => c.modelValue, (S) => {
    r.value = S, g();
  }, { immediate: true });
  function V(S) {
    let h = S;
    Ae(h) && (h = void 0);
    const T = !el(h, c.modelValue), _ = Ae(h) && Ae(c.modelValue);
    if (T && !_) {
      const m = b.value.find((R) => R.id === h) || {};
      n("update:modelValue", h), n("infoChange", m), n("change", h);
    }
    const f = b.value.find((m) => m.id === h) || {};
    n("changeData", f);
  }
  function M() {
    g();
  }
  function g() {
    if (!(Ae(b.value) || r.value)) {
      if (c.onlyOneDefault && b.value.length === 1) {
        r.value = b.value[0].value, V(r.value);
        return;
      }
      if (c.default) {
        r.value = b.value[0].value, V(r.value);
        return;
      }
      V(r.value);
    }
  }
  return (S, h) => {
    const T = jV, _ = _t("parse-enum");
    return w(), U(T, { modelValue: r.value, "onUpdate:modelValue": h[0] || (h[0] = (f) => r.value = f), clearable: e.clearable, "collapse-tags": e.collapseTags, disabled: e.disabled, loading: !l(E), multiple: e.multiple, options: b.value, placeholder: e.placeholder, size: e.size, filterable: "", props: u, onChange: V }, { view: p(({ data: f }) => [C("div", Xee, [C("span", $ee, [C("span", ete, K(f.name), 1), C("span", null, [C("span", tte, [h[1] || (h[1] = C("span", { class: "title" }, "存储类型：", -1)), qe(C("span", null, null, 512), [[_, { e: l(Pe), v: f.materialType, bit: true, split: " | " }]])])])])])]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "loading", "multiple", "options", "placeholder", "size"]);
  };
} }, z3 = ut(ite, [["__scopeId", "data-v-3b689a0a"]]), ate = Object.freeze(Object.defineProperty({ __proto__: null, default: z3 }, Symbol.toStringTag, { value: "Module" })), Fl = { __name: "warehouse-set-columns-vxe-begin", props: { boolManuf: { type: Boolean, default: false }, showWarehouse: { type: Boolean, default: true }, list: { type: Array, default: () => {
} }, isBegin: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = Z({ list: [] });
  Dt(() => {
    n.value = { list: o.list };
  });
  const { getNotDittoArr: c, initScopeList: u, handleValueChange: r, getRealVal: E } = Rn("workshopId"), y = Ee(() => c()), b = Ee(() => n.value.list || []);
  Dt(() => u(b.value));
  function V(S, h, T) {
    r(S, h), S !== -1 ? T.warehouseId = void 0 : pt(() => {
      Ae(T.warehouseId) && (T.warehouseId = -1);
    });
  }
  function M(S, h) {
    console.log(S), h.workshopName = S == null ? void 0 : S.name;
  }
  function g(S, h) {
    h.warehouseName = S == null ? void 0 : S.name;
  }
  return (S, h) => {
    const T = Ve("vxe-column");
    return w(), Q(Qe, null, [s(T, { align: "center", field: "workshopId", "min-width": "140px", title: "仓库" }, { default: p(({ row: _, rowIndex: f }) => [s(Mr, { modelValue: _.workshopId, "onUpdate:modelValue": (m) => _.workshopId = m, "show-extra": o.isBegin ? false : f !== 0, placeholder: "请选择仓库", style: { width: "100%" }, onChange: (m) => V(m, f, _), onChangeData: (m) => M(m, _) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange", "onChangeData"])]), _: 1 }), e.showWarehouse ? (w(), U(T, { key: 0, align: "center", field: "warehouseId", "min-width": "140px", title: "存储位置" }, { default: p(({ row: _, rowIndex: f }) => [s(z3, { modelValue: _.warehouseId, "onUpdate:modelValue": (m) => _.warehouseId = m, "basic-class": _.basicClass, "show-extra": o.isBegin ? false : b.value[f - 1] && !y.value.includes(f), clearable: "", "workshop-id": l(E)(f), placeholder: "存储位置", style: { width: "100%" }, onChangeData: (m) => g(m, _) }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "show-extra", "workshop-id", "onChangeData"])]), _: 1 })) : H("", true)], 64);
  };
} }, lte = Object.freeze(Object.defineProperty({ __proto__: null, default: Fl }, Symbol.toStringTag, { value: "Module" })), zl = { __name: "project-set-columns-sepcial-vxe", props: { order: { type: Object, default: () => ({}) }, requisitions: { type: Object, default: () => ({}) }, list: { type: Array, default: () => [] } }, setup(e) {
  const o = e, n = Z({ list: [] }), { projects: c } = Er();
  Dt(() => {
    n.value = { list: o.list };
  });
  const { initScopeList: u, handleValueChange: r } = Rn("projectId"), { initScopeList: E } = Rn("monomerId"), y = Ee(() => c.value.map((V) => ({ id: V.id, name: di(V, { showSerialNumber: true }) })));
  Dt(() => {
    u(n.value.list || []), E(n.value.list || []);
  });
  function b(V, M, g) {
    V || (g.projectFullName = null, g.projectSerialNumber = null), r(V, M);
    const S = y.value.find((h) => h.id === V);
    g.projectSerialNumber = S == null ? void 0 : S.name, g.projectFullName = S == null ? void 0 : S.name;
  }
  return (V, M) => {
    const g = Ve("vxe-column");
    return w(), U(g, { align: "center", field: "projectId", "min-width": "180", title: "所属项目" }, { default: p(({ row: S, $index: h }) => [s(ca, { "data-structure": { key: "id", label: "name", value: "id" }, modelValue: S.projectId, "onUpdate:modelValue": (T) => S.projectId = T, clearable: "", filterable: "", placeholder: "所属项目", onChange: (T) => b(T, h, S), style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 });
  };
} }, ote = Object.freeze(Object.defineProperty({ __proto__: null, default: zl }, Symbol.toStringTag, { value: "Module" }));
const nte = { style: { overflow: "hidden" } }, ste = { style: {} }, rte = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, ute = { key: 1 }, cte = { key: 1 }, dte = { key: 1 }, mte = { key: 1 }, pte = { key: 1 }, hte = { key: 1 }, fte = { key: 1 }, gte = { key: 1 }, Ete = { key: 1 }, yte = { key: 1 }, Tte = { __name: "steel-plate-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_PLATE.V, u = ft("matSpecRef"), { priceAbnormal: r } = aa(), { baseUnit: E } = ai(c), { cu: y, form: b } = Wi(), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g, currentCfg: S } = Va(E), h = Z(false), T = Z(null), _ = Z([{ seq: "合计", quantity: "-", mete: "-", amountExcludingVatFreight: "-", amount: "-", weighingTotalWeight: "-" }]);
  Ce(() => b.steelPlateList, (F) => {
    f();
  }, { deep: true, immediate: true });
  function f() {
    var te;
    let F = 0, G = 0, ie = 0, ue = 0, ne = 0;
    (te = b.steelPlateList) == null || te.forEach((de) => {
      F += Number(de.quantity) || 0, G += Number(de.mete) || 0, ie += Number(de.amount) || 0, ue += Number(de.amountExcludingVatFreight) || 0, ne += Number(de.weighingTotalWeight) || 0;
    }), G = G.toFixed(2), ne = ne.toFixed(2), ie = ie.toFixed(Ze.YUAN), ue = ue.toFixed(Ze.YUAN), _.value = [{ seq: "合计", quantity: F, mete: G, amountExcludingVatFreight: ue, amount: ie, weighingTotalWeight: ne }];
  }
  const m = Z({ resizable: true }), R = Z({ enabled: true, gt: 50, oSize: 10, scrollToTopOnChange: true }), { specSelectMaxHeight: v, specRef: N, drawerRef: P, editRow: L, editList: O, materialSelectVisible: x, handleClickEditSpec: I, handleSpecChange: Y } = Qa(), ee = /^(?!(0[0-9]{1,}$))[0-9]*[.]{0,}[0-9]{0,}$/, B = (F, G) => !!F, q = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], thickness: [{ required: true, message: "厚度必填", trigger: "blur" }, { validator: B, message: "厚度必须大于0", trigger: "blur" }], width: [{ required: true, message: "宽度必填", trigger: "blur" }, { validator: B, message: "宽度必须大于0", trigger: "blur" }], length: [{ required: true, message: "长度必填", trigger: "blur" }, { validator: B, message: "长度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: g, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: B, message: "重量必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: B, message: "数量必须大于0", trigger: "blur" }], amount: [{ required: true, message: "请输入含税金额", trigger: "blur" }, { pattern: ee, message: "含税金额必须大于0", trigger: "blur" }], amountExcludingVatFreight: [{ required: true, message: "请输入不含税金额", trigger: "blur" }, { pattern: ee, message: "不含税金额必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], materialIsWholeName: [{ required: true, message: "请选择整料/余料", trigger: "change" }] }, ae = { amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, j = Ee(() => {
    let F = Object.assign({}, q);
    return !n.boolPartyA && n.fillableAmount && (F = Object.assign(F, ae)), F;
  }), le = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: oe, cleanUpData: ye, wrongCellMask: ce } = ui({ rules: j, ditto: le, errorMsg: "请修正【钢板清单】中标红的信息" });
  function se() {
  }
  function he({ row: F, rowIndex: G }) {
    var ie, ue;
    if ((ue = (ie = y == null ? void 0 : y.submitResult) == null ? void 0 : ie.data) != null && ue.includes(F.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function be(F) {
    Dt(() => {
      var G, ie, ue, ne;
      F.needFirstCalcTheoryWeight && (F.boolApplyPurchase || (ge(F), Le(F)), F.boolApplyPurchase && ((ie = (G = b.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected) && (F.quantity = (ue = F == null ? void 0 : F.applyPurchase) == null ? void 0 : ue.reduce((te, de) => te + (de.quantity || 0), 0), F.theoryTotalWeight = (ne = F == null ? void 0 : F.applyPurchase) == null ? void 0 : ne.reduce((te, de) => te + (de.theoryTotalWeight || 0), 0)), F.needFirstCalcTheoryWeight = false), M(F);
    }), Ce([() => F.boolApplyPurchase, () => F == null ? void 0 : F.applyPurchase], () => {
      var G, ie, ue, ne;
      F.boolApplyPurchase && ((ie = (G = b.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected) && (F.quantity = (ue = F == null ? void 0 : F.applyPurchase) == null ? void 0 : ue.reduce((te, de) => te + (de.quantity || 0), 0), F.theoryTotalWeight = (ne = F == null ? void 0 : F.applyPurchase) == null ? void 0 : ne.reduce((te, de) => te + (de.theoryTotalWeight || 0), 0), F.weighingTotalWeight = F.theoryTotalWeight);
    }, { deep: true }), Ce(() => F, () => {
      var G, ie, ue;
      if (!n.boolPartyA && !n.noDetail && ((ie = (G = b.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected)) {
        const ne = (ue = b.selectObj[F.mergeId]) == null ? void 0 : ue.isSelected;
        b.selectObj[F.mergeId] = { ...b.selectObj[F.mergeId], ...F, mete: F.weighingTotalWeight, isSelected: ne };
      }
    }, { deep: true }), F.boolApplyPurchase || (Ce([() => F.length, () => F.width, () => F.thickness, E], () => ge(F)), Ce([() => F.theoryWeight, () => F.quantity], () => Le(F))), Ce(() => F.weighingTotalWeight, () => {
      Ie(F);
    });
  }
  function me(F, G) {
    Le(G);
  }
  async function ge(F) {
    F.theoryWeight = await na({ classifyId: F.classifyId, name: F.classifyFullName, length: F.length, width: F.width, thickness: F.thickness });
  }
  function Le(F) {
    A(F == null ? void 0 : F.theoryWeight) && F.quantity ? (F.theoryTotalWeight = Be(F.theoryWeight * F.quantity, E.value.weight.precision), F.weighingTotalWeight = Be(F.theoryWeight * F.quantity, E.value.weight.precision)) : (F.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (F.weighingTotalWeight = void 0));
  }
  function Ie(F) {
    A(F.unitPrice) && A(F.weighingTotalWeight);
  }
  function Se(F, G, ie) {
    var ue, ne, te, de;
    if ((ne = (ue = y == null ? void 0 : y.submitResult) == null ? void 0 : ue.data) != null && ne.includes(ie.classifyId)) {
      const pe = (te = y == null ? void 0 : y.submitResult) == null ? void 0 : te.data.findIndex((we) => we === ie.classifyId);
      b.steelPlateList.filter((we) => we.classifyId === ie.classifyId).length === 1 && ((de = y == null ? void 0 : y.submitResult) == null || de.data.splice(pe, 1));
    }
    if (u.value ? u.value.delListItem(F, G) : b.steelPlateList.splice(G, 1), A(b.steelPlateList) && b.steelPlateList.length > 0) {
      const pe = b.steelPlateList[0];
      b.steelPlateList[0].projectId = pe.projectId && pe.projectId !== -1 ? pe.projectId : void 0, b.steelPlateList[0].workshopId = pe.workshopId && pe.workshopId !== -1 ? pe.workshopId : void 0, b.steelPlateList[0].warehouseId = pe.warehouseId && pe.warehouseId !== -1 ? pe.warehouseId : void 0;
    }
  }
  function X(F, G) {
    var ne;
    const ie = JSON.parse(JSON.stringify(F)), ue = Ct({ uid: Tt(), sn: ie.sn, specificationLabels: ie.specificationLabels, classifySerialNumber: ie.classifySerialNumber, serialNumber: ie.serialNumber, classifyId: ie.classifyId, classifyFullName: ie.classifyFullName, classifyName: ie.classifyName, classifyParentFullName: ie.classifyParentFullName, basicClass: ie.basicClass, specification: ie.specification, model: ie.spec, specificationMap: ie.specificationMap, measureUnit: ie.measureUnit, accountingUnit: ie.accountingUnit, accountingPrecision: ie.accountingPrecision, measurePrecision: ie.measurePrecision, quantity: ie.quantity, thickness: ie.thickness, length: ie.length, width: ie.width, theoryWeight: ie.theoryWeight, theoryTotalWeight: ie.theoryTotalWeight, weighingTotalWeight: ie.weighingTotalWeight, rowIndex: b.steelPlateList.length, weightMeasurementMode: ie.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : ie.unitPrice, amount: ie.amount, brand: ie.brand, heatNoAndBatchNo: ie.heatNoAndBatchNo, amountExcludingVatFreight: ie.amountExcludingVatFreight, projectSerialNumber: ie.projectSerialNumber, projectId: ie.projectId, workshopName: ie.workshopName, warehouseName: ie.warehouseName, workshopId: ie.workshopId, warehouseId: ie.warehouseId, materialIsWholeName: ie.materialIsWholeName, steelDensity: A(ie.steelDensity) ? ie.steelDensity : J.value[ie.classifyId] });
    b.steelPlateList.push(ue), be(ue), (ne = u.value) == null || ne.initSelected([ue]);
  }
  async function $() {
    const F = At(b.steelPlateList), { validResult: G } = oe(b.steelPlateList);
    let ie = true;
    if (G) {
      const ue = [];
      if (A(r.value) && r.value.forEach((ne) => {
        var de;
        const te = (de = b.steelPlateList) == null ? void 0 : de.filter((pe) => pe.basicClass === ne.basicClass);
        A(te) && te.forEach((pe) => {
          ne.minPrice && pe.amount < ne.minPrice * pe.weighingTotalWeight && ue.push({ msg: `${Pe.VL[pe.basicClass]} ${pe.serialNumber} ${pe.classifyName}：含税金额${pe.amount} < 异常配置最小值${ne.minPrice}*总重` }), ne.maxPrice && pe.amount > ne.maxPrice * pe.weighingTotalWeight && ue.push({ msg: `${Pe.VL[pe.basicClass]} ${pe.serialNumber} ${pe.classifyName}：含税金额${pe.amount} > 异常配置最大值${ne.maxPrice}*总重` });
        });
      }), A(ue)) {
        const ne = ue.map((te) => `<div>${te.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + ne, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          ie = true;
        }).catch((te) => {
          ie = false;
        });
      }
      if (!ie) return false;
    }
    if (G) ye(F), F.forEach((ue) => {
    });
    else {
      const ue = b.steelPlateList.find((ne) => ne.verify ? Object.values(ne.verify).some((te) => te === false) : false);
      ue && T.value && pt(() => {
        T.value.scrollToRow(ue);
      });
    }
    return G && ie;
  }
  function k(F, G) {
  }
  const J = ft("steelDensityCfg");
  function z(F) {
    const G = Ct({ uid: Tt(), sn: F.sn, specificationLabels: F.specificationLabels, classifySerialNumber: F.classify.serialNumber, serialNumber: F.serialNumber, classifyId: F.classify.id, classifyFullName: F.classify.fullName, classifyName: F.classify.name, classifyParentFullName: F.classify.parentFullName, basicClass: F.classify.basicClass, specification: F.spec, model: F.spec, specificationMap: F.specKV, measureUnit: F.classify.measureUnit, accountingUnit: F.classify.accountingUnit, accountingPrecision: F.classify.accountingPrecision, measurePrecision: F.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, weighingTotalWeight: void 0, steelDensity: A(F.steelDensity) ? F.steelDensity : J.value[F.classify.id] });
    return be(G), G;
  }
  return o({ type: "begin", rowInit: z, rowWatch: be, toggleRowSelection: k, validate: $, setSelect: se }), (F, G) => {
    const ie = Mt, ue = Ve("vxe-column"), ne = Ve("vxe-tooltip"), te = ya, de = Ve("common-input-number"), pe = jt, re = zo, we = Bo, Ke = Ve("common-button"), Me = Ve("vxe-table"), Ne = Ve("common-drawer"), He = _t("empty-text"), ze = oi;
    return w(), Q("div", null, [qe((w(), Q("div", nte, [(w(), U(Me, { ref_key: "tableRef", ref: T, key: `inbound_${l(c)}`, "cell-class-name": l(ce), "column-config": m.value, data: l(b).steelPlateList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": he, "scroll-y": R.value, border: "", "footer-data": _.value, "show-footer": "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(ue, { type: "expand", width: "60" }, { content: p(({ row: Oe }) => [C("div", ste, [s(ie, { modelValue: Oe.remark, "onUpdate:modelValue": (Re) => Oe.remark = Re, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(Oe.inboundList) ? (w(), Q("div", rte, [s(l(al), { "basic-class": l(c), list: Oe.inboundList, material: Oe, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(ue, { title: "序号", type: "seq", width: "55" }), s(ue, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: Oe }) => [s(ne, { content: Oe.classifyParentFullName, disabled: !Oe.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[He, Oe.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ue, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: Oe }) => {
      var Re, fe, Ue;
      return [(fe = (Re = l(b).selectObj) == null ? void 0 : Re[Oe.mergeId]) != null && fe.isSelected && ((Ue = l(S)) == null ? void 0 : Ue.spec) & l(c) && !Oe.boolApplyPurchase ? (w(), U(te, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Je) => l(I)(Oe) }, null, 8, ["onClick"])) : H("", true), s(ne, { content: Oe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Oe.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(ue, { title: `厚 (${l(E).thickness.unit})`, align: "center", field: "thickness", "min-width": "120" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(de, { key: 0, modelValue: Oe.thickness, "onUpdate:modelValue": (Re) => Oe.thickness = Re, controls: false, max: 99999999, min: 0, precision: l(E).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" }, onBlur: (Re) => me(Re, Oe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", ute, K(Oe.thickness), 1))]), _: 1 }, 8, ["title"]), s(ue, { title: `宽 (${l(E).width.unit})`, align: "center", field: "width", "min-width": "120" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(de, { key: 0, modelValue: Oe.width, "onUpdate:modelValue": (Re) => Oe.width = Re, controls: false, max: 99999999, min: 0, precision: l(E).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" }, onBlur: (Re) => me(Re, Oe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", cte, K(Oe.width), 1))]), _: 1 }, 8, ["title"]), s(ue, { title: `长 (${l(E).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(de, { key: 0, modelValue: Oe.length, "onUpdate:modelValue": (Re) => Oe.length = Re, controls: false, max: 99999999, min: 0, precision: l(E).length.precision, placeholder: "长", size: "default", style: { width: "100%" }, onBlur: (Re) => me(Re, Oe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", dte, K(Oe.length), 1))]), _: 1 }, 8, ["title"]), s(ue, { title: `数量 （${l(E).measure.unit})`, align: "center", field: "quantity", "min-width": "120" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(de, { key: 0, modelValue: Oe.quantity, "onUpdate:modelValue": (Re) => Oe.quantity = Re, controls: false, max: 999999999, min: 1, precision: l(E).measure.precision, placeholder: "数量", size: "default", style: { width: "100%" }, onBlur: (Re) => me(Re, Oe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", mte, K(Oe.quantity), 1))]), _: 1 }, 8, ["title"]), s(ue, { title: `总重 (${l(E).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(pe, { key: 0, content: `理论重量：${Oe.theoryTotalWeight} ${l(E).weight.unit}， ${l(V)}`, disabled: !Oe.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(de, { modelValue: Oe.weighingTotalWeight, "onUpdate:modelValue": (Re) => Oe.weighingTotalWeight = Re, class: Zt({ "over-weight-tip": Oe.hasOver }), controls: false, max: 999999999, min: 0, precision: l(E).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])) : (w(), Q("span", pte, K(Oe.weighingTotalWeight), 1))]), _: 1 }, 8, ["title"]), s(ue, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(ie, { key: 0, modelValue: Oe.brand, "onUpdate:modelValue": (Re) => Oe.brand = Re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", hte, K(Oe.brand), 1))]), _: 1 }), s(ue, { align: "center", field: "heatNoAndBatchNo", title: "炉批号", width: "120" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(ie, { key: 0, modelValue: Oe.heatNoAndBatchNo, "onUpdate:modelValue": (Re) => Oe.heatNoAndBatchNo = Re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", fte, K(Oe.heatNoAndBatchNo), 1))]), _: 1 }), s(ue, { align: "center", field: "amount", title: "含税金额", width: "120" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(de, { key: 0, modelValue: Oe.amount, "onUpdate:modelValue": (Re) => Oe.amount = Re, controls: false, min: 0, precision: 2, placeholder: "含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", gte, K(Oe.amount), 1))]), _: 1 }), s(ue, { align: "center", field: "amountExcludingVatFreight", title: "不含税金额", width: "120" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(de, { key: 0, modelValue: Oe.amountExcludingVatFreight, "onUpdate:modelValue": (Re) => Oe.amountExcludingVatFreight = Re, controls: false, min: 0, precision: 2, placeholder: "不含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Ete, K(Oe.amountExcludingVatFreight), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(b).steelPlateList }, null, 8, ["list"])) : (w(), U(ue, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: Oe }) => [C("span", null, K(Oe.projectFullName || Oe.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(b).steelPlateList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(ue, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: Oe }) => [C("span", null, K(Oe.workshopName), 1)]), _: 1 }), s(ue, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: Oe }) => [C("span", null, K(Oe.warehouseName), 1)]), _: 1 })], 64)), s(ue, { align: "center", field: "materialIsWholeName", title: "整料/余料", width: "140" }, { default: p(({ row: Oe }) => [e.isEdit ? (w(), U(we, { key: 0, modelValue: Oe.materialIsWholeName, "onUpdate:modelValue": (Re) => Oe.materialIsWholeName = Re, placeholder: "请选择", size: "default", style: { width: "100%" } }, { default: p(() => [s(re, { label: "整料", value: "整料" }), s(re, { label: "余料", value: "余料" })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", yte, K(Oe.materialIsWholeName), 1))]), _: 1 }), e.isEdit ? (w(), U(ue, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: Oe, rowIndex: Re }) => [s(Ke, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (fe) => X(Oe, Re) }, null, 8, ["onClick"]), s(Ke, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (fe) => Se(Oe.sn, Re, Oe) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[ze, h.value]]), s(Ne, { ref_key: "drawerRef", ref: P, modelValue: l(x), "onUpdate:modelValue": G[1] || (G[1] = (Oe) => Gt(x) ? x.value = Oe : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: N, modelValue: l(O), "onUpdate:modelValue": G[0] || (G[0] = (Oe) => Gt(O) ? O.value = Oe : null), classifyId: l(L).classifyId, "max-height": l(v), "show-classify": false, visible: l(x), "expand-query": "", mode: "selector", onChange: l(Y) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, B3 = ut(Tte, [["__scopeId", "data-v-404f4c8d"]]), _te = Object.freeze(Object.defineProperty({ __proto__: null, default: B3 }, Symbol.toStringTag, { value: "Module" }));
const bte = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Vte = { key: 1 }, wte = { key: 1 }, Ste = { class: "color-green" }, vte = { class: "color-green" }, Rte = { key: 1 }, Mte = { key: 1 }, Ate = { key: 1 }, Nte = { key: 1 }, Lte = { __name: "section-steel-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 } }, setup(e, { expose: o }) {
  const n = e, c = Ge.SECTION_STEEL.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), b = Z(false), V = Z({ resizable: true }), M = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), { overDiffTip: g, weightOverDiff: S, diffSubmitValidate: h, currentCfg: T } = Va(r), { handleOverQuantity: _, handleOverMete: f } = Us({ meteField: "weighingTotalWeight" }), m = Z(), { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), Y = (ne, te) => !n.noDetail && !n.boolPartyA && A(ne) ? ne > 0 : !!ne, ee = (ne, te) => n.noDetail ? !!ne : true, B = (ne, te) => !!ne, q = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ validator: Y, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: B, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: h, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: B, message: "重量必须大于0", trigger: "blur" }], workshopId: [{ validator: ee, message: "请选择仓库", trigger: "change" }], warehouseId: [{ validator: ee, message: "请选择存储位置", trigger: "change" }] }, j = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (ne, te) => A(te.weighingTotalWeight) && A(te.unitPrice) ? +Be(te.weighingTotalWeight * te.unitPrice, Ze.YUAN) == +ne : false, message: "金额有误，请手动修改", trigger: "blur" }] }, le = Ee(() => {
    let ne = Object.assign({}, q);
    return !n.boolPartyA && n.fillableAmount && (ne = Object.assign(ne, j)), ne;
  }), oe = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: ye, cleanUpData: ce, wrongCellMask: se } = ui({ rules: le, ditto: oe, errorMsg: "请修正【型材清单】中标红的信息" });
  function he(ne, te) {
    const de = te == null ? void 0 : te.find((pe) => pe.standardId === ne.standardId);
    ne.unitWeight = de == null ? void 0 : de.unitWeight;
  }
  function be() {
  }
  function me({ row: ne, rowIndex: te }) {
    var de, pe;
    if ((pe = (de = E == null ? void 0 : E.submitResult) == null ? void 0 : de.data) != null && pe.includes(ne.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ge(ne) {
    var we;
    const te = (we = ne.nationalStandardOptions.find((Ke) => Ke.boolDefault === true)) == null ? void 0 : we.standardId, de = Ct({ uid: Tt(), sn: ne.sn, specificationLabels: ne.specificationLabels, classifySerialNumber: ne.classify.serialNumber, serialNumber: ne.serialNumber, classifyId: ne.classify.id, classifyFullName: ne.classify.fullName, classifyName: ne.classify.name, classifyParentFullName: ne.classify.parentFullName, basicClass: ne.classify.basicClass, specification: ne.spec, model: ne.spec, specificationMap: ne.specKV, measureUnit: ne.classify.measureUnit, accountingUnit: ne.classify.accountingUnit, accountingPrecision: ne.classify.accountingPrecision, measurePrecision: ne.classify.measurePrecision, unitWeight: ne.unitWeight, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false, nationalStandardOptions: ne.nationalStandardOptions, standardId: te, sectionSteelSpec: void 0, doNotSectionSteelSpec: void 0, projectId: y.sectionSteelList.length > 0 ? -1 : void 0, workshopId: y.sectionSteelList.length > 0 ? -1 : void 0, warehouseId: y.sectionSteelList.length > 0 ? -1 : void 0, weightMeasurementMode: n.order.weightMeasurementMode ? n.order.weightMeasurementMode === Wt.MIXTURE.V ? Wt.THEORY.V : n.order.weightMeasurementMode : void 0, rowIndex: y.sectionSteelList.length });
    let pe;
    const re = [];
    for (const Ke in de.specificationMap) Ke.indexOf("standard") > -1 ? pe = de.specificationMap[Ke] : re.push(de.specificationMap[Ke]);
    return de.sectionSteelSpec = pe, de.doNotSectionSteelSpec = re.join(" * "), !n.boolPartyA && n.fillableAmount && (de.unitPrice = void 0, de.amount = void 0), Le(de), de;
  }
  function Le(ne) {
    Dt(() => {
      var te, de, pe, re, we, Ke;
      ne.needFirstCalcTheoryWeight && ((n.boolPartyA || n.noDetail || (de = (te = y.selectObj) == null ? void 0 : te[ne.mergeId]) != null && de.isSelected && !ne.boolApplyPurchase) && (Ie(ne), X(ne)), ne.boolApplyPurchase && ((re = (pe = y.selectObj) == null ? void 0 : pe[ne.mergeId]) != null && re.isSelected) && (ne == null || ne.applyPurchase.map((Me) => {
        A(Me.length) && A(Me.quantity) ? Me.totalLength = Na({ length: Me.length, quantity: Me.quantity }) : Me.totalLength = void 0;
      }), ne.theoryTotalWeight = (we = ne == null ? void 0 : ne.applyPurchase) == null ? void 0 : we.reduce((Me, Ne) => Me + (Ne.theoryTotalWeight || 0), 0), ne.totalLength = (Ke = ne == null ? void 0 : ne.applyPurchase) == null ? void 0 : Ke.reduce((Me, Ne) => Me + (Ne.totalLength || 0), 0)), ne.needFirstCalcTheoryWeight = false), S(ne);
    }), Ce([() => ne.boolApplyPurchase, () => ne == null ? void 0 : ne.applyPurchase], () => {
      var te, de, pe;
      ne.boolApplyPurchase && (ne.quantity = ((te = ne == null ? void 0 : ne.applyPurchase) == null ? void 0 : te.reduce((re, we) => re + (we.quantity || 0), 0)) || 0, ne.theoryTotalWeight = ((de = ne == null ? void 0 : ne.applyPurchase) == null ? void 0 : de.reduce((re, we) => re + (we.theoryTotalWeight || 0), 0)) || 0, ne.totalLength = ((pe = ne == null ? void 0 : ne.applyPurchase) == null ? void 0 : pe.reduce((re, we) => re + (we.totalLength || 0), 0)) || 0);
    }, { deep: true }), Ce(() => ne, () => {
      var te, de, pe;
      if (!n.boolPartyA && !n.noDetail && ((de = (te = y.selectObj) == null ? void 0 : te[ne.mergeId]) != null && de.isSelected)) {
        const re = (pe = y.selectObj[ne.mergeId]) == null ? void 0 : pe.isSelected;
        y.selectObj[ne.mergeId] = { ...y.selectObj[ne.mergeId], ...ne, mete: ne.weighingTotalWeight, isSelected: re };
      }
    }, { deep: true }), ne.boolApplyPurchase || (Ce([() => ne.length, () => ne.unitWeight, r], () => Ie(ne)), Ce([() => ne.theoryWeight, () => ne.quantity], () => {
      X(ne);
    })), Ce(() => ne.weighingTotalWeight, () => {
      k(ne);
    }), Ce([() => ne.length, () => ne.quantity], () => {
      Se(ne);
    });
  }
  async function Ie(ne) {
    ne.theoryWeight = await xa({ length: ne.length, unitWeight: ne.unitWeight });
  }
  function Se(ne) {
    var te, de;
    (n.boolPartyA || n.noDetail || (de = (te = y.selectObj) == null ? void 0 : te[ne.mergeId]) != null && de.isSelected && !ne.boolApplyPurchase) && (A(ne.length) && ne.quantity ? ne.totalLength = Na({ length: ne.length, quantity: ne.quantity }) : ne.totalLength = void 0);
  }
  function X(ne) {
    A(ne.theoryWeight) && ne.quantity ? (ne.theoryTotalWeight = Be(ne.theoryWeight * ne.quantity, r.value.weight.precision), (n.boolPartyA || n.noDetail) && (ne.weighingTotalWeight = Be(ne.theoryWeight * ne.quantity, r.value.weight.precision))) : (ne.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (ne.weighingTotalWeight = void 0));
  }
  function $(ne) {
    var te;
    if (A(ne.weighingTotalWeight) && (te = ne.applyPurchase) != null && te.length) {
      let de = ne.weighingTotalWeight;
      ne.applyPurchase.forEach((pe, re) => {
        if (pe.quantity) {
          let we = 0;
          re !== ne.applyPurchase.length - 1 && de !== 0 ? (we = ji(pe.theoryTotalWeight / ne.theoryTotalWeight * ne.weighingTotalWeight, r.value.weight.precision, { toNum: true }), de -= we) : we += de, pe.weighingTotalWeight = we;
        }
      });
    }
    k(ne);
  }
  function k(ne) {
    A(ne.unitPrice) && A(ne.weighingTotalWeight) ? ne.amount = Be(ne.weighingTotalWeight * ne.unitPrice, Ze.YUAN) : ne.amount = void 0;
  }
  function J(ne, te, de) {
    var pe, re, we, Ke;
    if ((re = (pe = E == null ? void 0 : E.submitResult) == null ? void 0 : pe.data) != null && re.includes(de.classifyId)) {
      const Me = (we = E == null ? void 0 : E.submitResult) == null ? void 0 : we.data.findIndex((He) => He === de.classifyId);
      y.sectionSteelList.filter((He) => He.classifyId === de.classifyId).length === 1 && ((Ke = E == null ? void 0 : E.submitResult) == null || Ke.data.splice(Me, 1));
    }
    if (u.value ? u.value.delListItem(ne, te) : y.sectionSteelList.splice(te, 1), A(y.sectionSteelList) && y.sectionSteelList.length > 0) {
      const Me = y.sectionSteelList[0];
      y.sectionSteelList[0].projectId = Me.projectId && Me.projectId !== -1 ? Me.projectId : void 0, y.sectionSteelList[0].workshopId = Me.workshopId && Me.workshopId !== -1 ? Me.workshopId : void 0, y.sectionSteelList[0].warehouseId = Me.warehouseId && Me.warehouseId !== -1 ? Me.warehouseId : void 0;
    }
  }
  function z(ne, te) {
    var re;
    const de = JSON.parse(JSON.stringify(ne)), pe = Ct({ uid: Tt(), sn: de.sn, specificationLabels: de.specificationLabels, classifySerialNumber: de.classifySerialNumber, serialNumber: de.serialNumber, classifyId: de.classifyId, classifyFullName: de.classifyFullName, classifyName: de.classifyName, classifyParentFullName: de.classifyParentFullName, basicClass: de.basicClass, specification: de.specification, model: de.model, specificationMap: de.specificationMap, measureUnit: de.measureUnit, accountingUnit: de.accountingUnit, accountingPrecision: de.accountingPrecision, measurePrecision: de.measurePrecision, unitWeight: de.unitWeight, quantity: de.quantity, length: de.length, totalLength: de.totalLength, theoryWeight: de.theoryWeight, theoryTotalWeight: de.theoryTotalWeight, weighingTotalWeight: de.weighingTotalWeight, hasOver: false, nationalStandardOptions: de.nationalStandardOptions, standardId: de.standardId, sectionSteelSpec: de.sectionSteelSpec, doNotSectionSteelSpec: de.doNotSectionSteelSpec, projectId: de.projectId, workshopId: de.workshopId, warehouseId: de.warehouseId, weightMeasurementMode: de.weightMeasurementMode, rowIndex: y.sectionSteelList.length, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : de.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : de.amount });
    y.sectionSteelList.push(pe), Le(pe), (re = u.value) == null || re.initSelected([pe]);
  }
  function F() {
    const ne = y.sectionSteelList.filter((de, pe) => {
      var re;
      return de.dataIndex = pe, !!(n.boolPartyA || n.noDetail || (re = y.selectObj[de.mergeId]) != null && re.isSelected);
    });
    if (Ae(ne)) return true;
    const { validResult: te } = ye(ne);
    return te && (ce(ne), ne.forEach((de) => {
      var pe, re;
      y.sectionSteelList[de.dataIndex].projectId = de.projectId, y.sectionSteelList[de.dataIndex].workshopId = de.workshopId || ((pe = de.workshop) == null ? void 0 : pe.id), y.sectionSteelList[de.dataIndex].warehouseId = de.warehouseId || ((re = de.warehouse) == null ? void 0 : re.id);
    })), te;
  }
  function G(ne, te) {
  }
  Ce(() => y.sectionSteelList, (ne) => {
    n.noDetail && m.value && m.value.updateFooter();
  }, { deep: true, immediate: true });
  function ie(ne) {
    var te;
    return [(te = ne.columns) == null ? void 0 : te.map((de, pe) => {
      if (pe === 0) return "合计";
      if (de.property === "quantity") return ne.data.reduce((we, Ke) => we + (Number(Ke.quantity) || 0), 0);
      if (de.property === "weighingTotalWeight") {
        const re = ne.data.reduce((we, Ke) => we + (Number(Ke.weighingTotalWeight) || 0), 0);
        return re == null ? void 0 : re.toFixed(r.value.weight.precision);
      }
      if (de.property === "amount") {
        const re = ne.data.reduce((we, Ke) => we + (Number(Ke.amount) || 0), 0);
        return Mi(re || 0);
      }
      return null;
    })];
  }
  function ue(ne) {
    var te;
    ne.weighingTotalWeight = (te = ne == null ? void 0 : ne.applyPurchase) == null ? void 0 : te.reduce((de, pe) => de + (pe.weighingTotalWeight || 0), 0);
  }
  return o({ rowInit: ge, rowWatch: Le, toggleRowSelection: G, validate: F, setSelect: be }), (ne, te) => {
    const de = Mt, pe = Ve("vxe-column"), re = Ve("vxe-tooltip"), we = ya, Ke = Ve("common-input-number"), Me = Ve("common-select"), Ne = jt, He = vt, ze = Ve("common-radio-button"), Oe = Ve("common-button"), Re = Ve("vxe-table"), fe = Ve("common-drawer"), Ue = _t("empty-text"), Je = oi;
    return w(), Q(Qe, null, [C("div", null, [qe((w(), Q("div", null, [(w(), U(Re, { key: `inbound_${l(c)}`, ref_key: "tableRef", ref: m, "cell-class-name": l(se), columnConfig: V.value, data: l(y).sectionSteelList, "empty-text": "暂无数据", "footer-method": ie, "max-height": e.maxHeight, "row-style": me, "scroll-y": M.value, border: "", class: "myTable-style", "show-footer": "", "show-overflow": "tooltip" }, { default: p(() => [s(pe, { type: "expand", width: "60" }, { content: p(({ row: Xe }) => [s(de, { modelValue: Xe.remark, "onUpdate:modelValue": (Ye) => Xe.remark = Ye, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(Xe.inboundList) ? (w(), Q("div", bte, [s(l(al), { "basic-class": l(c), list: Xe.inboundList, material: Xe, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)]), _: 1 }), s(pe, { title: "序号", type: "seq", width: "55" }), s(pe, { align: "center", field: "serialNumber", title: "编号", width: "100" }), s(pe, { align: "center", field: "classifyName", "min-width": "120", title: "物料种类" }, { default: p(({ row: Xe }) => [s(re, { content: Xe.classifyParentFullName, disabled: !Xe.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[Ue, Xe.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(pe, { align: "center", field: "specification", "min-width": "100px", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: Xe }) => {
      var Ye, Fe, et;
      return [(Fe = (Ye = l(y).selectObj) == null ? void 0 : Ye[Xe.mergeId]) != null && Fe.isSelected && ((et = l(T)) == null ? void 0 : et.spec) & l(c) && !Xe.boolApplyPurchase ? (w(), U(we, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (lt) => l(x)(Xe) }, null, 8, ["onClick"])) : H("", true), s(re, { content: Xe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Xe.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(pe, { title: `定尺长度 (${l(r).length.unit})`, align: "center", field: "length", "min-width": "135px" }, { default: p(({ row: Xe }) => {
      var Ye, Fe, et;
      return [n.boolPartyA || n.noDetail || (Fe = (Ye = l(y).selectObj) == null ? void 0 : Ye[Xe.mergeId]) != null && Fe.isSelected && ((et = l(T)) == null ? void 0 : et.length) & l(c) && !Xe.boolApplyPurchase ? (w(), U(Ke, { key: 0, modelValue: Xe.length, "onUpdate:modelValue": (lt) => Xe.length = lt, controls: false, max: 99999999, min: 0, precision: l(r).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Vte, K(Xe.length), 1))];
    }), _: 1 }, 8, ["title"]), n.boolPartyA || n.noDetail ? (w(), Q(Qe, { key: 0 }, [s(pe, { align: "center", field: "standardId", "min-width": "200px", "show-overflow-tooltip": "", title: "标准" }, { default: p(({ row: Xe }) => [s(Me, { modelValue: Xe.standardId, "onUpdate:modelValue": (Ye) => Xe.standardId = Ye, dataStructure: { key: "standardId", label: "name", value: "standardId" }, options: Xe.nationalStandardOptions || [], placeholder: "请选择标准", style: { width: "100%" }, type: "other", onChange: (Ye) => he(Xe, Xe.nationalStandardOptions) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), s(pe, { title: `数量 (${l(r).measure.unit})`, align: "center", field: "quantity", "min-width": "135px" }, { default: p(({ row: Xe }) => [s(Ke, { modelValue: Xe.quantity, "onUpdate:modelValue": (Ye) => Xe.quantity = Ye, controls: false, max: 999999999, min: 1, precision: l(r).measure.precision, step: 5, "controls-position": "right", placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(pe, { title: "总长度 (m)", align: "center", field: "totalLength", "min-width": "135px" }), s(pe, { key: "weighingTotalWeight", title: `总重 (${l(r).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "135px" }, { default: p(({ row: Xe }) => [s(Ne, { content: `单位重量：${Xe.unitWeight} kg/m， 理论重量：${Xe.theoryTotalWeight} kg， ${l(g)}`, disabled: !Xe.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(Ke, { modelValue: Xe.weighingTotalWeight, "onUpdate:modelValue": (Ye) => Xe.weighingTotalWeight = Ye, class: Zt({ "over-weight-tip": Xe.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, "controls-position": "right", placeholder: "重量", size: "default", style: { width: "100%" }, onChange: (Ye) => k(Xe) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onChange"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"])], 64)) : (w(), Q(Qe, { key: 1 }, [s(pe, { title: "关联项目", align: "right", field: "projects", "min-width": "100px" }, { default: p(({ row: Xe }) => [l(A)(Xe.projects) ? (w(true), Q(Qe, { key: 0 }, ki(Xe.projects, (Ye, Fe) => {
      var et;
      return w(), Q("span", { key: Fe }, K(l(di)(Ye)) + " " + K(Fe + 1 === ((et = Xe.projects) == null ? void 0 : et.length) ? "" : "、"), 1);
    }), 128)) : (w(), Q("span", wte, "-"))]), _: 1 }), s(pe, { title: `采购数量 (${l(r).measure.unit})`, align: "right", field: "purchaseQuantity", "min-width": "100px" }, { default: p(({ row: Xe }) => [C("span", null, [s(re, { content: "已入库数量", placement: "top" }, { default: p(() => [C("span", Ste, K(Xe.inboundQuantity), 1)]), _: 2 }, 1024), Te(" / " + K(Xe.purchaseQuantity), 1)])]), _: 1 }, 8, ["title"]), s(pe, { title: `采购重量 (${l(r).weight.unit})`, align: "right", field: "purchaseMete", "min-width": "110px" }, { default: p(({ row: Xe }) => [C("span", null, [s(re, { content: "已入库量", placement: "top" }, { default: p(() => [C("span", vte, K(Xe.inboundMete), 1)]), _: 2 }, 1024), Te(" / " + K(Xe.purchaseMete), 1)])]), _: 1 }, 8, ["title"])], 64)), !n.boolPartyA && e.fillableAmount && e.noDetail ? (w(), U(qo, { key: 2 })) : H("", true), s(pe, { align: "center", field: "brand", "min-width": "100px", title: "品牌" }, { default: p(({ row: Xe }) => [n.boolPartyA || n.noDetail ? (w(), U(de, { key: 0, modelValue: Xe.brand, "onUpdate:modelValue": (Ye) => Xe.brand = Ye, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", Rte, [Te(K(Xe.brand), 1)])), [[Ue]])]), _: 1 }), n.boolPartyA || n.noDetail ? (w(), U(pe, { key: 3, align: "center", field: "heatNoAndBatchNo", "min-width": "150px", title: "炉批号" }, { default: p(({ row: Xe }) => {
      var Ye, Fe;
      return [n.boolPartyA || n.noDetail || !n.boolPartyA && !n.noDetail && ((Fe = (Ye = l(y).selectObj) == null ? void 0 : Ye[Xe.mergeId]) != null && Fe.isSelected) ? (w(), U(de, { key: 0, modelValue: Xe.heatNoAndBatchNo, "onUpdate:modelValue": (et) => Xe.heatNoAndBatchNo = et, modelModifiers: { trim: true }, maxlength: "200", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", Mte, [Te(K(Xe.heatNoAndBatchNo), 1)])), [[Ue]])];
    }), _: 1 })) : H("", true), !n.boolPartyA && !n.noDetail ? (w(), Q(Qe, { key: 4 }, [s(pe, { title: "实收总长度 (m)", align: "center", field: "totalLength", "min-width": "135px" }, { default: p(({ row: Xe }) => [C("span", null, K(l(A)(Xe.totalLength) ? Xe.totalLength.toFixed(3) : "-"), 1)]), _: 1 }), s(pe, { title: `理论重量 (${l(r).weight.unit})`, align: "center", field: "theoryTotalWeight", "min-width": "100px" }, { default: p(({ row: Xe }) => [C("span", null, K(Xe.theoryTotalWeight.toFixed(l(r).weight.precision)), 1)]), _: 1 }, 8, ["title"]), s(pe, { key: "weighingTotalWeight", title: `实收量 (${l(r).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "150px" }, { default: p(({ row: Xe }) => [s(Ne, { content: `理论重量：${Xe.theoryTotalWeight} ${l(r).weight.unit}， ${l(g)}`, disabled: !Xe.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => {
      var Ye, Fe;
      return [(Fe = (Ye = l(y).selectObj) == null ? void 0 : Ye[Xe.mergeId]) != null && Fe.isSelected ? (w(), U(Ke, { key: 0, modelValue: Xe.weighingTotalWeight, "onUpdate:modelValue": (et) => Xe.weighingTotalWeight = et, class: Zt({ "over-weight-tip": Xe.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, "controls-position": "right", placeholder: "实收量", size: "default", style: { width: "100%" }, onBlur: (et) => l(f)(Xe), onChange: (et) => $(Xe) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onBlur", "onChange"])) : (w(), Q("span", Ate, K(Xe.weighingTotalWeight ? Xe.weighingTotalWeight.toFixed(l(r).weight.precision) : "-"), 1))];
    }), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"]), s(pe, { title: `本次实收数 (${l(r).measure.unit})`, align: "center", field: "quantity", width: "110px" }, { default: p(({ row: Xe }) => [C("span", null, K(Xe.quantity), 1)]), _: 1 }, 8, ["title"]), s(l(c2), { "base-unit": l(r), "basic-class": l(c), "current-cfg": l(T), form: l(y), handleOverQuantity: l(_), list: l(y).sectionSteelList, order: e.order, onSave: ue }, { editColumn: p(({ row: Xe }) => [s(He, { align: "center", label: "规格", "min-width": "100px", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: Ye }) => {
      var Fe;
      return [((Fe = l(T)) == null ? void 0 : Fe.spec) & l(c) ? (w(), U(we, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (et) => l(x)(Ye) }, null, 8, ["onClick"])) : H("", true), s(Ne, { content: Ye.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Ye.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(He, { align: "center", label: "标准", "min-width": "200px", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: Ye }) => [s(Me, { modelValue: Ye.standardId, "onUpdate:modelValue": (Fe) => Ye.standardId = Fe, dataStructure: { key: "standardId", label: "name", value: "standardId" }, options: Xe.nationalStandardOptions || [], placeholder: "请选择标准", size: "default", style: { width: "100%" }, type: "other", onChange: (Fe) => he(Ye, Xe.nationalStandardOptions) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 2 }, 1024), s(He, { label: `定尺长度 (${l(r).length.unit})`, align: "center", "min-width": "100px", prop: "length" }, { default: p(({ row: Ye }) => {
      var Fe;
      return [((Fe = l(T)) == null ? void 0 : Fe.length) & l(c) ? (w(), U(Ke, { key: 0, modelValue: Ye.length, "onUpdate:modelValue": (et) => Ye.length = et, controls: false, max: 999999999, min: 0, precision: l(r).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Nte, K(Xe.length), 1))];
    }), _: 2 }, 1032, ["label"])]), _: 1 }, 8, ["base-unit", "basic-class", "current-cfg", "form", "handleOverQuantity", "list", "order"])], 64)) : H("", true), !n.boolPartyA && e.noDetail ? (w(), Q(Qe, { key: 5 }, [s(go, { list: l(y).sectionSteelList, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: l(y).sectionSteelList, showWarehouse: "" }, null, 8, ["list"]), s(pe, { align: "center", field: "weightMeasurementMode", title: "计量方式", width: "140px" }, { default: p(({ row: Xe }) => {
      var Ye;
      return [s(ze, { modelValue: Xe.weightMeasurementMode, "onUpdate:modelValue": (Fe) => Xe.weightMeasurementMode = Fe, disabled: ((Ye = e.order) == null ? void 0 : Ye.weightMeasurementMode) !== l(Wt).MIXTURE.V, options: l(Wt).ENUM, props: { key: "K", label: "SL", value: "V" }, "unshow-val": [l(Wt).MIXTURE.V], default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options", "unshow-val"])];
    }), _: 1 }), n.boolPartyA || n.noDetail ? (w(), U(pe, { key: 0, align: "center", fixed: "right", label: "操作", width: "160" }, { default: p(({ row: Xe, rowIndex: Ye }) => [s(Oe, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Fe) => z(Xe, Ye) }, null, 8, ["onClick"]), s(Oe, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Fe) => J(Xe.sn, Ye) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)], 64)) : H("", true)]), _: 1 }, 8, ["cell-class-name", "columnConfig", "data", "max-height", "scroll-y"]))])), [[Je, b.value]])]), s(fe, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": te[1] || (te[1] = (Xe) => Gt(O) ? O.value = Xe : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "型材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": te[0] || (te[0] = (Xe) => Gt(L) ? L.value = Xe : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, H3 = ut(Lte, [["__scopeId", "data-v-82fd8311"]]), Ite = Object.freeze(Object.defineProperty({ __proto__: null, default: H3 }, Symbol.toStringTag, { value: "Module" }));
const Cte = { style: { overflow: "hidden" } }, Pte = { style: {} }, Ote = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, kte = { key: 1 }, Dte = { key: 1 }, xte = { key: 1 }, Ute = { key: 1 }, Yte = { key: 1 }, Kte = { key: 1 }, Wte = { key: 1 }, jte = { key: 1 }, Fte = { key: 1 }, zte = { __name: "section-steel-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.SECTION_STEEL.V, u = ft("matSpecRef"), { priceAbnormal: r } = aa(), { baseUnit: E } = ai(c), { cu: y, form: b } = Wi(), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g, currentCfg: S } = Va(E), h = Z(false), T = Z(null), _ = Z({ resizable: true }), f = Z({ enabled: true, gt: 60, oSize: 10, scrollToTopOnChange: true }), m = Z([{ seq: "合计", quantity: "-", mete: "-", amountExcludingVatFreight: "-", amount: "-", weighingTotalWeight: "-" }]);
  Ce(() => b.sectionSteelList, (F) => {
    R();
  }, { deep: true, immediate: true });
  function R() {
    var te;
    let F = 0, G = 0, ie = 0, ue = 0, ne = 0;
    (te = b.sectionSteelList) == null || te.forEach((de) => {
      F += Number(de.quantity) || 0, G += Number(de.mete) || 0, ie += Number(de.amount) || 0, ue += Number(de.amountExcludingVatFreight) || 0, ne += Number(de.weighingTotalWeight) || 0;
    }), G = G.toFixed(2), ne = ne.toFixed(2), ie = ie.toFixed(Ze.YUAN), ue = ue.toFixed(Ze.YUAN), m.value = [{ seq: "合计", quantity: F, mete: G, amountExcludingVatFreight: ue, amount: ie, weighingTotalWeight: ne }];
  }
  const { specSelectMaxHeight: v, specRef: N, drawerRef: P, editRow: L, editList: O, materialSelectVisible: x, handleClickEditSpec: I, handleSpecChange: Y } = Qa(), ee = /^(?!(0[0-9]{1,}$))[0-9]*[.]{0,}[0-9]{0,}$/, B = (F, G) => !!F, q = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], profileLibraryStandard: [{ required: true, message: "请选择型材库标准", trigger: "change" }], length: [{ required: true, message: "长度必填", trigger: "blur" }, { validator: B, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: B, message: "数量必须大于0", trigger: "blur" }], amount: [{ required: true, message: "请输入含税金额", trigger: "change" }, { pattern: ee, message: "含税金额必须大于0", trigger: "blur" }], amountExcludingVatFreight: [{ required: true, message: "请输入不含税金额", trigger: "change" }, { pattern: ee, message: "不含税金额必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], materialIsWholeName: [{ required: true, message: "请选择整料/余料", trigger: "change" }] }, ae = Ee(() => {
    let F = Object.assign({}, q);
    return !n.boolPartyA && n.fillableAmount && (F = Object.assign(F, {})), F;
  }), j = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: le, cleanUpData: oe, wrongCellMask: ye } = ui({ rules: ae, ditto: j, errorMsg: "请修正【型材清单】中标红的信息" });
  function ce() {
  }
  function se({ row: F, rowIndex: G }) {
    var ie, ue;
    if ((ue = (ie = y == null ? void 0 : y.submitResult) == null ? void 0 : ie.data) != null && ue.includes(F.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function he(F, G) {
    Ie(G);
  }
  function be(F) {
    const G = F.nationalStandardOptions.find((re) => re.boolDefault === true), ie = G == null ? void 0 : G.standardId, ue = G == null ? void 0 : G.name, ne = G == null ? void 0 : G.unitWeight, te = Ct({ uid: Tt(), sn: F.sn, specificationLabels: F.specificationLabels, classifySerialNumber: F.classify.serialNumber, serialNumber: F.serialNumber, classifyId: F.classify.id, classifyFullName: F.classify.fullName, classifyName: F.classify.name, classifyParentFullName: F.classify.parentFullName, basicClass: F.classify.basicClass, specification: F.arr[0], model: F.spec, specificationMap: F.specKV, measureUnit: F.classify.measureUnit, accountingUnit: F.classify.accountingUnit, accountingPrecision: F.classify.accountingPrecision, measurePrecision: F.classify.measurePrecision, material: F.arr[1], standardId: ie, brand: F.brand, heatNoAndBatchNo: F.heatNoAndBatchNo, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, nationalStandardOptions: F.nationalStandardOptions, profileLibraryStandard: ue, unitWeight: ne });
    let de;
    const pe = [];
    for (const re in te.specificationMap) re.indexOf("standard") > -1 ? de = te.specificationMap[re] : pe.push(te.specificationMap[re]);
    return te.sectionSteelSpec = de, te.doNotSectionSteelSpec = pe.join(" * "), !n.boolPartyA && n.fillableAmount && (te.unitPrice = void 0, te.amount = void 0), me(te), te;
  }
  function me(F) {
    Dt(() => {
      var G, ie, ue, ne, te, de;
      F.needFirstCalcTheoryWeight && ((n.boolPartyA || n.noDetail || (ie = (G = b.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected && !F.boolApplyPurchase) && (Le(F), Ie(F)), F.boolApplyPurchase && ((ne = (ue = b.selectObj) == null ? void 0 : ue[F.mergeId]) != null && ne.isSelected) && (F == null || F.applyPurchase.map((pe) => {
        A(pe.length) && A(pe.quantity) ? pe.totalLength = Na({ length: pe.length, quantity: pe.quantity }) : pe.totalLength = void 0;
      }), F.theoryTotalWeight = (te = F == null ? void 0 : F.applyPurchase) == null ? void 0 : te.reduce((pe, re) => pe + (re.theoryTotalWeight || 0), 0), F.totalLength = (de = F == null ? void 0 : F.applyPurchase) == null ? void 0 : de.reduce((pe, re) => pe + (re.totalLength || 0), 0)), F.needFirstCalcTheoryWeight = false), M(F);
    }), Ce([() => F.boolApplyPurchase, () => F == null ? void 0 : F.applyPurchase], () => {
      var G, ie, ue;
      F.boolApplyPurchase && (F.quantity = ((G = F == null ? void 0 : F.applyPurchase) == null ? void 0 : G.reduce((ne, te) => ne + (te.quantity || 0), 0)) || 0, F.theoryTotalWeight = ((ie = F == null ? void 0 : F.applyPurchase) == null ? void 0 : ie.reduce((ne, te) => ne + (te.theoryTotalWeight || 0), 0)) || 0, F.weighingTotalWeight = F.theoryTotalWeight, F.totalLength = ((ue = F == null ? void 0 : F.applyPurchase) == null ? void 0 : ue.reduce((ne, te) => ne + (te.totalLength || 0), 0)) || 0);
    }, { deep: true }), Ce(() => F, () => {
      var G, ie, ue;
      if (!n.boolPartyA && !n.noDetail && ((ie = (G = b.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected)) {
        const ne = (ue = b.selectObj[F.mergeId]) == null ? void 0 : ue.isSelected;
        b.selectObj[F.mergeId] = { ...b.selectObj[F.mergeId], ...F, mete: F.weighingTotalWeight, isSelected: ne };
      }
    }, { deep: true }), F.boolApplyPurchase || (Ce([() => F.length, () => F.unitWeight, E], () => Le(F)), Ce([() => F.theoryWeight, () => F.quantity], () => {
      Ie(F);
    })), Ce(() => F.weighingTotalWeight, () => {
      Se(F);
    }), Ce([() => F.length, () => F.quantity], () => {
      ge(F);
    });
  }
  function ge(F) {
    var G, ie;
    (n.boolPartyA || n.noDetail || (ie = (G = b.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected && !F.boolApplyPurchase) && (A(F.length) && F.quantity ? F.totalLength = Na({ length: F.length, quantity: F.quantity }) : F.totalLength = void 0);
  }
  async function Le(F) {
    F.theoryWeight = await xa({ length: F.length, unitWeight: F.unitWeight });
  }
  function Ie(F) {
    A(F.theoryWeight) && F.quantity ? (F.theoryTotalWeight = Be(F.theoryWeight * F.quantity, E.value.weight.precision), F.weighingTotalWeight = Be(F.theoryWeight * F.quantity, E.value.weight.precision)) : (F.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (F.weighingTotalWeight = void 0));
  }
  function Se(F) {
    A(F.unitPrice) && A(F.weighingTotalWeight) ? F.amount = Be(F.weighingTotalWeight * F.unitPrice, Ze.YUAN) : (F.amount = void 0, F.amountExcludingVatFreight = void 0);
  }
  function X(F, G, ie) {
    u.value ? u.value.delListItem(F, G) : b.sectionSteelList.splice(G, 1);
  }
  function $(F, G) {
    var de;
    const ie = JSON.parse(JSON.stringify(F)), ue = Ct({ uid: Tt(), sn: ie.sn, specificationLabels: ie.specificationLabels, classifySerialNumber: ie.classifySerialNumber, serialNumber: ie.serialNumber, classifyId: ie.classifyId, classifyFullName: ie.classifyFullName, classifyName: ie.classifyName, classifyParentFullName: ie.classifyParentFullName, basicClass: ie.basicClass, specification: ie.specification, model: ie.spec, specificationMap: ie.specificationMap, measureUnit: ie.measureUnit, accountingUnit: ie.accountingUnit, accountingPrecision: ie.accountingPrecision, measurePrecision: ie.measurePrecision, material: ie.material, quantity: ie.quantity, thickness: ie.thickness, length: ie.length, width: ie.width, theoryWeight: ie.theoryWeight, theoryTotalWeight: ie.theoryTotalWeight, weighingTotalWeight: ie.weighingTotalWeight, rowIndex: b.sectionSteelList.length, weightMeasurementMode: ie.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : ie.unitPrice, amount: ie.amount, profileLibraryStandard: ie.profileLibraryStandard, nationalStandardOptions: ie.nationalStandardOptions, standardId: ie.standardId, unitWeight: ie.unitWeight, brand: ie.brand, heatNoAndBatchNo: ie.heatNoAndBatchNo, amountExcludingVatFreight: ie.amountExcludingVatFreight, projectSerialNumber: ie.projectSerialNumber, projectId: ie.projectId, workshopName: ie.workshopName, warehouseName: ie.warehouseName, workshopId: ie.workshopId, warehouseId: ie.warehouseId, materialIsWholeName: ie.materialIsWholeName });
    let ne;
    const te = [];
    for (const pe in ue.specificationMap) pe.indexOf("standard") > -1 ? ne = ue.specificationMap[pe] : te.push(ue.specificationMap[pe]);
    ue.sectionSteelSpec = ne, ue.doNotSectionSteelSpec = te.join(" * "), b.sectionSteelList.push(ue), me(ue), (de = u.value) == null || de.initSelected([ue]);
  }
  function k(F, G, ie) {
    const ue = ie == null ? void 0 : ie.find((ne) => ne.name === F);
    G.standardId = ue == null ? void 0 : ue.standardId, G.unitWeight = ue == null ? void 0 : ue.unitWeight;
  }
  async function J() {
    const F = At(b.sectionSteelList), { validResult: G } = le(b.sectionSteelList);
    if (G) {
      let ie = true;
      const ue = [];
      if (A(r.value) && r.value.forEach((ne) => {
        var de;
        const te = (de = b.sectionSteelList) == null ? void 0 : de.filter((pe) => pe.basicClass === ne.basicClass);
        A(te) && te.forEach((pe) => {
          ne.minPrice && pe.amount < ne.minPrice * pe.weighingTotalWeight && ue.push({ msg: `${Pe.VL[pe.basicClass]} ${pe.serialNumber} ${pe.classifyName}：含税金额${pe.amount} < 异常配置最小值${ne.minPrice}*总重` }), ne.maxPrice && pe.amount > ne.maxPrice * pe.weighingTotalWeight && ue.push({ msg: `${Pe.VL[pe.basicClass]} ${pe.serialNumber} ${pe.classifyName}：含税金额${pe.amount} > 异常配置最大值${ne.maxPrice}*总重` });
        });
      }), A(ue)) {
        const ne = ue.map((te) => `<div>${te.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + ne, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          ie = true;
        }).catch((te) => {
          ie = false;
        });
      }
      if (!ie) return false;
    }
    if (G) oe(F), F.forEach((ie) => {
    });
    else {
      const ie = b.sectionSteelList.find((ue) => ue.verify ? Object.values(ue.verify).some((ne) => ne === false) : false);
      ie && T.value && pt(() => {
        T.value.scrollToRow(ie);
      });
    }
    return G;
  }
  function z(F, G) {
  }
  return o({ type: "begin", rowInit: be, rowWatch: me, toggleRowSelection: z, validate: J, setSelect: ce }), (F, G) => {
    const ie = Mt, ue = Ve("vxe-column"), ne = Ve("vxe-tooltip"), te = ya, de = Ve("common-select-v2"), pe = Ve("common-input-number"), re = jt, we = zo, Ke = Bo, Me = Ve("common-button"), Ne = Ve("vxe-table"), He = Ve("common-drawer"), ze = _t("empty-text"), Oe = oi;
    return w(), Q("div", null, [qe((w(), Q("div", Cte, [(w(), U(Ne, { ref_key: "tableRef", ref: T, key: `inbound_${l(c)}`, "cell-class-name": l(ye), "column-config": _.value, data: l(b).sectionSteelList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": se, "scroll-y": f.value, border: "", "footer-data": m.value, "show-footer": "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(ue, { type: "expand", width: "60" }, { content: p(({ row: Re }) => [C("div", Pte, [s(ie, { modelValue: Re.remark, "onUpdate:modelValue": (fe) => Re.remark = fe, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(Re.inboundList) ? (w(), Q("div", Ote, [s(l(al), { "basic-class": l(c), list: Re.inboundList, material: Re, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(ue, { title: "序号", type: "seq", width: "55", fixed: "left" }), s(ue, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: Re }) => [s(ne, { content: Re.classifyParentFullName, disabled: !Re.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ze, Re.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(b).id ? H("", true) : (w(), U(ue, { key: 0, align: "center", field: "material", "min-width": "100", title: "材质" })), s(ue, { align: "center", field: "material", "min-width": "120", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: Re }) => {
      var fe, Ue, Je;
      return [(Ue = (fe = l(b).selectObj) == null ? void 0 : fe[Re.mergeId]) != null && Ue.isSelected && ((Je = l(S)) == null ? void 0 : Je.spec) & l(c) && !Re.boolApplyPurchase ? (w(), U(te, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Xe) => l(I)(Re) }, null, 8, ["onClick"])) : H("", true), s(ne, { content: Re.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Re.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(ue, { align: "center", field: "profileLibraryStandard", "min-width": "140", title: "型材库标准" }, { default: p(({ row: Re }) => [e.isEdit ? (w(), U(de, { key: 0, modelValue: Re.profileLibraryStandard, "onUpdate:modelValue": (fe) => Re.profileLibraryStandard = fe, dataStructure: { key: "standardId", label: "name", value: "name" }, options: Re.nationalStandardOptions || [], placeholder: "请选择标准", style: { width: "100%" }, type: "other", onChange: (fe) => k(fe, Re, Re.nationalStandardOptions) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (w(), Q("span", kte, K(Re.profileLibraryStandard), 1))]), _: 1 }), s(ue, { title: `定尺长度 (${l(E).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: Re }) => [e.isEdit ? (w(), U(pe, { key: 0, modelValue: Re.length, "onUpdate:modelValue": (fe) => Re.length = fe, controls: false, max: 99999999, min: 0, precision: l(E).length.precision, placeholder: "长", size: "default", style: { width: "100%" }, onBlur: (fe) => he(fe, Re) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", Dte, K(Re.length), 1))]), _: 1 }, 8, ["title"]), s(ue, { title: `数量 （${l(E).measure.unit})`, align: "center", field: "quantity", "min-width": "120" }, { default: p(({ row: Re }) => [e.isEdit ? (w(), U(pe, { key: 0, modelValue: Re.quantity, "onUpdate:modelValue": (fe) => Re.quantity = fe, controls: false, max: 99999999, min: 1, precision: l(E).measure.precision, placeholder: "数量", size: "default", style: { width: "100%" }, onBlur: (fe) => he(fe, Re) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", xte, K(Re.quantity), 1))]), _: 1 }, 8, ["title"]), s(ue, { title: `总重 (${l(E).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: Re }) => [e.isEdit ? (w(), U(re, { key: 0, content: `理论重量：${Re.theoryTotalWeight} ${l(E).weight.unit}， ${l(V)}`, disabled: !Re.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(pe, { modelValue: Re.weighingTotalWeight, "onUpdate:modelValue": (fe) => Re.weighingTotalWeight = fe, class: Zt({ "over-weight-tip": Re.hasOver }), controls: false, max: 999999999, min: 0, precision: l(E).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])) : (w(), Q("span", Ute, K(Re.weighingTotalWeight), 1))]), _: 1 }, 8, ["title"]), s(ue, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: Re }) => [e.isEdit ? (w(), U(ie, { key: 0, modelValue: Re.brand, "onUpdate:modelValue": (fe) => Re.brand = fe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Yte, K(Re.brand), 1))]), _: 1 }), s(ue, { align: "center", field: "heatNoAndBatchNo", title: "炉批号", width: "120" }, { default: p(({ row: Re }) => [e.isEdit ? (w(), U(ie, { key: 0, modelValue: Re.heatNoAndBatchNo, "onUpdate:modelValue": (fe) => Re.heatNoAndBatchNo = fe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Kte, K(Re.heatNoAndBatchNo), 1))]), _: 1 }), s(ue, { align: "center", field: "amount", title: "含税金额", width: "120" }, { default: p(({ row: Re }) => [e.isEdit ? (w(), U(pe, { key: 0, modelValue: Re.amount, "onUpdate:modelValue": (fe) => Re.amount = fe, controls: false, min: 0, precision: 2, placeholder: "含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Wte, K(Re.amount), 1))]), _: 1 }), s(ue, { align: "center", field: "amountExcludingVatFreight", title: "不含税金额", width: "120" }, { default: p(({ row: Re }) => [e.isEdit ? (w(), U(pe, { key: 0, modelValue: Re.amountExcludingVatFreight, "onUpdate:modelValue": (fe) => Re.amountExcludingVatFreight = fe, controls: false, min: 0, precision: 2, placeholder: "不含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", jte, K(Re.amountExcludingVatFreight), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 1, list: l(b).sectionSteelList }, null, 8, ["list"])) : (w(), U(ue, { key: 2, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: Re }) => [C("span", null, K(Re.projectFullName || Re.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 3, "is-begin": true, list: l(b).sectionSteelList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 4 }, [s(ue, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: Re }) => [C("span", null, K(Re.workshopName), 1)]), _: 1 }), s(ue, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: Re }) => [C("span", null, K(Re.warehouseName), 1)]), _: 1 })], 64)), s(ue, { align: "center", field: "materialIsWholeName", title: "整料/余料", width: "140" }, { default: p(({ row: Re }) => [e.isEdit ? (w(), U(Ke, { key: 0, modelValue: Re.materialIsWholeName, "onUpdate:modelValue": (fe) => Re.materialIsWholeName = fe, placeholder: "请选择", size: "default", style: { width: "100%" } }, { default: p(() => [s(we, { label: "整料", value: "整料" }), s(we, { label: "余料", value: "余料" })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Fte, K(Re.materialIsWholeName), 1))]), _: 1 }), e.isEdit ? (w(), U(ue, { key: 5, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: Re, rowIndex: fe }) => [s(Me, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Ue) => $(Re, fe) }, null, 8, ["onClick"]), s(Me, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ue) => X(Re.sn, fe, Re) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[Oe, h.value]]), s(He, { ref_key: "drawerRef", ref: P, modelValue: l(x), "onUpdate:modelValue": G[1] || (G[1] = (Re) => Gt(x) ? x.value = Re : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: N, modelValue: l(O), "onUpdate:modelValue": G[0] || (G[0] = (Re) => Gt(O) ? O.value = Re : null), classifyId: l(L).classifyId, "max-height": l(v), "show-classify": false, visible: l(x), "expand-query": "", mode: "selector", onChange: l(Y) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, q3 = ut(zte, [["__scopeId", "data-v-8a3b214f"]]), Bte = Object.freeze(Object.defineProperty({ __proto__: null, default: q3 }, Symbol.toStringTag, { value: "Module" })), Hte = ["onClick"], Td = { __name: "inbound-quantity-column-coil", props: { baseUnit: { type: Object, default: () => {
} }, currentCfg: { type: Object, required: true }, form: { type: Object, required: true }, list: { type: Array, required: () => [] }, basicClass: { type: Number, required: true }, handleOverQuantity: { type: Function, required: true }, order: { type: Object, default: () => {
} } }, setup(e) {
  const { inboundFillWayCfg: o } = aa(), n = Ee(() => o.value.saveInboundState === Sl.MODIFY.V), c = e, u = Z({}), r = Z(false), { maxHeight: E } = Kt({ mainBox: ".inbound-requisition-dialog", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, Ee(() => r.value));
  async function y(ce) {
    var se, he, be;
    if (u.value = ce, (se = u.value.applyPurchase) == null || se.forEach((me) => {
      me.specification = me.specification || ce.specification, me.thickness = me.thickness || ce.thickness, me.length = me.length || ce.length, me.width = me.width || ce.width, me.brand = me.brand || ce.brand, me.heatNoAndBatchNo = me.heatNoAndBatchNo || ce.heatNoAndBatchNo, me.projectId = me.origin_projectId ? me.projectId : me.projectId || ce.projectId, me.workshopId = me.workshopId || ce.workshopId, me.warehouseId = me.warehouseId || ce.warehouseId, me.color = me.color || ce.color, me.unitNet = me.unitNet || ce.unitNet, me.model = me.specification, me.sn = me.sn || ce.sn, me.specificationLabels = me.specificationLabels || ce.specificationLabels, me.serialNumber = me.serialNumber || ce.serialNumber, me.classifyId = me.classifyId || ce.classifyId, me.classifyFullName = me.classifyFullName || ce.classifyFullName, me.classifyName = me.classifyName || ce.classifyName, me.classifyParentFullName = me.classifyParentFullName || ce.classifyParentFullName, me.basicClass = me.basicClass || ce.basicClass, me.specification = me.specification || ce.specification, me.specificationMap = me.specKV || ce.specKV, me.measureUnit = me.measureUnit || ce.measureUnit, me.accountingUnit = me.accountingUnit || ce.accountingUnit, me.measurePrecision = me.measurePrecision || ce.measurePrecision, me.accountingPrecision = me.accountingPrecision || ce.accountingPrecision, me.unitWeight = me.unitWeight || ce.unitWeight, me.unitPrice = me.unitPrice || ce.unitPrice, M(me);
    }), c.basicClass & Ge.SECTION_STEEL.V) {
      let me;
      const ge = [];
      for (const Le in u.value.specificationMap) Le.indexOf("standard") > -1 ? me = u.value.specificationMap[Le] : ge.push(u.value.specificationMap[Le]);
      u.value.nationalStandardOptions = ce.nationalStandardOptions, u.value.standardId || (u.value.standardId = (be = (he = u.value.nationalStandardOptions) == null ? void 0 : he.find((Le) => Le.boolDefault)) == null ? void 0 : be.standardId), u.value.applyPurchase.forEach((Le) => {
        Le.standardId = Le.standardId || u.value.standardId, Le.sectionSteelSpec = Le.sectionSteelSpec || me, Le.doNotSectionSteelSpec = Le.doNotSectionSteelSpec || ge.join("*");
      });
    }
    u.value.originApplyPurchase = JSON.parse(JSON.stringify(u.value.applyPurchase)), r.value = true;
  }
  function b() {
    u.value.applyPurchase = u.value.originApplyPurchase, r.value = false;
  }
  function V() {
    var se;
    u.value.applyPurchase = JSON.parse(JSON.stringify(u.value.firstApplyPurchase));
    const ce = (se = c.form.selectObj) == null ? void 0 : se[u.value.mergeId];
    ce.isSelected = false, r.value = false;
  }
  function M(ce) {
    const se = !ce.theoryLength;
    c.basicClass & Ge.STEEL_COIL.V ? (Ce([() => ce.weighingTotalWeight, () => ce.width, () => ce.thickness, c.baseUnit], () => h(ce), { immediate: se }), Ce([() => ce.weighingTotalWeight], () => g(ce), { immediate: se }), Ce([() => ce.theoryLength], () => T(ce), { immediate: se })) : (Ce([() => ce.theoryWeight, () => ce.quantity], () => {
      _(ce);
    }, { immediate: se }), Ce([() => ce.mete], () => S(ce), { immediate: se }));
  }
  function g(ce) {
    A(ce.unitPrice) && A(ce.weighingTotalWeight) ? ce.amount = Be(ce.weighingTotalWeight * ce.unitPrice, Ze.YUAN) : ce.amount = void 0;
  }
  function S(ce) {
    A(ce.unitPrice) && A(ce.mete) ? ce.amount = Be(ce.mete * ce.unitPrice, Ze.YUAN) : ce.amount = void 0;
  }
  async function h(ce) {
    ce.theoryLength = await il({ classifyId: ce.classifyId, name: ce.classifyFullName, weight: ce.weighingTotalWeight, width: ce.width, thickness: ce.thickness });
  }
  function T(ce) {
    A(ce.theoryLength) ? ce.length = ce.theoryLength * 1 : ce.length = void 0;
  }
  function _(ce) {
    A(ce.theoryWeight) && ce.quantity ? ce.theoryTotalWeight = Be(ce.theoryWeight * ce.quantity, c.baseUnit.weight.precision) : ce.theoryTotalWeight = 0;
  }
  const f = (ce, se) => (se.measureUnit && A(se.measurePrecision) && A(se.quantity) && (se.quantity = Be(se.quantity, se.measurePrecision)), c.basicClass & va.STEEL.V || se.measureUnit && A(se.measurePrecision) ? !!se.quantity : true), m = (ce, se) => A(ce) ? ce > 0 : true, R = (ce, se) => (se.accountingUnit && A(se.accountingPrecision) && A(se.mete) && (se.mete = Be(se.mete, se.accountingPrecision)), A(se.mete) ? se.mete > 0 : true), N = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (ce, se) => {
    const he = c.basicClass & va.STEEL.V ? se.weighingTotalWeight : se.mete;
    return A(he) && A(se.unitPrice) ? +Be(he * se.unitPrice, Ze.YUAN) == +ce : false;
  }, message: "金额有误，请手动修改", trigger: "blur" }] }, P = { quantity: [{ validator: f, message: "请填写数量", trigger: "blur" }], mete: [{ validator: R, message: "重量必须大于0", trigger: "blur" }] }, L = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { validator: m, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { validator: m, message: "厚度必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { validator: m, message: "长度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写理论重量", trigger: "blur" }, { validator: m, message: "数量必须大于0", trigger: "blur" }] }, O = { workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, x = Ee(() => {
    let ce = Object.assign({}, O);
    const se = c.basicClass & Ge.STEEL_COIL.V ? L : P;
    return ce = Object.assign(se, O), n.value && (ce = Object.assign(ce, N)), ce;
  }), I = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: Y, cleanUpData: ee, wrongCellMask: B } = ui({ rules: x, ditto: I });
  function q() {
    var he, be;
    const ce = [];
    (he = u.value.applyPurchase) == null || he.forEach((me, ge) => {
      me.currentIndex = ge + 1, me.measureUnit && A(me.measurePrecision) && A(me.quantity) && (me.quantity = Be(me.quantity, me.measurePrecision)), me.accountingUnit && A(me.accountingPrecision) && A(me.mete) && (me.mete = Be(me.mete, me.accountingPrecision)), me.accountingUnit && A(me.accountingPrecision) && A(me.weighingTotalWeight) && (me.weighingTotalWeight = Be(me.weighingTotalWeight, me.accountingPrecision)), (me.basicClass === Ge.STEEL_COIL.V && (me.length || A(me.weighingTotalWeight)) || me.basicClass !== Ge.STEEL_COIL.V && (A(me.quantity) || A(me.mete))) && ce.push(me);
    });
    const { validResult: se } = Y(ce);
    if (se) {
      const me = (be = c.form.selectObj) == null ? void 0 : be[u.value.mergeId];
      me.isSelected = true, u.value.applyPurchase.forEach((ge) => {
        Ae(ge.projectId) && (ge.origin_projectId = true);
      }), ee(ce), ce == null || ce.forEach((ge) => {
        const Le = u.value.applyPurchase.findIndex((Ie) => Ie.currentIndex === ge.currentIndex);
        Le > -1 && (u.value.applyPurchase[Le].projectId = ge.projectId, u.value.applyPurchase[Le].workshopId = ge.workshopId, u.value.applyPurchase[Le].warehouseId = ge.warehouseId);
      }), r.value = false;
    }
  }
  function ae(ce, se, he) {
    var Le;
    const be = (Le = c.form.selectObj) == null ? void 0 : Le[u.value.mergeId], me = Ct({ ...he, sn: be == null ? void 0 : be.sn, specificationLabels: be == null ? void 0 : be.specificationLabels, serialNumber: be == null ? void 0 : be.serialNumber, classifyId: be == null ? void 0 : be.classifyId, classifyFullName: be == null ? void 0 : be.classifyFullName, classifyName: be == null ? void 0 : be.classifyName, classifyParentFullName: be == null ? void 0 : be.classifyParentFullName, basicClass: be == null ? void 0 : be.basicClass, specification: be == null ? void 0 : be.specification, specificationMap: be == null ? void 0 : be.specificationMap, measureUnit: be == null ? void 0 : be.measureUnit, accountingUnit: be == null ? void 0 : be.accountingUnit, measurePrecision: be == null ? void 0 : be.measurePrecision, accountingPrecision: be == null ? void 0 : be.accountingPrecision, unitWeight: be == null ? void 0 : be.unitWeight, length: c.basicClass & Ge.STEEL_COIL.V ? null : be == null ? void 0 : be.length, width: be == null ? void 0 : be.width, thickness: be == null ? void 0 : be.thickness, theoryTotalWeight: null, weighingTotalWeight: null, quantity: null, mete: null, originQuantity: null, projectId: ce >= 0 ? -1 : be == null ? void 0 : be.projectId, workshopId: ce >= 0 ? -1 : be == null ? void 0 : be.workshopId, warehouseId: ce >= 0 ? -1 : be == null ? void 0 : be.warehouseId, isBranch: true });
    M(me), se.splice(ce + 1, 0, me);
    const ge = le(ce, se);
    se[ge].spanMerge || (se[ge].spanMerge = 1), se[ge].spanMerge++;
  }
  function j(ce, se, he) {
    if (he.isBranch) {
      const be = le(ce, se);
      se[be].spanMerge--;
    } else se[ce + 1].spanMerge = he.spanMerge - 1, se[ce + 1].isBranch = false;
    if (se.splice(ce, 1), A(se) && se.length > 0) {
      const be = se[0];
      se[0].projectId = be.projectId && be.projectId !== -1 ? be.projectId : void 0, se[0].workshopId = be.workshopId && be.workshopId !== -1 ? be.workshopId : void 0, se[0].warehouseId = be.warehouseId && be.warehouseId !== -1 ? be.warehouseId : void 0;
    }
  }
  function le(ce, se, he) {
    let be = ce;
    for (let me = ce; me >= 0; me--) if (!se[me].isBranch) {
      be = me;
      break;
    }
    return be;
  }
  function oe({ row: ce, column: se, rowIndex: he, columnIndex: be }) {
    if (["serialNumber", "project", "purchaseQuantity", "inboundQuantity"].includes(se.property)) return ce.isBranch ? { rowspan: 1, colspan: 0 } : { rowspan: ce.spanMerge || 1, colspan: 1 };
  }
  function ye(ce) {
    return Hi(ce, { props: [["mete", ei.weight.precision], ["weighingTotalWeight", ei.weight.precision]] });
  }
  return (ce, se) => {
    const he = ya, be = Ve("vxe-column"), me = Ve("common-button"), ge = vt, Le = Mt, Ie = Ve("common-table"), Se = Ve("common-dialog");
    return w(), Q(Qe, null, [s(be, { title: "操作", align: "center", fixed: "right", width: "110px" }, { default: p(({ row: X }) => [C("span", { style: { "margin-left": "5px", cursor: "pointer" }, onClick: ($) => y(X) }, [s(he, { class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle" } })], 8, Hte)]), _: 1 }), s(Se, { modelValue: r.value, "onUpdate:modelValue": se[1] || (se[1] = (X) => r.value = X), "before-close": () => {
      r.value = false;
    }, "close-on-click-modal": false, "show-close": false, title: `${u.value.classifyName}：${u.value.serialNumber}`, "custom-class": "inbound-requisition-dialog", top: "10vh", width: "98%" }, { titleRight: p(() => [s(me, { type: "primary", onClick: q }, { default: p(() => se[2] || (se[2] = [Te("保存")])), _: 1, __: [2] }), s(me, { type: "warning", onClick: V }, { default: p(() => se[3] || (se[3] = [Te("清空还原")])), _: 1, __: [3] }), s(me, { type: "info", onClick: se[0] || (se[0] = (X) => b()) }, { default: p(() => se[4] || (se[4] = [Te("关闭")])), _: 1, __: [4] })]), default: p(() => [s(Ie, { "cell-class-name": l(B), data: u.value.applyPurchase, maxHeight: l(E), "show-empty-symbol": false, "span-method": oe, "summary-method": ye, "return-source-data": "", "show-summary": "", style: { width: "100%" } }, { default: p(() => [s(ge, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), u.value.originBoolApplyPurchase ? (w(), U(ge, { key: 0, "show-overflow-tooltip": true, align: "center", label: "申购单号", "min-width": "140", prop: "applyPurchaseSN" })) : H("", true), xt(ce.$slots, "editColumn", { row: u.value }), n.value ? (w(), U(yd, { key: 1, "weight-attribute": c.basicClass & l(va).STEEL.V ? "weighingTotalWeight" : "mete" }, null, 8, ["weight-attribute"])) : H("", true), s(ge, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: p(({ row: X }) => [s(Le, { modelValue: X.brand, "onUpdate:modelValue": ($) => X.brand = $, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), c.basicClass & l(ct).STEEL.V ? (w(), U(ge, { key: 2, align: "center", label: "炉批号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: p(({ row: X }) => [s(Le, { modelValue: X.heatNoAndBatchNo, "onUpdate:modelValue": ($) => X.heatNoAndBatchNo = $, modelModifiers: { trim: true }, maxlength: "200", placeholder: "炉批号", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : H("", true), s(r2, { list: u.value.applyPurchase, order: e.order }, null, 8, ["list", "order"]), s(u2, { list: u.value.applyPurchase, showWarehouse: "" }, null, 8, ["list"]), s(ge, { align: "center", fixed: "right", label: "操作", width: "100px" }, { default: p(({ row: X, $index: $ }) => [X.isBranch || X.spanMerge > 1 ? (w(), U(me, { key: 0, class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (k) => j($, u.value.applyPurchase, X) }, null, 8, ["onClick"])) : H("", true), s(me, { class: "icon-button", icon: "el-icon-plus", size: "default", type: "success", onClick: (k) => ae($, u.value.applyPurchase, X) }, null, 8, ["onClick"])]), _: 1 })]), _: 3 }, 8, ["cell-class-name", "data", "maxHeight"])]), _: 3 }, 8, ["modelValue", "before-close", "title"])], 64);
  };
} }, qte = Object.freeze(Object.defineProperty({ __proto__: null, default: Td }, Symbol.toStringTag, { value: "Module" }));
const Gte = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Qte = { key: 1 }, Zte = { class: "color-green" }, Jte = { key: 1 }, Xte = { key: 1 }, $te = { key: 1 }, eie = { key: 1 }, tie = { key: 1 }, iie = { key: 1 }, aie = { __name: "steel-coil-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_COIL.V, { handleOverQuantity: u, handleOverMete: r } = Us({ meteField: "weighingTotalWeight" }), E = Z(false), y = Z({ resizable: true }), b = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), { baseUnit: V } = ai(c), { overDiffTip: M, weightOverDiff: g, diffSubmitValidate: S, currentCfg: h } = Va(V), { specSelectMaxHeight: T, specRef: _, drawerRef: f, editRow: m, editList: R, materialSelectVisible: v, handleClickEditSpec: N, handleSpecChange: P } = Qa(), L = (F, G) => n.noDetail ? !!F : true, x = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ validator: L, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ validator: L, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: (F, G) => !!F, message: "重量必须大于0", trigger: "blur" }], length: [{ validator: L, message: "长度必须大于0", trigger: "blur" }], workshopId: [{ validator: L, message: "请选择仓库", trigger: "change" }], warehouseId: [{ validator: L, message: "请选择存储位置", trigger: "change" }] }, Y = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (F, G) => A(G.weighingTotalWeight) && A(G.unitPrice) ? +Be(G.weighingTotalWeight * G.unitPrice, Ze.YUAN) == +F : false, message: "金额有误，请手动修改", trigger: "blur" }] }, ee = Ee(() => {
    let F = Object.assign({}, x);
    return !n.boolPartyA && n.fillableAmount && (F = Object.assign(F, Y)), F;
  }), B = ft("matSpecRef"), q = Z(), { cu: ae, form: j } = Wi(), le = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: oe, cleanUpData: ye, wrongCellMask: ce } = ui({ rules: ee, ditto: le, errorMsg: "请修正【钢卷清单】中标红的信息" }), se = ft("steelDensityCfg");
  function he() {
  }
  function be({ row: F, rowIndex: G }) {
    var ie, ue;
    if ((ue = (ie = ae == null ? void 0 : ae.submitResult) == null ? void 0 : ie.data) != null && ue.includes(F.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function me(F) {
    const G = Ct({ uid: Tt(), sn: F.sn, specificationLabels: F.specificationLabels, classifySerialNumber: F.classify.serialNumber, serialNumber: F.serialNumber, classifyId: F.classify.id, classifyFullName: F.classify.fullName, classifyName: F.classify.name, classifyParentFullName: F.classify.parentFullName, basicClass: F.classify.basicClass, specification: F.spec, model: F.spec, specificationMap: F.specKV, measureUnit: F.classify.measureUnit, accountingUnit: F.classify.accountingUnit, accountingPrecision: F.classify.accountingPrecision, measurePrecision: F.classify.measurePrecision, quantity: void 0, color: void 0, brand: void 0, heatNoAndBatchNo: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0, projectId: j.steelCoilList.length > 0 ? -1 : void 0, workshopId: j.steelCoilList.length > 0 ? -1 : void 0, warehouseId: j.steelCoilList.length > 0 ? -1 : void 0, rowIndex: j.steelCoilList.length, steelDensity: A(F.density) ? F.density : se.value[F.classify.id] });
    return !n.boolPartyA && n.fillableAmount && (G.unitPrice = void 0, G.amount = void 0), ge(G), G;
  }
  function ge(F) {
    Dt(() => {
      var G, ie, ue, ne, te, de;
      F.needFirstCalcTheoryWeight && ((n.boolPartyA || n.noDetail || (ie = (G = j.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected && !F.boolApplyPurchase) && (Le(F), Ie(F)), F.boolApplyPurchase && ((ne = (ue = j.selectObj) == null ? void 0 : ue[F.mergeId]) != null && ne.isSelected) && (F.weighingTotalWeight = (te = F == null ? void 0 : F.applyPurchase) == null ? void 0 : te.reduce((pe, re) => pe + (re.weighingTotalWeight || 0), 0), F.length = (de = F == null ? void 0 : F.applyPurchase) == null ? void 0 : de.reduce((pe, re) => pe + (re.length || 0), 0)), F.needFirstCalcTheoryWeight = false), g(F);
    }), Ce([() => F.boolApplyPurchase, () => F == null ? void 0 : F.applyPurchase], () => {
      var G, ie, ue, ne;
      F.boolApplyPurchase && ((ie = (G = j.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected ? (F.weighingTotalWeight = (ue = F == null ? void 0 : F.applyPurchase) == null ? void 0 : ue.reduce((te, de) => te + (de.weighingTotalWeight || 0), 0), F.length = (ne = F == null ? void 0 : F.applyPurchase) == null ? void 0 : ne.reduce((te, de) => te + (de.length || 0), 0)) : F.weighingTotalWeight = 0);
    }, { deep: true }), Ce(() => F, () => {
      var G, ie, ue;
      if (!n.boolPartyA && !n.noDetail && ((ie = (G = j.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected)) {
        const ne = (ue = j.selectObj[F.mergeId]) == null ? void 0 : ue.isSelected;
        j.selectObj[F.mergeId] = { ...j.selectObj[F.mergeId], ...F, mete: F.weighingTotalWeight, isSelected: ne };
      }
    }, { deep: true }), F.boolApplyPurchase || (Ce([() => F.weighingTotalWeight, () => F.width, () => F.thickness, V], () => Le(F)), Ce([() => F.theoryLength], () => Ie(F))), Ce(() => F.weighingTotalWeight, () => {
      Se(F.weighingTotalWeight, F);
    });
  }
  async function Le(F) {
    F.theoryLength = await il({ classifyId: F.classifyId, name: F.classifyFullName, weight: F.weighingTotalWeight, width: F.width, thickness: F.thickness });
  }
  function Ie(F) {
    A(F.theoryLength) ? F.length = F.theoryLength * 1 : F.length = void 0;
  }
  function Se(F, G) {
    A(G.unitPrice) && A(F) ? G.amount = Be(F * G.unitPrice, Ze.YUAN) : G.amount = void 0;
  }
  function X(F, G, ie) {
    var ue, ne, te, de;
    if ((ne = (ue = ae == null ? void 0 : ae.submitResult) == null ? void 0 : ue.data) != null && ne.includes(ie.classifyId)) {
      const pe = (te = ae == null ? void 0 : ae.submitResult) == null ? void 0 : te.data.findIndex((we) => we === ie.classifyId);
      j.steelCoilList.filter((we) => we.classifyId === ie.classifyId).length === 1 && ((de = ae == null ? void 0 : ae.submitResult) == null || de.data.splice(pe, 1));
    }
    if (B.value ? B.value.delListItem(F, G) : j.steelCoilList.splice(G, 1), A(j.steelCoilList) && j.steelCoilList.length > 0) {
      const pe = j.steelCoilList[0];
      j.steelCoilList[0].projectId = pe.projectId && pe.projectId !== -1 ? pe.projectId : void 0, j.steelCoilList[0].workshopId = pe.workshopId && pe.workshopId !== -1 ? pe.workshopId : void 0, j.steelCoilList[0].warehouseId = pe.warehouseId && pe.warehouseId !== -1 ? pe.warehouseId : void 0;
    }
  }
  function $(F, G) {
    var ne;
    const ie = JSON.parse(JSON.stringify(F)), ue = Ct({ uid: Tt(), sn: ie.sn, specificationLabels: ie.specificationLabels, classifySerialNumber: ie.classifySerialNumber, serialNumber: ie.serialNumber, classifyId: ie.classifyId, classifyFullName: ie.classifyFullName, classifyName: ie.classifyName, classifyParentFullName: ie.classifyParentFullName, basicClass: ie.basicClass, specification: ie.specification, model: ie.model, specificationMap: ie.specificationMap, measureUnit: ie.measureUnit, accountingUnit: ie.accountingUnit, accountingPrecision: ie.accountingPrecision, measurePrecision: ie.measurePrecision, quantity: ie.quantity, color: ie.color, brand: ie.brand, heatNoAndBatchNo: ie.heatNoAndBatchNo, thickness: ie.thickness, length: ie.length, width: ie.width, theoryLength: ie.theoryLength, weighingTotalWeight: ie.weighingTotalWeight, projectId: ie.projectId, workshopId: ie.workshopId, warehouseId: ie.warehouseId, rowIndex: j.steelCoilList.length, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : ie.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : ie.amount, steelDensity: A(ie.steelDensity) ? ie.steelDensity : se.value[ie.classifyId] });
    j.steelCoilList.push(ue), ge(ue), (ne = B.value) == null || ne.initSelected([ue]);
  }
  function k() {
    console.log(j.steelCoilList, "form.steelCoilList");
    const F = j.steelCoilList.filter((ie, ue) => {
      var ne;
      return ie.dataIndex = ue, !!(n.boolPartyA || n.noDetail || (ne = j.selectObj[ie.mergeId]) != null && ne.isSelected);
    });
    if (Ae(F)) return true;
    const { validResult: G } = oe(F);
    return G && (ye(F), F.forEach((ie) => {
      var ue, ne;
      j.steelCoilList[ie.dataIndex].projectId = ie.projectId, j.steelCoilList[ie.dataIndex].workshopId = ie.workshopId || ((ue = ie.workshop) == null ? void 0 : ue.id), j.steelCoilList[ie.dataIndex].warehouseId = ie.warehouseId || ((ne = ie.warehouse) == null ? void 0 : ne.id);
    })), G;
  }
  function J(F, G) {
  }
  Ce(() => j.steelCoilList, (F) => {
    n.noDetail && q.value && q.value.updateFooter();
  }, { deep: true, immediate: true });
  function z(F) {
    var G;
    return [(G = F.columns) == null ? void 0 : G.map((ie, ue) => {
      if (ue === 0) return "合计";
      if (ie.property === "weighingTotalWeight") {
        const ne = F.data.reduce((te, de) => te + (Number(de.weighingTotalWeight) || 0), 0);
        return ne == null ? void 0 : ne.toFixed(V.value.weight.precision);
      }
      if (ie.property === "amount") {
        const ne = F.data.reduce((te, de) => te + (Number(de.amount) || 0), 0);
        return Mi(ne || 0);
      }
      return null;
    })];
  }
  return o({ rowInit: me, rowWatch: ge, toggleRowSelection: J, validate: k, setSelect: he }), (F, G) => {
    const ie = Mt, ue = Ve("vxe-column"), ne = Ve("vxe-tooltip"), te = ya, de = Ve("common-input-number"), pe = vt, re = jt, we = Ve("common-button"), Ke = Ve("vxe-table"), Me = Ve("common-drawer"), Ne = _t("empty-text"), He = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(Ke, { key: `inbound_${l(c)}`, ref_key: "tableRef", ref: q, "cell-class-name": l(ce), columnConfig: y.value, data: l(j).steelCoilList, "empty-text": "暂无数据", "footer-method": z, "max-height": e.maxHeight, "row-style": be, "scroll-y": b.value, border: "", class: "myTable-style", "show-footer": "", "show-overflow": "tooltip" }, { default: p(() => [s(ue, { type: "expand", width: "60" }, { content: p(({ row: ze }) => [s(ie, { modelValue: ze.remark, "onUpdate:modelValue": (Oe) => ze.remark = Oe, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(ze.inboundList) ? (w(), Q("div", Gte, [s(l(al), { "basic-class": l(c), list: ze.inboundList, material: ze, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)]), _: 1 }), s(ue, { title: "序号", type: "seq", width: "55" }), s(ue, { align: "center", field: "serialNumber", title: "编号", width: "100" }), s(ue, { align: "center", field: "classifyName", "min-width": "120", title: "物料种类" }, { default: p(({ row: ze }) => [s(ne, { content: ze.classifyParentFullName, disabled: !ze.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[Ne, ze.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ue, { align: "center", field: "specification", "min-width": "100px", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: ze }) => {
      var Oe, Re, fe;
      return [(Re = (Oe = l(j).selectObj) == null ? void 0 : Oe[ze.mergeId]) != null && Re.isSelected && ((fe = l(h)) == null ? void 0 : fe.spec) & l(c) && !ze.boolApplyPurchase ? (w(), U(te, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Ue) => l(N)(ze) }, null, 8, ["onClick"])) : H("", true), s(ne, { content: ze.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(ze.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), n.boolPartyA || n.noDetail ? (w(), U(ue, { key: "weighingTotalWeight", title: `总重 (${l(V).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "135px" }, { default: p(({ row: ze }) => [s(de, { modelValue: ze.weighingTotalWeight, "onUpdate:modelValue": (Oe) => ze.weighingTotalWeight = Oe, controls: false, max: 999999999, min: 0, precision: l(V).weight.precision, "controls-position": "right", placeholder: "重量", size: "default", style: { width: "100%" }, onChange: (Oe) => Se(Oe, ze) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }, 8, ["title"])) : (w(), Q(Qe, { key: 1 }, [s(ue, { title: "关联项目", align: "right", field: "projects", "min-width": "100px" }, { default: p(({ row: ze }) => [l(A)(ze.projects) ? (w(true), Q(Qe, { key: 0 }, ki(ze.projects, (Oe, Re) => {
      var fe;
      return w(), Q("span", { key: Re }, K(l(di)(Oe)) + " " + K(Re + 1 === ((fe = ze.projects) == null ? void 0 : fe.length) ? "" : "、"), 1);
    }), 128)) : (w(), Q("span", Qte, "-"))]), _: 1 }), s(ue, { title: `采购重量 (${l(V).weight.unit})`, align: "right", field: "purchaseMete", "min-width": "110px" }, { default: p(({ row: ze }) => [C("span", null, [s(ne, { content: "已入库量", placement: "top" }, { default: p(() => [C("span", Zte, K(ze.inboundMete), 1)]), _: 2 }, 1024), Te(" / " + K(ze.purchaseMete), 1)])]), _: 1 }, 8, ["title"]), s(ue, { key: "weighingTotalWeight", title: `实收量 (${l(V).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "150px" }, { default: p(({ row: ze }) => [C("span", null, K(ze.weighingTotalWeight ? ze.weighingTotalWeight.toFixed(l(V).weight.precision) : "-"), 1)]), _: 1 }, 8, ["title"])], 64)), s(ue, { title: `厚 (${l(V).thickness.unit})`, align: "center", field: "thickness", "min-width": "100px" }, { default: p(({ row: ze }) => [n.boolPartyA || n.noDetail ? (w(), U(de, { key: 0, modelValue: ze.thickness, "onUpdate:modelValue": (Oe) => ze.thickness = Oe, controls: false, max: 99999999, min: 0, precision: l(V).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Jte, K(ze.thickness), 1))]), _: 1 }, 8, ["title"]), s(ue, { title: `宽 (${l(V).width.unit})`, align: "center", field: "width", "min-width": "135px" }, { default: p(({ row: ze }) => [n.boolPartyA || n.noDetail ? (w(), U(de, { key: 0, modelValue: ze.width, "onUpdate:modelValue": (Oe) => ze.width = Oe, controls: false, max: 99999999, min: 0, precision: l(V).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Xte, K(ze.width), 1))]), _: 1 }, 8, ["title"]), s(ue, { title: `长 (${l(V).length.unit})`, align: "center", field: "length", "min-width": "135px" }, { default: p(({ row: ze }) => [n.boolPartyA || n.noDetail ? (w(), U(de, { key: 0, modelValue: ze.length, "onUpdate:modelValue": (Oe) => ze.length = Oe, controls: false, max: 999999999, min: 0, precision: l(V).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", $te, K(ze.length), 1))]), _: 1 }, 8, ["title"]), s(ue, { align: "center", field: "color", "min-width": "140px", title: "颜色" }, { default: p(({ row: ze }) => [n.boolPartyA || n.noDetail ? (w(), U(ie, { key: 0, modelValue: ze.color, "onUpdate:modelValue": (Oe) => ze.color = Oe, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", eie, [Te(K(ze.color), 1)])), [[Ne]])]), _: 1 }), !n.boolPartyA && e.fillableAmount && e.noDetail ? (w(), U(qo, { key: 2 })) : H("", true), s(ue, { align: "center", field: "brand", "min-width": "100px", title: "品牌" }, { default: p(({ row: ze }) => [n.boolPartyA || n.noDetail ? (w(), U(ie, { key: 0, modelValue: ze.brand, "onUpdate:modelValue": (Oe) => ze.brand = Oe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", tie, [Te(K(ze.brand), 1)])), [[Ne]])]), _: 1 }), n.boolPartyA || n.noDetail ? (w(), U(ue, { key: 3, align: "center", field: "heatNoAndBatchNo", "min-width": "150px", title: "卷号" }, { default: p(({ row: ze }) => [n.boolPartyA || n.noDetail ? (w(), U(ie, { key: 0, modelValue: ze.heatNoAndBatchNo, "onUpdate:modelValue": (Oe) => ze.heatNoAndBatchNo = Oe, modelModifiers: { trim: true }, maxlength: "200", placeholder: "卷号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", iie, [Te(K(ze.heatNoAndBatchNo), 1)])), [[Ne]])]), _: 1 })) : H("", true), !n.boolPartyA && !n.noDetail ? (w(), U(l(Td), { key: 4, "base-unit": l(V), "basic-class": l(c), "current-cfg": l(h), form: l(j), handleOverQuantity: l(u), list: l(j).steelCoilList, order: e.order }, { editColumn: p(({ row: ze }) => [s(pe, { key: "weighingTotalWeight", label: `实收量 (${l(V).weight.unit})`, align: "center", "min-width": "135px", prop: "weighingTotalWeight" }, { default: p(({ row: Oe }) => [s(de, { modelValue: Oe.weighingTotalWeight, "onUpdate:modelValue": (Re) => Oe.weighingTotalWeight = Re, class: Zt({ "over-weight-tip": ze.hasOver }), controls: false, max: 999999999, min: 0, precision: l(V).weight.precision, "controls-position": "right", placeholder: "实收量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["label"]), s(pe, { align: "center", label: "规格", "min-width": "200px", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: Oe }) => [s(re, { content: Oe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Oe.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(pe, { label: `厚 (${l(V).thickness.unit})`, align: "center", "min-width": "100px", prop: "thickness", sortable: "" }, { default: p(({ row: Oe }) => [s(de, { modelValue: Oe.thickness, "onUpdate:modelValue": (Re) => Oe.thickness = Re, controls: false, max: 99999999, min: 0, precision: l(V).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(pe, { label: `宽 (${l(V).width.unit})`, align: "center", "min-width": "135px", prop: "width" }, { default: p(({ row: Oe }) => [s(de, { modelValue: Oe.width, "onUpdate:modelValue": (Re) => Oe.width = Re, controls: false, max: 99999999, min: 0, precision: l(V).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(pe, { label: `长 (${l(V).length.unit})`, align: "center", "min-width": "135px", prop: "length" }, { default: p(({ row: Oe }) => [s(de, { modelValue: Oe.length, "onUpdate:modelValue": (Re) => Oe.length = Re, controls: false, max: 999999999, min: 0, precision: l(V).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["label"]), s(pe, { align: "center", label: "颜色", "min-width": "140px", prop: "color" }, { default: p(({ row: Oe }) => [s(ie, { modelValue: Oe.color, "onUpdate:modelValue": (Re) => Oe.color = Re, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })]), _: 1 }, 8, ["base-unit", "basic-class", "current-cfg", "form", "handleOverQuantity", "list", "order"])) : H("", true), !n.boolPartyA && e.noDetail ? (w(), Q(Qe, { key: 5 }, [s(go, { list: l(j).steelCoilList, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: l(j).steelCoilList, showWarehouse: "" }, null, 8, ["list"])], 64)) : H("", true), n.boolPartyA || n.noDetail ? (w(), U(ue, { key: 6, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: ze, rowIndex: Oe }) => [s(we, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Re) => $(ze, Oe) }, null, 8, ["onClick"]), s(we, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Re) => X(ze.sn, Oe) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "columnConfig", "data", "max-height", "scroll-y"]))])), [[He, E.value]]), s(Me, { ref_key: "drawerRef", ref: f, modelValue: l(v), "onUpdate:modelValue": G[1] || (G[1] = (ze) => Gt(v) ? v.value = ze : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢卷规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: _, modelValue: l(R), "onUpdate:modelValue": G[0] || (G[0] = (ze) => Gt(R) ? R.value = ze : null), classifyId: l(m).classifyId, "max-height": l(T), "show-classify": false, visible: l(v), "expand-query": "", mode: "selector", onChange: l(P) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, G3 = ut(aie, [["__scopeId", "data-v-44bf8fb6"]]), lie = Object.freeze(Object.defineProperty({ __proto__: null, default: G3 }, Symbol.toStringTag, { value: "Module" }));
const oie = { style: { overflow: "hidden" } }, nie = { style: {} }, sie = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, rie = { key: 1 }, uie = { key: 1 }, cie = { key: 1 }, die = { key: 1 }, mie = { key: 1 }, pie = { key: 1 }, hie = { key: 1 }, fie = { key: 1 }, gie = { key: 1 }, Eie = { __name: "steel-coil-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_COIL.V, u = ft("matSpecRef"), { priceAbnormal: r } = aa(), { baseUnit: E } = ai(c), { cu: y, form: b } = Wi(), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g, currentCfg: S } = Va(E), h = Z(false), T = Z(null), _ = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const f = Z({ enabled: true, gt: 50, oSize: 5, scrollToTopOnChange: true, immediate: true }), m = Z([{ seq: "合计", quantity: "-", mete: "-", amountExcludingVatFreight: "-", amount: "-", weighingTotalWeight: "-" }]);
  Ce(() => b.steelCoilList, (z) => {
    R();
  }, { deep: true, immediate: true });
  function R() {
    var ne;
    let z = 0, F = 0, G = 0, ie = 0, ue = 0;
    (ne = b.steelCoilList) == null || ne.forEach((te) => {
      z += Number(te.length) || 0, F += Number(te.mete) || 0, G += Number(te.amount) || 0, ie += Number(te.amountExcludingVatFreight) || 0, ue += Number(te.weighingTotalWeight) || 0;
    }), F = F.toFixed(2), ue = ue.toFixed(2), G = G.toFixed(Ze.YUAN), ie = ie.toFixed(Ze.YUAN), m.value = [{ seq: "合计", length: z, mete: F, amountExcludingVatFreight: ie, amount: G, weighingTotalWeight: ue }];
  }
  const v = ft("steelDensityCfg"), { specSelectMaxHeight: N, specRef: P, drawerRef: L, editRow: O, editList: x, materialSelectVisible: I, handleClickEditSpec: Y, handleSpecChange: ee } = Qa(), B = /^(?!(0[0-9]{1,}$))[0-9]*[.]{0,}[0-9]{0,}$/, q = (z, F) => !!z, ae = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], thickness: [{ required: true, message: "厚度必填", trigger: "blur" }, { validator: q, message: "厚度必须大于0", trigger: "blur" }], width: [{ required: true, message: "宽度必填", trigger: "blur" }, { validator: q, message: "宽度必须大于0", trigger: "blur" }], length: [{ required: true, message: "长度必填", trigger: "blur" }, { validator: q, message: "长度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: g, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: B, message: "重量必须大于0", trigger: "blur" }], amount: [{ required: true, message: "请输入含税金额", trigger: "change" }, { pattern: B, message: "含税金额必须大于0", trigger: "blur" }], amountExcludingVatFreight: [{ required: true, message: "请输入不含税金额", trigger: "change" }, { pattern: B, message: "不含税金额必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, j = Ee(() => {
    let z = Object.assign({}, ae);
    return !n.boolPartyA && n.fillableAmount && (z = Object.assign(z, {})), z;
  }), le = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: oe, cleanUpData: ye, wrongCellMask: ce } = ui({ rules: j, ditto: le, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function se() {
  }
  function he({ row: z, rowIndex: F }) {
    var G, ie;
    if ((ie = (G = y == null ? void 0 : y.submitResult) == null ? void 0 : G.data) != null && ie.includes(z.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function be(z) {
    const F = Ct({ uid: Tt(), sn: z.sn, specificationLabels: z.specificationLabels, classifySerialNumber: z.classify.serialNumber, serialNumber: z.serialNumber, classifyId: z.classify.id, classifyFullName: z.classify.fullName, classifyName: z.classify.name, classifyParentFullName: z.classify.parentFullName, basicClass: z.classify.basicClass, specification: z.spec, model: z.spec, specificationMap: z.specKV, measureUnit: z.classify.measureUnit, accountingUnit: z.classify.accountingUnit, accountingPrecision: z.classify.accountingPrecision, measurePrecision: z.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, steelDensity: A(z.density) ? z.density : v.value[z.classify.id] });
    return !n.boolPartyA && n.fillableAmount && (F.unitPrice = void 0, F.amount = void 0), me(F), F;
  }
  function me(z) {
    Dt(() => {
      var F, G, ie, ue, ne, te;
      z.needFirstCalcTheoryWeight && ((n.boolPartyA || n.noDetail || (G = (F = b.selectObj) == null ? void 0 : F[z.mergeId]) != null && G.isSelected && !z.boolApplyPurchase) && (Le(z), Ie(z)), z.boolApplyPurchase && ((ue = (ie = b.selectObj) == null ? void 0 : ie[z.mergeId]) != null && ue.isSelected) && (z.weighingTotalWeight = (ne = z == null ? void 0 : z.applyPurchase) == null ? void 0 : ne.reduce((de, pe) => de + (pe.weighingTotalWeight || 0), 0), z.length = (te = z == null ? void 0 : z.applyPurchase) == null ? void 0 : te.reduce((de, pe) => de + (pe.length || 0), 0)), z.needFirstCalcTheoryWeight = false), M(z);
    }), Ce([() => z.boolApplyPurchase, () => z == null ? void 0 : z.applyPurchase], () => {
      var F, G, ie, ue;
      z.boolApplyPurchase && ((G = (F = b.selectObj) == null ? void 0 : F[z.mergeId]) != null && G.isSelected ? (z.weighingTotalWeight = (ie = z == null ? void 0 : z.applyPurchase) == null ? void 0 : ie.reduce((ne, te) => ne + (te.weighingTotalWeight || 0), 0), z.length = (ue = z == null ? void 0 : z.applyPurchase) == null ? void 0 : ue.reduce((ne, te) => ne + (te.length || 0), 0)) : z.weighingTotalWeight = 0);
    }, { deep: true }), Ce(() => z, () => {
      var F, G, ie;
      if (!n.boolPartyA && !n.noDetail && ((G = (F = b.selectObj) == null ? void 0 : F[z.mergeId]) != null && G.isSelected)) {
        const ue = (ie = b.selectObj[z.mergeId]) == null ? void 0 : ie.isSelected;
        b.selectObj[z.mergeId] = { ...b.selectObj[z.mergeId], ...z, mete: z.weighingTotalWeight, isSelected: ue };
      }
    }, { deep: true }), z.boolApplyPurchase || (Ce([() => z.weighingTotalWeight, () => z.width, () => z.thickness, E], () => Le(z)), Ce([() => z.theoryLength], () => Ie(z))), Ce(() => z.weighingTotalWeight, () => {
      Se(z.weighingTotalWeight, z);
    });
  }
  function ge(z, F) {
    Ie(F);
  }
  async function Le(z) {
    z.theoryLength = await il({ name: z.classifyFullName, weight: z.weighingTotalWeight, width: z.width, thickness: z.thickness, classifyId: z.classifyId });
  }
  function Ie(z) {
    A(z.theoryLength) ? z.length = z.theoryLength * 1 : z.length = void 0;
  }
  function Se(z, F) {
    A(F.unitPrice) && A(z) ? F.amount = Be(z * F.unitPrice, Ze.YUAN) : (F.amount = void 0, F.amountExcludingVatFreight = void 0);
  }
  function X(z, F, G) {
    var ie, ue, ne, te;
    if ((ue = (ie = y == null ? void 0 : y.submitResult) == null ? void 0 : ie.data) != null && ue.includes(G.classifyId)) {
      const de = (ne = y == null ? void 0 : y.submitResult) == null ? void 0 : ne.data.findIndex((re) => re === G.classifyId);
      b.steelCoilList.filter((re) => re.classifyId === G.classifyId).length === 1 && ((te = y == null ? void 0 : y.submitResult) == null || te.data.splice(de, 1));
    }
    if (u.value ? u.value.delListItem(z, F) : b.steelCoilList.splice(F, 1), A(b.steelCoilList) && b.steelCoilList.length > 0) {
      const de = b.steelCoilList[0];
      b.steelCoilList[0].projectId = de.projectId && de.projectId !== -1 ? de.projectId : void 0, b.steelCoilList[0].workshopId = de.workshopId && de.workshopId !== -1 ? de.workshopId : void 0, b.steelCoilList[0].warehouseId = de.warehouseId && de.warehouseId !== -1 ? de.warehouseId : void 0;
    }
  }
  function $(z, F) {
    var ue;
    const G = JSON.parse(JSON.stringify(z)), ie = Ct({ uid: Tt(), sn: G.sn, specificationLabels: G.specificationLabels, classifySerialNumber: G.classifySerialNumber, serialNumber: G.serialNumber, classifyId: G.classifyId, classifyFullName: G.classifyFullName, classifyName: G.classifyName, classifyParentFullName: G.classifyParentFullName, basicClass: G.basicClass, specification: G.specification, model: G.spec, specificationMap: G.specificationMap, measureUnit: G.measureUnit, accountingUnit: G.accountingUnit, accountingPrecision: G.accountingPrecision, measurePrecision: G.measurePrecision, quantity: G.quantity, thickness: G.thickness, length: G.length, width: G.width, theoryWeight: G.theoryWeight, theoryTotalWeight: G.theoryTotalWeight, weighingTotalWeight: G.weighingTotalWeight, rowIndex: b.steelCoilList.length, weightMeasurementMode: G.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : G.unitPrice, color: G.color, brand: G.brand, heatNoAndBatchNo: G.heatNoAndBatchNo, amount: G.amount, amountExcludingVatFreight: G.amountExcludingVatFreight, projectSerialNumber: G.projectSerialNumber, projectId: G.projectId, workshopName: G.workshopName, warehouseName: G.warehouseName, workshopId: G.workshopId, warehouseId: G.warehouseId, steelDensity: A(G.steelDensity) ? G.steelDensity : v.value[G.classifyId] });
    b.steelCoilList.push(ie), me(ie), (ue = u.value) == null || ue.initSelected([ie]);
  }
  async function k() {
    const z = At(b.steelCoilList), { validResult: F } = oe(b.steelCoilList);
    if (F) {
      let G = true;
      const ie = [];
      if (A(r.value) && r.value.forEach((ue) => {
        var te;
        const ne = (te = b.originList) == null ? void 0 : te.filter((de) => de.basicClass === ue.basicClass);
        A(ne) && ne.forEach((de) => {
          ue.minPrice && de.amount < ue.minPrice * de.weighingTotalWeight && ie.push({ msg: `${Pe.VL[de.basicClass]} ${de.serialNumber} ${de.classifyName}：含税金额${de.amount} < 异常配置最小值${ue.minPrice}*总重` }), ue.maxPrice && de.amount > ue.maxPrice * de.weighingTotalWeight && ie.push({ msg: `${Pe.VL[de.basicClass]} ${de.serialNumber} ${de.classifyName}：含税金额${de.amount} > 异常配置最大值${ue.maxPrice}*总重` });
        });
      }), A(ie)) {
        const ue = ie.map((ne) => `<div>${ne.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + ue, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          G = true;
        }).catch((ne) => {
          G = false;
        });
      }
      if (!G) return false;
    }
    if (F) ye(z), z.forEach((G) => {
    });
    else {
      const G = b.steelCoilList.find((ie) => ie.verify ? Object.values(ie.verify).some((ue) => ue === false) : false);
      G && T.value && pt(() => {
        T.value.scrollToRow(G);
      });
    }
    return F;
  }
  function J(z, F) {
  }
  return o({ rowInit: be, rowWatch: me, toggleRowSelection: J, validate: k, setSelect: se }), (z, F) => {
    const G = Mt, ie = Ve("vxe-column"), ue = Ve("vxe-tooltip"), ne = ya, te = Ve("common-input-number"), de = Ve("common-button"), pe = Ve("vxe-table"), re = Ve("common-drawer"), we = _t("empty-text"), Ke = oi;
    return w(), Q("div", null, [qe((w(), Q("div", oie, [(w(), U(pe, { ref_key: "tableRef", ref: T, key: `inbound_${l(c)}`, "cell-class-name": l(ce), "column-config": _.value, data: l(b).steelCoilList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": he, "scroll-y": f.value, border: "", class: "myTable-style", "footer-data": m.value, "show-footer": "", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(ie, { type: "expand", width: "60" }, { content: p(({ row: Me }) => [C("div", nie, [s(G, { modelValue: Me.remark, "onUpdate:modelValue": (Ne) => Me.remark = Ne, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(Me.inboundList) ? (w(), Q("div", sie, [s(l(al), { "basic-class": l(c), list: Me.inboundList, material: Me, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(ie, { title: "序号", type: "seq", width: "55" }), s(ie, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: Me }) => [s(ue, { content: Me.classifyParentFullName, disabled: !Me.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[we, Me.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ie, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: Me }) => {
      var Ne, He, ze;
      return [(He = (Ne = l(b).selectObj) == null ? void 0 : Ne[Me.mergeId]) != null && He.isSelected && ((ze = l(S)) == null ? void 0 : ze.spec) & l(c) && !Me.boolApplyPurchase ? (w(), U(ne, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Oe) => l(Y)(Me) }, null, 8, ["onClick"])) : H("", true), s(ue, { content: Me.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Me.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(ie, { title: `厚 (${l(E).thickness.unit})`, align: "center", field: "thickness", "min-width": "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: Me.thickness, "onUpdate:modelValue": (Ne) => Me.thickness = Ne, controls: false, max: 99999999, min: 0, precision: l(E).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" }, onBlur: (Ne) => ge(Ne, Me) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", rie, K(Me.thickness), 1))]), _: 1 }, 8, ["title"]), s(ie, { title: `宽 (${l(E).width.unit})`, align: "center", field: "width", "min-width": "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: Me.width, "onUpdate:modelValue": (Ne) => Me.width = Ne, controls: false, max: 99999999, min: 0, precision: l(E).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" }, onBlur: (Ne) => ge(Ne, Me) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", uie, K(Me.width), 1))]), _: 1 }, 8, ["title"]), s(ie, { title: `总重 (${l(E).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: Me.weighingTotalWeight, "onUpdate:modelValue": (Ne) => Me.weighingTotalWeight = Ne, controls: false, max: 999999999, min: 0, precision: l(E).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" }, onBlur: (Ne) => ge(Ne, Me) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", cie, K(Me.weighingTotalWeight), 1))]), _: 1 }, 8, ["title"]), s(ie, { title: `长度 (${l(E).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: Me.length, "onUpdate:modelValue": (Ne) => Me.length = Ne, controls: false, max: 999999999, min: 0, precision: l(E).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", die, K(Me.length), 1))]), _: 1 }, 8, ["title"]), s(ie, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: Me.color, "onUpdate:modelValue": (Ne) => Me.color = Ne, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", mie, K(Me.color), 1))]), _: 1 }), s(ie, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: Me.brand, "onUpdate:modelValue": (Ne) => Me.brand = Ne, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", pie, K(Me.brand), 1))]), _: 1 }), s(ie, { align: "center", field: "heatNoAndBatchNo", title: "卷号", width: "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: Me.heatNoAndBatchNo, "onUpdate:modelValue": (Ne) => Me.heatNoAndBatchNo = Ne, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", hie, K(Me.heatNoAndBatchNo), 1))]), _: 1 }), s(ie, { align: "center", field: "amount", title: "含税金额", width: "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: Me.amount, "onUpdate:modelValue": (Ne) => Me.amount = Ne, controls: false, min: 0, precision: 2, placeholder: "含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", fie, K(Me.amount), 1))]), _: 1 }), s(ie, { align: "center", field: "amountExcludingVatFreight", title: "不含税金额", width: "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: Me.amountExcludingVatFreight, "onUpdate:modelValue": (Ne) => Me.amountExcludingVatFreight = Ne, controls: false, min: 0, precision: 2, placeholder: "不含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", gie, K(Me.amountExcludingVatFreight), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(b).steelCoilList }, null, 8, ["list"])) : (w(), U(ie, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: Me }) => [C("span", null, K(Me.projectFullName || Me.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(b).steelCoilList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(ie, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: Me }) => [C("span", null, K(Me.workshopName), 1)]), _: 1 }), s(ie, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: Me }) => [C("span", null, K(Me.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(ie, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: Me, rowIndex: Ne }) => [s(de, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (He) => $(Me, Ne) }, null, 8, ["onClick"]), s(de, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (He) => X(Me.sn, Ne, Me) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[Ke, h.value]]), s(re, { ref_key: "drawerRef", ref: L, modelValue: l(I), "onUpdate:modelValue": F[1] || (F[1] = (Me) => Gt(I) ? I.value = Me : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: P, modelValue: l(x), "onUpdate:modelValue": F[0] || (F[0] = (Me) => Gt(x) ? x.value = Me : null), classifyId: l(O).classifyId, "max-height": l(N), "show-classify": false, visible: l(I), "expand-query": "", mode: "selector", onChange: l(ee) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Q3 = ut(Eie, [["__scopeId", "data-v-182f4f76"]]), yie = Object.freeze(Object.defineProperty({ __proto__: null, default: Q3 }, Symbol.toStringTag, { value: "Module" }));
const Tie = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, _ie = { key: 1 }, bie = { key: 1 }, Vie = { key: 0 }, wie = { class: "color-green" }, Sie = { class: "color-green" }, vie = { key: 1 }, Rie = { key: 1 }, Mie = { key: 1 }, Aie = { __name: "other-steel-material-table", props: { boolPartyA: { type: Boolean, default: false }, boolApplyPurchase: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, basicClass: { type: [String, Number], default: Pe.OTHER_STEEL_MATERIALS.V }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 } }, setup(e, { expose: o }) {
  const n = e, { baseUnit: c } = ai(n.basicClass), { purchaseCfg: u } = aa(), r = ft("matSpecRef"), { cu: E, form: y } = Wi(), b = Z(), V = Z(false), M = Z({ resizable: true }), g = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), S = (he, be) => (be.measureUnit && A(be.measurePrecision) && A(be.quantity) && (be.quantity = Be(be.quantity, be.measurePrecision)), be.measureUnit && A(be.measurePrecision) ? !!be.quantity : true), h = (he, be) => n.noDetail ? !!he : true, _ = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: S, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (he, be) => (be.accountingUnit && A(be.accountingPrecision) && A(be.mete) && (be.mete = Be(be.mete, be.accountingPrecision)), !!be.mete), message: "核算量必须大于0", trigger: "blur" }], workshopId: [{ validator: h, message: "请选择仓库", trigger: "change" }], warehouseId: [{ validator: h, message: "请选择存储位置", trigger: "change" }] }, m = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (he, be) => A(be.mete) && A(be.unitPrice) ? +Be(be.mete * be.unitPrice, Ze.YUAN) == +he : false, message: "金额有误，请手动修改", trigger: "blur" }] }, R = Ee(() => {
    let he = Object.assign({}, _);
    return !n.boolPartyA && n.fillableAmount && (he = Object.assign(he, m)), he;
  }), v = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: N, cleanUpData: P, wrongCellMask: L } = ui({ rules: R, ditto: v, errorMsg: "请修正【其它钢材清单】中标红的信息" }), { handleOverQuantity: O, handleOverMete: x } = Us({ meteField: "mete" });
  function I(he = false) {
  }
  function Y({ row: he, rowIndex: be }) {
    var me, ge;
    if ((ge = (me = E == null ? void 0 : E.submitResult) == null ? void 0 : me.data) != null && ge.includes(he.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ee(he) {
    const be = Ct({ uid: Tt(), sn: he.sn, specificationLabels: he.specificationLabels, classifySerialNumber: he.classify.serialNumber, serialNumber: he.serialNumber, classifyId: he.classify.id, classifyFullPathId: he.classify.fullPathId, classifyFullName: he.classify.fullName, classifyName: he.classify.name, classifyParentFullName: he.classify.parentFullName, basicClass: he.classify.basicClass, specification: he.spec, model: he.spec, specificationMap: he.specKV, measureUnit: he.classify.measureUnit, accountingUnit: he.classify.accountingUnit, accountingPrecision: he.classify.accountingPrecision, measurePrecision: he.classify.measurePrecision, outboundUnitType: he.classify.outboundUnitType, unitNet: he.unitNet, accountingUnitNet: he.accountingUnitNet, mete: void 0, quantity: void 0, projectId: y.otherSteelMaterialList.length > 0 ? -1 : void 0, workshopId: y.otherSteelMaterialList.length > 0 ? -1 : void 0, warehouseId: y.otherSteelMaterialList.length > 0 ? -1 : void 0, rowIndex: y.otherSteelMaterialList.length });
    return !n.boolPartyA && n.fillableAmount && (be.unitPrice = void 0, be.amount = void 0), be;
  }
  function B(he) {
    Ce([() => he.boolApplyPurchase, () => he == null ? void 0 : he.applyPurchase], () => {
      var be, me;
      he.boolApplyPurchase && (he.quantity = ((be = he == null ? void 0 : he.applyPurchase) == null ? void 0 : be.reduce((ge, Le) => ge + (Le.quantity || 0), 0)) || 0, he.mete = ((me = he == null ? void 0 : he.applyPurchase) == null ? void 0 : me.reduce((ge, Le) => ge + (Le.mete || 0), 0)) || 0);
    }, { deep: true }), Ce(() => he, () => {
      var be, me, ge;
      if (!n.boolPartyA && !n.noDetail && ((me = (be = y.selectObj) == null ? void 0 : be[he.mergeId]) != null && me.isSelected)) {
        const Le = (ge = y.selectObj[he.mergeId]) == null ? void 0 : ge.isSelected;
        y.selectObj[he.mergeId] = { ...y.selectObj[he.mergeId], ...he, isSelected: Le };
      }
    }, { deep: true }), Ce(() => he.mete, () => {
      q(he.mete, he);
    });
  }
  function q(he, be, me) {
    A(be.unitPrice) && A(he) ? be.amount = Be(he * be.unitPrice, Ze.YUAN) : be.amount = void 0, oe(be, me || be);
  }
  function ae(he, be, me) {
    var ge, Le, Ie, Se;
    if ((Le = (ge = E == null ? void 0 : E.submitResult) == null ? void 0 : ge.data) != null && Le.includes(me.classifyId)) {
      const X = (Ie = E == null ? void 0 : E.submitResult) == null ? void 0 : Ie.data.findIndex((k) => k === me.classifyId);
      y.otherSteelMaterialList.filter((k) => k.classifyId === me.classifyId).length === 1 && ((Se = E == null ? void 0 : E.submitResult) == null || Se.data.splice(X, 1));
    }
    if (r.value ? r.value.delListItem(he, be) : y.otherSteelMaterialList.splice(be, 1), A(y.otherSteelMaterialList) && y.otherSteelMaterialList.length > 0) {
      const X = y.otherSteelMaterialList[0];
      y.otherSteelMaterialList[0].projectId = X.projectId && X.projectId !== -1 ? X.projectId : void 0, y.otherSteelMaterialList[0].workshopId = X.workshopId && X.workshopId !== -1 ? X.workshopId : void 0, y.otherSteelMaterialList[0].warehouseId = X.warehouseId && X.warehouseId !== -1 ? X.warehouseId : void 0;
    }
  }
  function j(he, be) {
    var Le;
    const me = JSON.parse(JSON.stringify(he)), ge = Ct({ uid: Tt(), sn: he.sn, specificationLabels: me.specificationLabels, classifySerialNumber: me.classifySerialNumber, serialNumber: me.serialNumber, classifyId: me.classifyId, classifyFullPathId: me.classifyFullPathId, classifyFullName: me.classifyFullName, classifyName: me.classifyName, classifyParentFullName: me.classifyParentFullName, basicClass: me.basicClass, specification: me.specification, model: me.model, specificationMap: me.specificationMap, measureUnit: me.measureUnit, accountingUnit: me.accountingUnit, accountingPrecision: me.accountingPrecision, measurePrecision: me.measurePrecision, outboundUnitType: me.outboundUnitType, unitNet: me.unitNet, accountingUnitNet: me.accountingUnitNet, mete: me.mete, quantity: me.quantity, projectId: me.projectId, workshopId: me.workshopId, warehouseId: me.warehouseId, rowIndex: y.otherSteelMaterialList.length, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : me.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : me.amount });
    y.otherSteelMaterialList.push(ge), B(ge), (Le = r.value) == null || Le.initSelected([ge]);
  }
  function le(he, { unitNet: be, accountingPrecision: me }) {
    !n.boolPartyA && be && (he.mete = Be(he.quantity * be, me));
  }
  function oe(he, { accountingUnitNet: be, measurePrecision: me }) {
    !n.boolPartyA && he.measureUnit && be && (he.quantity = Be(he.mete * be, me));
  }
  function ye() {
    const he = y.otherSteelMaterialList.filter((me, ge) => {
      var Le;
      return me.dataIndex = ge, !!(n.boolPartyA || n.noDetail || (Le = y.selectObj[me.mergeId]) != null && Le.isSelected);
    });
    if (Ae(he)) return true;
    const { validResult: be } = N(he);
    return be && (P(he), he.forEach((me) => {
      var ge, Le;
      y.otherSteelMaterialList[me.dataIndex].projectId = me.projectId, y.otherSteelMaterialList[me.dataIndex].workshopId = me.workshopId || ((ge = me.workshop) == null ? void 0 : ge.id), y.otherSteelMaterialList[me.dataIndex].warehouseId = me.warehouseId || ((Le = me.warehouse) == null ? void 0 : Le.id), y.otherSteelMaterialList[me.dataIndex].quantity = me.measureUnit && A(me.measurePrecision) ? me.quantity : void 0;
    })), be;
  }
  function ce(he, be) {
  }
  Ce(() => y.otherSteelMaterialList, (he) => {
    n.noDetail && b.value && b.value.updateFooter();
  }, { deep: true, immediate: true });
  function se(he) {
    var be;
    return [(be = he.columns) == null ? void 0 : be.map((me, ge) => {
      if (ge === 0) return "合计";
      if (me.property === "amount") {
        const Le = he.data.reduce((Ie, Se) => Ie + (Number(Se.amount) || 0), 0);
        return Mi(Le || 0);
      }
      return null;
    })];
  }
  return o({ rowInit: ee, toggleRowSelection: ce, setSelect: I, rowWatch: B, validate: ye }), (he, be) => {
    const me = Mt, ge = Ve("vxe-column"), Le = Ve("vxe-tooltip"), Ie = Ve("common-input-number"), Se = jt, X = vt, $ = Ve("common-button"), k = Ve("vxe-table"), J = _t("empty-text"), z = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(k, { key: `inbound_${e.basicClass}`, ref_key: "tableRef", ref: b, "cell-class-name": l(L), columnConfig: M.value, data: l(y).otherSteelMaterialList, "empty-text": "暂无数据", "footer-method": se, "max-height": e.maxHeight, "row-style": Y, border: "", "scroll-y": g.value, class: "myTable-style", "show-footer": "", "show-overflow": "tooltip" }, { default: p(() => [s(ge, { type: "expand", width: "60" }, { content: p(({ row: F }) => [s(me, { modelValue: F.remark, "onUpdate:modelValue": (G) => F.remark = G, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(F.inboundList) ? (w(), Q("div", Tie, [s(l(al), { "basic-class": e.basicClass, list: F.inboundList, material: F, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)]), _: 1 }), s(ge, { title: "序号", type: "seq", width: "55" }), s(ge, { align: "center", field: "serialNumber", title: "编号", width: "100" }), s(ge, { align: "center", field: "classifyName", "min-width": "120", title: "物料种类" }, { default: p(({ row: F }) => [s(Le, { content: F.classifyParentFullName, disabled: !F.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[J, F.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ge, { align: "center", field: "specification", "min-width": "100px", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: F }) => [s(Le, { content: F.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(F.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(ge, { align: "center", field: "measureUnit", "min-width": "70px", title: "计量单位" }, { default: p(({ row: F }) => [C("span", null, K(F.measureUnit || "-"), 1)]), _: 1 }), n.boolPartyA || n.noDetail ? (w(), Q(Qe, { key: 0 }, [s(ge, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: F }) => [F.measureUnit && l(A)(F.measurePrecision) ? (w(), U(Ie, { key: 0, modelValue: F.quantity, "onUpdate:modelValue": (G) => F.quantity = G, controls: false, max: 999999999, min: 0, precision: F.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : qe((w(), Q("span", _ie, null, 512)), [[J]])]), _: 1 }), s(ge, { align: "center", field: "accountingUnit", "min-width": "70px", title: "核算单位" }, { default: p(({ row: F }) => [C("span", null, K(F.accountingUnit || "-"), 1)]), _: 1 }), s(ge, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: F }) => [s(Ie, { modelValue: F.mete, "onUpdate:modelValue": (G) => F.mete = G, controls: false, max: 999999999, min: 1e-6, precision: F.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), !n.boolPartyA && e.fillableAmount && e.noDetail ? (w(), U(qo, { key: 0, "weight-attribute": "mete" })) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [s(ge, { title: "关联项目", align: "right", field: "projects", "min-width": "100px" }, { default: p(({ row: F }) => [l(A)(F.projects) ? (w(true), Q(Qe, { key: 0 }, ki(F.projects, (G, ie) => {
      var ue;
      return w(), Q("span", { key: ie }, K(l(di)(G)) + " " + K(ie + 1 === ((ue = F.projects) == null ? void 0 : ue.length) ? "" : "、"), 1);
    }), 128)) : (w(), Q("span", bie, "-"))]), _: 1 }), s(ge, { key: "purchaseQuantity", title: "采购数量", align: "right", field: "purchaseQuantity", "min-width": "100px" }, { default: p(({ row: F }) => [F.measureUnit ? (w(), Q("span", Vie, [s(Le, { content: "已入库数量", placement: "top" }, { default: p(() => [C("span", wie, K(F.inboundQuantity), 1)]), _: 2 }, 1024), Te(" / " + K(F.purchaseQuantity), 1)])) : H("", true)]), _: 1 }), s(ge, { key: "accountingUnit", align: "center", field: "accountingUnit", "min-width": "70px", title: "核算单位" }, { default: p(({ row: F }) => [C("span", null, K(F.accountingUnit || "-"), 1)]), _: 1 }), s(ge, { key: "purchaseMete", title: "采购量", align: "right", field: "purchaseMete", "min-width": "100px" }, { default: p(({ row: F }) => [C("span", null, [s(Se, { content: "已入库量", effect: "dark", placement: "top" }, { default: p(() => [C("span", Sie, K(F.inboundMete), 1)]), _: 2 }, 1024), Te(" / " + K(F.purchaseMete), 1)])]), _: 1 })], 64)), s(ge, { key: "color", align: "center", field: "color", "min-width": "100px", title: "颜色" }, { default: p(({ row: F }) => [n.boolPartyA || n.noDetail ? (w(), U(me, { key: 0, modelValue: F.color, "onUpdate:modelValue": (G) => F.color = G, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", vie, [Te(K(F.color), 1)])), [[J]])]), _: 1 }), s(ge, { key: "brand", align: "center", field: "brand", "min-width": "100px", title: "品牌" }, { default: p(({ row: F }) => [n.boolPartyA || n.noDetail ? (w(), U(me, { key: 0, modelValue: F.brand, "onUpdate:modelValue": (G) => F.brand = G, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", Rie, [Te(K(F.brand), 1)])), [[J]])]), _: 1 }), !n.boolPartyA && !n.noDetail ? (w(), Q(Qe, { key: 2 }, [s(ge, { align: "center", field: "quantity", "min-width": "120px", title: "本次实收数" }, { default: p(({ row: F }) => [C("span", null, K(F.quantity || "-"), 1)]), _: 1 }), s(ge, { align: "center", field: "mete", "min-width": "120px", title: "本次实收量" }, { default: p(({ row: F }) => [C("span", null, K(F.mete ? F.mete.toFixed(F.accountingPrecision) : "-"), 1)]), _: 1 }), s(l(Td), { "base-unit": l(c), "basic-class": e.basicClass, "current-cfg": l(u), form: l(y), handleOverQuantity: l(O), list: l(y).otherSteelMaterialList, order: e.order }, { editColumn: p(({ row: F }) => [s(X, { align: "center", label: "规格", "min-width": "100px", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: G }) => [s(Se, { content: G.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(G.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(X, { align: "center", label: "颜色", "min-width": "120px", prop: "color" }, { default: p(({ row: G }) => [s(me, { modelValue: G.color, "onUpdate:modelValue": (ie) => G.color = ie, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(X, { align: "center", label: "本次实收数", "min-width": "120px", prop: "quantity" }, { default: p(({ row: G }) => [F.measureUnit ? (w(), U(Ie, { key: 0, modelValue: G.quantity, "onUpdate:modelValue": (ie) => G.quantity = ie, controls: false, max: 999999999, min: 0, precision: F.measurePrecision, step: 1, placeholder: "本次实收数", size: "default", style: { width: "100%" }, onBlur: (ie) => l(O)(G), onChange: (ie) => le(G, G) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur", "onChange"])) : (w(), Q("span", Mie, K(G.quantity || "-"), 1))]), _: 2 }, 1024), s(X, { align: "center", label: "本次实收量", "min-width": "120px", prop: "mete" }, { default: p(({ row: G }) => [s(Ie, { modelValue: G.mete, "onUpdate:modelValue": (ie) => G.mete = ie, controls: false, max: 999999999, min: 1e-6, precision: F.accountingPrecision, step: 1, placeholder: "实收量", size: "default", style: { width: "100%" }, onBlur: (ie) => l(x)(G) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 2 }, 1024)]), _: 1 }, 8, ["base-unit", "basic-class", "current-cfg", "form", "handleOverQuantity", "list", "order"])], 64)) : H("", true), !n.boolPartyA && e.noDetail ? (w(), Q(Qe, { key: 3 }, [s(go, { list: l(y).otherSteelMaterialList, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: l(y).otherSteelMaterialList, showWarehouse: "" }, null, 8, ["list"]), n.boolPartyA || n.noDetail ? (w(), U(ge, { key: 0, align: "center", fixed: "right", label: "操作", width: "160" }, { default: p(({ row: F, rowIndex: G }) => [s($, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (ie) => j(F, G) }, null, 8, ["onClick"]), s($, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (ie) => ae(F.sn, G, F) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)], 64)) : H("", true)]), _: 1 }, 8, ["cell-class-name", "columnConfig", "data", "max-height", "scroll-y"]))])), [[z, V.value]])]);
  };
} }, Z3 = ut(Aie, [["__scopeId", "data-v-b2c39bac"]]), Nie = Object.freeze(Object.defineProperty({ __proto__: null, default: Z3 }, Symbol.toStringTag, { value: "Module" }));
const Lie = { style: { overflow: "hidden" } }, Iie = { style: {} }, Cie = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Pie = { key: 1 }, Oie = { key: 1 }, kie = { key: 1 }, Die = { key: 1 }, xie = { key: 1 }, Uie = { key: 1 }, Yie = { __name: "other-steel-begin-material-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Pe.OTHER_STEEL_MATERIALS.V, u = ft("matSpecRef"), { priceAbnormal: r } = aa(), { baseUnit: E } = ai(c), { cu: y, form: b } = Wi(), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g, currentCfg: S } = Va(E), h = Z(false), T = Z(null), _ = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const f = Z({ enabled: true, gt: 50, oSize: 5, scrollToTopOnChange: true, immediate: true }), m = Z([{ seq: "合计", amountExcludingVatFreight: "-", amount: "-" }]);
  Ce(() => b.otherSteelMaterialList, (z) => {
    R();
  }, { deep: true, immediate: true });
  function R() {
    var G;
    let z = 0, F = 0;
    (G = b.otherSteelMaterialList) == null || G.forEach((ie) => {
      z += Number(ie.amount) || 0, F += Number(ie.amountExcludingVatFreight) || 0;
    }), z = z.toFixed(Ze.YUAN), F = F.toFixed(Ze.YUAN), m.value = [{ seq: "合计", amountExcludingVatFreight: F, amount: z }];
  }
  const { specSelectMaxHeight: v, specRef: N, drawerRef: P, editRow: L, editList: O, materialSelectVisible: x, handleClickEditSpec: I, handleSpecChange: Y } = Qa(), ee = /^(?!(0[0-9]{1,}$))[0-9]*[.]{0,}[0-9]{0,}$/, q = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (z, F) => !!z, message: "核算量必须大于0", trigger: "blur" }], quantity: [{ validator: (z, F) => A(F.measureUnit) ? !!F.quantity : true }], amount: [{ required: true, message: "请输入含税金额", trigger: "change" }, { pattern: ee, message: "含税金额必须大于0", trigger: "blur" }], amountExcludingVatFreight: [{ required: true, message: "请输入不含税金额", trigger: "change" }, { pattern: ee, message: "不含税金额必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, ae = Ee(() => {
    let z = Object.assign({}, q);
    return !n.boolPartyA && n.fillableAmount && (z = Object.assign(z, {})), z;
  }), j = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: le, cleanUpData: oe, wrongCellMask: ye } = ui({ rules: ae, ditto: j, errorMsg: "请修正【其他钢材清单】中标红的信息" });
  function ce() {
  }
  function se({ row: z, rowIndex: F }) {
    var G, ie;
    if ((ie = (G = y == null ? void 0 : y.submitResult) == null ? void 0 : G.data) != null && ie.includes(z.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function he(z) {
    const F = Ct({ uid: Tt(), sn: z.sn, specificationLabels: z.specificationLabels, classifySerialNumber: z.classify.serialNumber, serialNumber: z.serialNumber, classifyId: z.classify.id, classifyFullName: z.classify.fullName, classifyName: z.classify.name, classifyParentFullName: z.classify.parentFullName, basicClass: z.classify.basicClass, specification: z.spec, model: z.spec, specificationMap: z.specKV, measureUnit: z.classify.measureUnit, accountingUnit: z.classify.accountingUnit, accountingPrecision: z.classify.accountingPrecision, measurePrecision: z.classify.measurePrecision, accountingUnitNet: z.accountingUnitNet, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, projectId: b.otherSteelMaterialList.length > 0 ? -1 : void 0, workshopId: b.otherSteelMaterialList.length > 0 ? -1 : void 0, warehouseId: b.otherSteelMaterialList.length > 0 ? -1 : void 0, rowIndex: b.otherSteelMaterialList.length });
    return !n.boolPartyA && n.fillableAmount && (F.unitPrice = void 0, F.amount = void 0), ge(F), F;
  }
  function be(z, { unitNet: F, accountingPrecision: G }) {
    !n.boolPartyA && F && (z.mete = Be(z.quantity * F, G));
  }
  function me(z, { accountingUnitNet: F, measurePrecision: G }) {
    !n.boolPartyA && z.measureUnit && F && (z.quantity = Be(z.mete * F, G));
  }
  function ge(z) {
    Ce(() => z.mete, () => {
      Se(z.mete, z);
    }), Dt(() => {
      var F, G, ie, ue;
      z.needFirstCalcTheoryWeight && (z.boolApplyPurchase || (Le(z), Ie(z)), z.boolApplyPurchase && ((G = (F = b.selectObj) == null ? void 0 : F[z.mergeId]) != null && G.isSelected) && (z.quantity = (ie = z == null ? void 0 : z.applyPurchase) == null ? void 0 : ie.reduce((ne, te) => ne + (te.quantity || 0), 0), z.theoryTotalWeight = (ue = z == null ? void 0 : z.applyPurchase) == null ? void 0 : ue.reduce((ne, te) => ne + (te.theoryTotalWeight || 0), 0)), z.needFirstCalcTheoryWeight = false), M(z);
    }), Ce([() => z.boolApplyPurchase, () => z == null ? void 0 : z.applyPurchase], () => {
      var F, G, ie, ue;
      z.boolApplyPurchase && ((G = (F = b.selectObj) == null ? void 0 : F[z.mergeId]) != null && G.isSelected ? (z.quantity = (ie = z == null ? void 0 : z.applyPurchase) == null ? void 0 : ie.reduce((ne, te) => ne + (te.quantity || 0), 0), z.theoryTotalWeight = (ue = z == null ? void 0 : z.applyPurchase) == null ? void 0 : ue.reduce((ne, te) => ne + (te.theoryTotalWeight || 0), 0), z.weighingTotalWeight = z.theoryTotalWeight) : (z.quantity = 0, z.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => z, () => {
      var F, G, ie;
      if (!n.boolPartyA && !n.noDetail && ((G = (F = b.selectObj) == null ? void 0 : F[z.mergeId]) != null && G.isSelected)) {
        const ue = (ie = b.selectObj[z.mergeId]) == null ? void 0 : ie.isSelected;
        b.selectObj[z.mergeId] = { ...b.selectObj[z.mergeId], ...z, mete: z.weighingTotalWeight, isSelected: ue };
      }
    }, { deep: true }), z.boolApplyPurchase || (Ce([() => z.length, () => z.width, () => z.thickness, E], () => Le(z)), Ce([() => z.theoryWeight, () => z.quantity], () => Ie(z)));
  }
  async function Le(z) {
    z.theoryWeight = await na({ classifyId: z.classifyId, name: z.classifyFullName, length: z.length, width: z.width, thickness: z.thickness });
  }
  function Ie(z) {
    A(z.theoryWeight) && z.quantity ? (z.theoryTotalWeight = Be(z.theoryWeight * z.quantity, E.value.weight.precision), (n.boolPartyA || n.noDetail) && (z.weighingTotalWeight = Be(z.theoryWeight * z.quantity, E.value.weight.precision))) : (z.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (z.weighingTotalWeight = void 0));
  }
  function Se(z, F, G) {
    A(F.unitPrice) && A(z) ? F.amount = Be(z * F.unitPrice, Ze.YUAN) : F.amount = void 0, me(F, G || F);
  }
  function X(z, F, G) {
    u.value ? u.value.delListItem(z, F) : b.otherSteelMaterialList.splice(F, 1);
  }
  function $(z, F) {
    var ue;
    const G = JSON.parse(JSON.stringify(z)), ie = Ct({ uid: Tt(), sn: G.sn, specificationLabels: G.specificationLabels, classifySerialNumber: G.classifySerialNumber, serialNumber: G.serialNumber, classifyId: G.classifyId, classifyFullName: G.classifyFullName, classifyName: G.classifyName, classifyParentFullName: G.classifyParentFullName, basicClass: G.basicClass, specification: G.specification, model: G.spec, specificationMap: G.specificationMap, measureUnit: G.measureUnit, accountingUnit: G.accountingUnit, accountingPrecision: G.accountingPrecision, measurePrecision: G.measurePrecision, quantity: G.quantity, thickness: G.thickness, length: G.length, width: G.width, theoryWeight: G.theoryWeight, theoryTotalWeight: G.theoryTotalWeight, weighingTotalWeight: G.weighingTotalWeight, rowIndex: b.otherSteelMaterialList.length, weightMeasurementMode: G.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : G.unitPrice, accountingUnitNet: G.accountingUnitNet, mete: G.mete, color: G.color, brand: G.brand, amount: G.amount, amountExcludingVatFreight: G.amountExcludingVatFreight, projectSerialNumber: G.projectSerialNumber, projectId: G.projectId, workshopName: G.workshopName, warehouseName: G.warehouseName, workshopId: G.workshopId, warehouseId: G.warehouseId });
    b.otherSteelMaterialList.push(ie), ge(ie), (ue = u.value) == null || ue.initSelected([ie]);
  }
  async function k() {
    const z = At(b.otherSteelMaterialList), { validResult: F } = le(b.otherSteelMaterialList);
    if (F) {
      let G = true;
      const ie = [];
      if (A(r.value) && r.value.forEach((ue) => {
        var te;
        const ne = (te = b.otherSteelMaterialList) == null ? void 0 : te.filter((de) => de.basicClass === ue.basicClass);
        A(ne) && ne.forEach((de) => {
          ue.minPrice && de.amount < ue.minPrice * de.mete && ie.push({ msg: `${Pe.VL[de.basicClass]} ${de.serialNumber} ${de.classifyName}：含税金额${de.amount} < 异常配置最小值${ue.minPrice}*核算量` }), ue.maxPrice && de.amount > ue.maxPrice * de.mete && ie.push({ msg: `${Pe.VL[de.basicClass]} ${de.serialNumber} ${de.classifyName}：含税金额${de.amount} > 异常配置最大值${ue.maxPrice}*核算量` });
        });
      }), A(ie)) {
        const ue = ie.map((ne) => `<div>${ne.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + ue, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          G = true;
        }).catch((ne) => {
          G = false;
        });
      }
      if (!G) return false;
    }
    if (F) oe(z), z.forEach((G) => {
    });
    else {
      const G = b.otherSteelMaterialList.find((ie) => ie.verify ? Object.values(ie.verify).some((ue) => ue === false) : false);
      G && T.value && pt(() => {
        T.value.scrollToRow(G);
      });
    }
    return F;
  }
  function J(z, F) {
  }
  return o({ rowInit: he, rowWatch: ge, toggleRowSelection: J, validate: k, setSelect: ce }), (z, F) => {
    const G = Mt, ie = Ve("vxe-column"), ue = Ve("vxe-tooltip"), ne = ya, te = Ve("common-input-number"), de = Ve("common-button"), pe = Ve("vxe-table"), re = Ve("common-drawer"), we = _t("empty-text"), Ke = oi;
    return w(), Q("div", null, [qe((w(), Q("div", Lie, [(w(), U(pe, { ref_key: "tableRef", ref: T, key: `inbound_${l(c)}`, "cell-class-name": l(ye), "column-config": _.value, data: l(b).otherSteelMaterialList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": se, "scroll-y": f.value, border: "", "footer-data": m.value, "show-footer": "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(ie, { type: "expand", width: "60" }, { content: p(({ row: Me }) => [C("div", Iie, [s(G, { modelValue: Me.remark, "onUpdate:modelValue": (Ne) => Me.remark = Ne, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(Me.inboundList) ? (w(), Q("div", Cie, [s(l(al), { "basic-class": l(c), list: Me.inboundList, material: Me, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(ie, { title: "序号", type: "seq", width: "55" }), s(ie, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: Me }) => [s(ue, { content: Me.classifyParentFullName, disabled: !Me.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[we, Me.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ie, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: Me }) => {
      var Ne, He, ze;
      return [(He = (Ne = l(b).selectObj) == null ? void 0 : Ne[Me.mergeId]) != null && He.isSelected && ((ze = l(S)) == null ? void 0 : ze.spec) & l(c) && !Me.boolApplyPurchase ? (w(), U(ne, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Oe) => l(I)(Me) }, null, 8, ["onClick"])) : H("", true), s(ue, { content: Me.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Me.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(ie, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: Me }) => [C("span", null, K(Me.measureUnit || "-"), 1)]), _: 1 }), s(ie, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: Me }) => [e.isEdit && l(A)(Me.measureUnit) ? (w(), U(te, { key: 0, modelValue: Me.quantity, "onUpdate:modelValue": (Ne) => Me.quantity = Ne, controls: false, max: 999999999, min: 0, precision: Me.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" }, onChange: (Ne) => be(Me, Me) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (w(), Q("span", Pie, K(Me.quantity), 1))]), _: 1 }), s(ie, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: Me }) => [C("span", null, K(Me.accountingUnit || "-"), 1)]), _: 1 }), s(ie, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: Me.mete, "onUpdate:modelValue": (Ne) => Me.mete = Ne, controls: false, max: 999999999, min: 1e-6, precision: Me.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Oie, K(Me.mete), 1))]), _: 1 }), s(ie, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: Me.color, "onUpdate:modelValue": (Ne) => Me.color = Ne, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", kie, K(Me.color), 1))]), _: 1 }), s(ie, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: Me.brand, "onUpdate:modelValue": (Ne) => Me.brand = Ne, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Die, K(Me.brand), 1))]), _: 1 }), s(ie, { align: "center", field: "amount", title: "含税金额", width: "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: Me.amount, "onUpdate:modelValue": (Ne) => Me.amount = Ne, controls: false, min: 0, precision: 2, placeholder: "含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", xie, K(Me.amount), 1))]), _: 1 }), s(ie, { align: "center", field: "amountExcludingVatFreight", title: "不含税金额", width: "120" }, { default: p(({ row: Me }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: Me.amountExcludingVatFreight, "onUpdate:modelValue": (Ne) => Me.amountExcludingVatFreight = Ne, controls: false, min: 0, precision: 2, placeholder: "不含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Uie, K(Me.amountExcludingVatFreight), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(b).otherSteelMaterialList }, null, 8, ["list"])) : (w(), U(ie, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: Me }) => [C("span", null, K(Me.projectFullName || Me.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(b).otherSteelMaterialList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(ie, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: Me }) => [C("span", null, K(Me.workshopName), 1)]), _: 1 }), s(ie, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: Me }) => [C("span", null, K(Me.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(ie, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: Me, rowIndex: Ne }) => [s(de, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (He) => $(Me, Ne) }, null, 8, ["onClick"]), s(de, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (He) => X(Me.sn, Ne, Me) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[Ke, h.value]]), s(re, { ref_key: "drawerRef", ref: P, modelValue: l(x), "onUpdate:modelValue": F[1] || (F[1] = (Me) => Gt(x) ? x.value = Me : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: N, modelValue: l(O), "onUpdate:modelValue": F[0] || (F[0] = (Me) => Gt(O) ? O.value = Me : null), classifyId: l(L).classifyId, "max-height": l(v), "show-classify": false, visible: l(x), "expand-query": "", mode: "selector", onChange: l(Y) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, J3 = ut(Yie, [["__scopeId", "data-v-3555822c"]]), Kie = Object.freeze(Object.defineProperty({ __proto__: null, default: J3 }, Symbol.toStringTag, { value: "Module" }));
const Wie = { __name: "steel-plate-table", props: { order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] }, fillableDetailAmount: { type: Boolean, default: false } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_PLATE.V, { baseUnit: u } = ai(c), { overDiffTip: r, weightOverDiff: E, diffSubmitValidate: y } = Va(u), b = Z(false), V = Z([]), M = Z({ resizable: true }), g = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), T = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: Vi, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: Vi, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: y, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: (q, ae) => A(q) ? q > 0 : true, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: Vi, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }], projectId: [{ validator: (q, ae) => A(n.order) && A(n.order.projects) && n.noDetail ? !!q : true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, f = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (q, ae) => A(ae.weighingTotalWeight) && A(ae.unitPrice) ? +Be(ae.weighingTotalWeight * ae.unitPrice, Ze.YUAN) == +q : false, message: "金额有误，请手动修改", trigger: "blur" }] }, m = Ee(() => {
    let q = Object.assign({}, T);
    return n.fillableDetailAmount && (q = Object.assign(q, f)), q;
  }), R = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: v, cleanUpData: N, wrongCellMask: P } = ui({ rules: m, ditto: R, errorMsg: "请修正【钢板清单】中标红的信息" });
  function L(q) {
    return O(q), q;
  }
  Ce(() => n.list, (q) => {
    A(n.list) ? V.value = JSON.parse(JSON.stringify(n.list)) : V.value = [], V.value.forEach((ae) => {
      O(ae);
    });
  }, { deep: true, immediate: true });
  function O(q) {
    Dt(() => {
      E(q), q.needFirstCalcTheoryWeight && (q.boolApplyPurchase || (x(q), I(q)), q.needFirstCalcTheoryWeight = false);
    }), Ce([() => q.length, () => q.width, () => q.thickness, u], () => x(q)), Ce([() => q.theoryWeight, () => q.quantity], () => I(q)), Ce(() => q.weighingTotalWeight, () => {
      Y(q);
    });
  }
  async function x(q) {
    q.theoryWeight = await na({ classifyId: q.classifyId, name: q.classifyFullName, length: q.length, width: q.width, thickness: q.thickness });
  }
  function I(q) {
    A(q.theoryWeight) && q.quantity ? (q.theoryTotalWeight = Be(q.theoryWeight * q.quantity, u.value.weight.precision), q.weighingTotalWeight = Be(q.theoryWeight * q.quantity, u.value.weight.precision)) : (q.theoryTotalWeight = void 0, q.weighingTotalWeight = void 0);
  }
  function Y(q) {
    A(q.unitPrice) && A(q.weighingTotalWeight) ? q.amount = Be(q.weighingTotalWeight * q.unitPrice, Ze.YUAN) : q.amount = void 0;
  }
  function ee(q, ae, j) {
    if (V.value.splice(ae, 1), A(V.value) && V.value.length > 0) {
      const le = V.value[0];
      V.value[0].projectId = le.projectId && le.projectId !== -1 ? le.projectId : void 0, V.value[0].workshopId = le.workshopId && le.workshopId !== -1 ? le.workshopId : void 0, V.value[0].warehouseId = le.warehouseId && le.warehouseId !== -1 ? le.warehouseId : void 0;
    }
  }
  function B() {
    if (Ae(V.value)) return ot.error("明细不能为空"), false;
    const q = V.value.filter((j, le) => (j.dataIndex = le, true)), { validResult: ae } = v(q);
    return ae && (N(q), q.forEach((j) => {
      var le, oe;
      V.value[j.dataIndex].projectId = j.projectId, V.value[j.dataIndex].workshopId = j.workshopId || ((le = j.workshop) == null ? void 0 : le.id), V.value[j.dataIndex].warehouseId = j.warehouseId || ((oe = j.warehouse) == null ? void 0 : oe.id);
    })), ae;
  }
  return o({ rowInit: L, rowWatch: O, validate: B, tableList: V }), (q, ae) => {
    const j = Ve("vxe-column"), le = Ve("vxe-tooltip"), oe = Ve("common-input-number"), ye = jt, ce = Mt, se = Ve("common-button"), he = Ve("vxe-table"), be = _t("empty-text"), me = oi;
    return qe((w(), Q("div", null, [(w(), U(he, { key: `import_${l(c)}`, "cell-class-name": l(P), "column-config": M.value, data: V.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": g.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(j, { title: "序号", type: "seq", width: "55" }), s(j, { align: "center", field: "serialNumber", "min-width": "110px", title: "编号" }), s(j, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: ge }) => [s(le, { content: ge.classifyParentFullName, disabled: !ge.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[be, ge.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(j, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: ge }) => [s(le, { content: ge.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(ge.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(j, { title: `厚 (${l(u).thickness.unit})`, align: "center", field: "thickness", "min-width": "100px" }, { default: p(({ row: ge }) => [C("span", null, K(ge.thickness), 1)]), _: 1 }, 8, ["title"]), s(j, { title: `宽 (${l(u).width.unit})`, align: "center", field: "width", "min-width": "135px" }, { default: p(({ row: ge }) => [s(oe, { modelValue: ge.width, "onUpdate:modelValue": (Le) => ge.width = Le, controls: false, max: 99999999, min: 0, precision: l(u).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(j, { title: `长 (${l(u).length.unit})`, align: "center", field: "length", "min-width": "135px" }, { default: p(({ row: ge }) => [s(oe, { modelValue: ge.length, "onUpdate:modelValue": (Le) => ge.length = Le, controls: false, max: 99999999, min: 0, precision: l(u).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(j, { title: `数量 (${l(u).measure.unit})`, align: "center", field: "quantity", "min-width": "135px" }, { default: p(({ row: ge }) => [s(oe, { modelValue: ge.quantity, "onUpdate:modelValue": (Le) => ge.quantity = Le, controls: false, max: 999999999, min: 1, precision: l(u).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(j, { key: "weighingTotalWeight", title: `总重 (${l(u).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "135px" }, { default: p(({ row: ge }) => [s(ye, { content: `理论重量：${ge.theoryTotalWeight} kg， ${l(r)}`, disabled: !ge.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(oe, { modelValue: ge.weighingTotalWeight, "onUpdate:modelValue": (Le) => ge.weighingTotalWeight = Le, class: Zt({ "over-weight-tip": ge.hasOver }), controls: false, max: 999999999, min: 0, precision: l(u).weight.precision, "controls-position": "right", placeholder: "重量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"]), e.fillableDetailAmount ? (w(), U(qo, { key: 0 })) : H("", true), s(j, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: ge }) => [s(ce, { modelValue: ge.brand, "onUpdate:modelValue": (Le) => ge.brand = Le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(j, { align: "center", field: "heatNoAndBatchNo", title: "炉批号", width: "120" }, { default: p(({ row: ge }) => [s(ce, { modelValue: ge.heatNoAndBatchNo, "onUpdate:modelValue": (Le) => ge.heatNoAndBatchNo = Le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(go, { list: V.value, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: V.value, showWarehouse: "" }, null, 8, ["list"]), s(j, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: ge, rowIndex: Le }) => [s(se, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ie) => ee(ge.sn, Le, ge) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[me, b.value]]);
  };
} }, X3 = ut(Wie, [["__scopeId", "data-v-be460930"]]), jie = Object.freeze(Object.defineProperty({ __proto__: null, default: X3 }, Symbol.toStringTag, { value: "Module" }));
const Fie = { style: { overflow: "hidden" } }, zie = { __name: "section-steel-table", props: { order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] }, fillableDetailAmount: { type: Boolean, default: false } }, setup(e, { expose: o }) {
  const n = e, c = Ge.SECTION_STEEL.V, { baseUnit: u } = ai(c), r = Z(false), E = Z([]), y = Z({ resizable: true }), b = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g } = Va(u), h = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { pattern: Vi, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: g, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], projectId: [{ validator: (ae, j) => A(n.order) && A(n.order.projects) && n.noDetail ? !!ae : true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, _ = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (ae, j) => A(j.weighingTotalWeight) && A(j.unitPrice) ? +Be(j.weighingTotalWeight * j.unitPrice, Ze.YUAN) == +ae : false, message: "金额有误，请手动修改", trigger: "blur" }] }, f = Ee(() => {
    let ae = Object.assign({}, h);
    return n.fillableDetailAmount && (ae = Object.assign(ae, _)), ae;
  }), m = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: R, cleanUpData: v, wrongCellMask: N } = ui({ rules: f, ditto: m, errorMsg: "请修正【型材清单】中标红的信息" });
  function P(ae, j) {
    const le = j.find((oe) => oe.standardId === ae.standardId);
    ae.unitWeight = le.unitWeight;
  }
  function L(ae) {
    return O(ae), ae;
  }
  Ce(() => n.list, (ae) => {
    A(n.list) ? E.value = JSON.parse(JSON.stringify(n.list)) : E.value = [], E.value.forEach((j) => {
      O(j);
    });
  }, { deep: true, immediate: true });
  function O(ae) {
    Dt(() => {
      M(ae), ae.needFirstCalcTheoryWeight && (I(ae), ee(ae), ae.needFirstCalcTheoryWeight = false);
    }), Ce([() => ae.length, () => ae.unitWeight, u], () => I(ae)), Ce([() => ae.theoryWeight, () => ae.quantity], () => {
      ee(ae);
    }), Ce(() => ae.weighingTotalWeight, () => {
      x(ae);
    }), Ce([() => ae.length, () => ae.quantity], () => {
      Y(ae);
    });
  }
  function x(ae) {
    A(ae.unitPrice) && A(ae.weighingTotalWeight) ? ae.amount = Be(ae.weighingTotalWeight * ae.unitPrice, Ze.YUAN) : ae.amount = void 0;
  }
  async function I(ae) {
    ae.theoryWeight = await xa({ length: ae.length, unitWeight: ae.unitWeight });
  }
  function Y(ae) {
    A(ae.length) && ae.quantity ? ae.totalLength = Na({ length: ae.length, quantity: ae.quantity }) : ae.totalLength = void 0;
  }
  function ee(ae) {
    console.log(ae, "row11111"), A(ae.theoryWeight) && ae.quantity ? (ae.theoryTotalWeight = Be(ae.theoryWeight * ae.quantity, u.value.weight.precision), ae.weighingTotalWeight = Be(ae.theoryWeight * ae.quantity, u.value.weight.precision)) : (ae.theoryTotalWeight = void 0, ae.weighingTotalWeight = void 0);
  }
  function B(ae, j, le) {
    if (E.value.splice(j, 1), A(E) && E.value.length > 0) {
      const oe = E.value[0];
      E.value[0].projectId = oe.projectId && oe.projectId !== -1 ? oe.projectId : void 0, E.value[0].workshopId = oe.workshopId && oe.workshopId !== -1 ? oe.workshopId : void 0, E.value[0].warehouseId = oe.warehouseId && oe.warehouseId !== -1 ? oe.warehouseId : void 0;
    }
  }
  function q() {
    if (Ae(E.value)) return ot.error("明细不能为空"), false;
    const ae = E.value.filter((le, oe) => (le.dataIndex = oe, true));
    if (Ae(ae)) return true;
    const { validResult: j } = R(ae);
    return j && (v(ae), ae.forEach((le) => {
      var oe, ye;
      E.value[le.dataIndex].projectId = le.projectId, E.value[le.dataIndex].workshopId = le.workshopId || ((oe = le.workshop) == null ? void 0 : oe.id), E.value[le.dataIndex].warehouseId = le.warehouseId || ((ye = le.warehouse) == null ? void 0 : ye.id);
    })), j;
  }
  return o({ rowInit: L, rowWatch: O, validate: q, tableList: E }), (ae, j) => {
    const le = Ve("vxe-column"), oe = Ve("vxe-tooltip"), ye = Ve("common-input-number"), ce = Ve("common-select"), se = jt, he = Mt, be = Ve("common-button"), me = Ve("vxe-table"), ge = _t("empty-text"), Le = oi;
    return qe((w(), Q("div", Fie, [(w(), U(me, { key: `import_${l(c)}`, "cell-class-name": l(N), "column-config": y.value, data: E.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": b.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(le, { title: "序号", type: "seq", width: "55" }), s(le, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), s(le, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: Ie }) => [s(oe, { content: Ie.classifyParentFullName, disabled: !Ie.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ge, Ie.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(le, { align: "center", field: "specification", "min-width": "120", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: Ie }) => [s(oe, { content: Ie.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Ie.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(le, { title: `定尺长度 (${l(u).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: Ie }) => [s(ye, { modelValue: Ie.length, "onUpdate:modelValue": (Se) => Ie.length = Se, controls: false, max: 99999999, min: 0, precision: l(u).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(le, { align: "center", field: "profileLibraryStandard", "min-width": "140", title: "型材库标准" }, { default: p(({ row: Ie }) => [s(ce, { modelValue: Ie.standardId, "onUpdate:modelValue": (Se) => Ie.standardId = Se, dataStructure: { key: "standardId", label: "name", value: "standardId" }, options: Ie.nationalStandardOptions || [], placeholder: "请选择标准", style: { width: "100%" }, type: "other", onChange: (Se) => P(Ie, Ie.nationalStandardOptions) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), s(le, { title: `数量 （${l(u).measure.unit})`, align: "center", field: "quantity", "min-width": "120" }, { default: p(({ row: Ie }) => [s(ye, { modelValue: Ie.quantity, "onUpdate:modelValue": (Se) => Ie.quantity = Se, controls: false, max: 99999999, min: 0, precision: l(u).measure.precision, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(le, { title: "总长度 (m)", align: "center", "min-width": "135px", field: "totalLength" }), s(le, { title: `总重 (${l(u).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: Ie }) => [s(se, { content: `单位重量：${Ie.unitWeight} kg/m， 理论重量：${Ie.theoryTotalWeight} kg， ${l(V)}`, disabled: !Ie.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(ye, { modelValue: Ie.weighingTotalWeight, "onUpdate:modelValue": (Se) => Ie.weighingTotalWeight = Se, class: Zt({ "over-weight-tip": Ie.hasOver }), controls: false, max: 999999999, min: 0, precision: l(u).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"]), e.fillableDetailAmount ? (w(), U(qo, { key: 0 })) : H("", true), s(le, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: Ie }) => [s(he, { modelValue: Ie.brand, "onUpdate:modelValue": (Se) => Ie.brand = Se, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(le, { align: "center", field: "heatNoAndBatchNo", title: "炉批号", width: "120" }, { default: p(({ row: Ie }) => [s(he, { modelValue: Ie.heatNoAndBatchNo, "onUpdate:modelValue": (Se) => Ie.heatNoAndBatchNo = Se, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(go, { list: E.value, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: E.value, showWarehouse: "" }, null, 8, ["list"]), s(le, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: Ie, rowIndex: Se }) => [s(be, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (X) => B(Ie.sn, Se, Ie) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[Le, r.value]]);
  };
} }, $3 = ut(zie, [["__scopeId", "data-v-e3691674"]]), Bie = Object.freeze(Object.defineProperty({ __proto__: null, default: $3 }, Symbol.toStringTag, { value: "Module" }));
const Hie = { style: { overflow: "hidden" } }, qie = { __name: "steel-coil-table", props: { order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] }, fillableDetailAmount: { type: Boolean, default: false } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_COIL.V, u = Z(false), r = Z([]), E = Z({ resizable: true }), y = Z({ enabled: true, gt: 0, oSize: 5, scrollToTopOnChange: true, immediate: true }), V = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: Vi, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: Vi, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: Vi, message: "长度必须大于0", trigger: "blur" }], projectId: [{ validator: (I, Y) => A(n.order) && A(n.order.projects) && n.noDetail ? !!I : true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, g = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (I, Y) => A(Y.weighingTotalWeight) && A(Y.unitPrice) ? +Be(Y.weighingTotalWeight * Y.unitPrice, Ze.YUAN) == +I : false, message: "金额有误，请手动修改", trigger: "blur" }] }, S = Ee(() => {
    let I = Object.assign({}, V);
    return n.fillableDetailAmount && (I = Object.assign(I, g)), I;
  }), { baseUnit: h } = ai(c), T = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: _, cleanUpData: f, wrongCellMask: m } = ui({ rules: S, ditto: T, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function R(I) {
    return v(I), I;
  }
  Ce(() => n.list, (I) => {
    A(n.list) ? r.value = JSON.parse(JSON.stringify(n.list)) : r.value = [], r.value.forEach((Y) => {
      v(Y);
    });
  }, { deep: true, immediate: true });
  function v(I) {
    Ce([() => I.weighingTotalWeight, () => I.width, () => I.thickness, h], () => P(I)), Ce([() => I.theoryLength], () => L(I)), Ce(() => I.weighingTotalWeight, () => {
      N(I);
    });
  }
  function N(I) {
    A(I.unitPrice) && A(I.weighingTotalWeight) ? I.amount = Be(I.weighingTotalWeight * I.unitPrice, Ze.YUAN) : I.amount = void 0;
  }
  async function P(I) {
    I.theoryLength = await il({ classifyId: I.classifyId, name: I.classifyFullName, weight: I.weighingTotalWeight, width: I.width, thickness: I.thickness });
  }
  function L(I) {
    A(I.theoryLength) ? I.length = I.theoryLength * 1 : I.length = void 0;
  }
  function O(I, Y, ee) {
    if (r.value.splice(Y, 1), A(r) && r.value.length > 0) {
      const B = r.value[0];
      r.value[0].projectId = B.projectId && B.projectId !== -1 ? B.projectId : void 0, r.value[0].workshopId = B.workshopId && B.workshopId !== -1 ? B.workshopId : void 0, r.value[0].warehouseId = B.warehouseId && B.warehouseId !== -1 ? B.warehouseId : void 0;
    }
  }
  function x() {
    if (Ae(r.value)) return ot.error("明细不能为空"), false;
    const I = r.value.filter((ee, B) => (ee.dataIndex = B, true));
    if (Ae(I)) return true;
    const { validResult: Y } = _(I);
    return Y && (f(I), I.forEach((ee) => {
      var B, q;
      r.value[ee.dataIndex].projectId = ee.projectId, r.value[ee.dataIndex].workshopId = ee.workshopId || ((B = ee.workshop) == null ? void 0 : B.id), r.value[ee.dataIndex].warehouseId = ee.warehouseId || ((q = ee.warehouse) == null ? void 0 : q.id);
    })), Y;
  }
  return o({ rowInit: R, rowWatch: v, validate: x, tableList: r }), (I, Y) => {
    const ee = Ve("vxe-column"), B = Ve("vxe-tooltip"), q = Ve("common-input-number"), ae = Mt, j = Ve("common-button"), le = Ve("vxe-table"), oe = _t("empty-text"), ye = oi;
    return qe((w(), Q("div", Hie, [(w(), U(le, { key: `import_${l(c)}`, "cell-class-name": l(m), "column-config": E.value, data: r.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": y.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(ee, { title: "序号", type: "seq", width: "55" }), s(ee, { align: "center", field: "serialNumber", "min-width": "110px", title: "编号" }), s(ee, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: ce }) => [s(B, { content: ce.classifyParentFullName, disabled: !ce.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[oe, ce.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ee, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: ce }) => [s(B, { content: ce.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(ce.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(ee, { title: `总重 (${l(h).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: ce }) => [s(q, { modelValue: ce.weighingTotalWeight, "onUpdate:modelValue": (se) => ce.weighingTotalWeight = se, controls: false, max: 999999999, min: 0, precision: l(h).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), e.fillableDetailAmount ? (w(), U(qo, { key: 0 })) : H("", true), s(ee, { title: `厚 (${l(h).thickness.unit})`, align: "center", field: "thickness", "min-width": "120" }, { default: p(({ row: ce }) => [s(q, { modelValue: ce.thickness, "onUpdate:modelValue": (se) => ce.thickness = se, controls: false, max: 99999999, min: 0, precision: l(h).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(ee, { title: `宽 (${l(h).width.unit})`, align: "center", field: "width", "min-width": "120" }, { default: p(({ row: ce }) => [s(q, { modelValue: ce.width, "onUpdate:modelValue": (se) => ce.width = se, controls: false, max: 99999999, min: 0, precision: l(h).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(ee, { title: `长度 (${l(h).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: ce }) => [s(q, { modelValue: ce.length, "onUpdate:modelValue": (se) => ce.length = se, controls: false, max: 99999999, min: 0, precision: l(h).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(ee, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: ce }) => [s(ae, { modelValue: ce.color, "onUpdate:modelValue": (se) => ce.color = se, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(ee, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: ce }) => [s(ae, { modelValue: ce.brand, "onUpdate:modelValue": (se) => ce.brand = se, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(ee, { align: "center", field: "heatNoAndBatchNo", title: "卷号", width: "120" }, { default: p(({ row: ce }) => [s(ae, { modelValue: ce.heatNoAndBatchNo, "onUpdate:modelValue": (se) => ce.heatNoAndBatchNo = se, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(go, { list: r.value, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: r.value, showWarehouse: "" }, null, 8, ["list"]), s(ee, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: ce, rowIndex: se }) => [s(j, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (he) => O(ce.sn, se, ce) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[ye, u.value]]);
  };
} }, e4 = ut(qie, [["__scopeId", "data-v-772edcd3"]]), Gie = Object.freeze(Object.defineProperty({ __proto__: null, default: e4 }, Symbol.toStringTag, { value: "Module" }));
const Qie = { style: { overflow: "hidden" } }, Zie = { key: 1 }, Jie = { __name: "other-steel-material-table", props: { order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] }, fillableDetailAmount: { type: Boolean, default: false } }, setup(e, { expose: o }) {
  const n = e, c = Pe.OTHER_STEEL_MATERIALS.V, u = Z(false), r = Z([]), E = Z({ resizable: true }), y = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), g = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (I, Y) => Y.measureUnit ? !!I : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (I, Y) => A(I) ? I > 0 : true, message: "核算量必须大于0", trigger: "blur" }], projectId: [{ validator: (I, Y) => A(n.order) && A(n.order.projects) && n.noDetail ? !!I : true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, h = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (I, Y) => A(Y.mete) && A(Y.unitPrice) ? +Be(Y.mete * Y.unitPrice, Ze.YUAN) == +I : false, message: "金额有误，请手动修改", trigger: "blur" }] }, T = Ee(() => {
    let I = Object.assign({}, g);
    return n.fillableDetailAmount && (I = Object.assign(I, h)), I;
  }), _ = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: f, cleanUpData: m, wrongCellMask: R } = ui({ rules: T, ditto: _, errorMsg: "请修正【其它钢材清单】中标红的信息" });
  function v(I) {
    return I;
  }
  Ce(() => n.list, (I) => {
    A(n.list) ? r.value = JSON.parse(JSON.stringify(n.list)) : r.value = [], r.value.forEach((Y) => {
      N(Y);
    });
  }, { deep: true, immediate: true });
  function N(I) {
    Ce(() => I.mete, () => {
      P(I.mete, I);
    });
  }
  function P(I, Y, ee) {
    A(Y.unitPrice) && A(I) ? Y.amount = Be(I * Y.unitPrice, Ze.YUAN) : Y.amount = void 0, O(Y, ee || Y);
  }
  function L(I, Y, ee) {
    if (r.value.splice(Y, 1), A(r) && r.value.length > 0) {
      const B = r.value[0];
      r.value[0].projectId = B.projectId && B.projectId !== -1 ? B.projectId : void 0, r.value[0].workshopId = B.workshopId && B.workshopId !== -1 ? B.workshopId : void 0, r.value[0].warehouseId = B.warehouseId && B.warehouseId !== -1 ? B.warehouseId : void 0;
    }
  }
  function O(I, { accountingUnitNet: Y, measurePrecision: ee }) {
    !n.boolPartyA && I.measureUnit && Y && (I.quantity = Be(I.mete * Y, ee));
  }
  function x() {
    if (Ae(r.value)) return ot.error("明细不能为空"), false;
    const I = r.value.filter((ee, B) => (ee.dataIndex = B, true));
    if (Ae(I)) return true;
    const { validResult: Y } = f(I);
    return Y && (m(I), I.forEach((ee) => {
      var B, q;
      r.value[ee.dataIndex].projectId = ee.projectId, r.value[ee.dataIndex].workshopId = ee.workshopId || ((B = ee.workshop) == null ? void 0 : B.id), r.value[ee.dataIndex].warehouseId = ee.warehouseId || ((q = ee.warehouse) == null ? void 0 : q.id), r.value[ee.dataIndex].quantity = ee.measureUnit && A(ee.measurePrecision) ? ee.quantity : void 0;
    })), Y;
  }
  return o({ rowInit: v, rowWatch: N, validate: x, tableList: r }), (I, Y) => {
    const ee = Ve("vxe-column"), B = Ve("vxe-tooltip"), q = Ve("common-input-number"), ae = Mt, j = Ve("common-button"), le = Ve("vxe-table"), oe = _t("empty-text"), ye = oi;
    return qe((w(), Q("div", Qie, [(w(), U(le, { key: `import_${l(c)}`, "cell-class-name": l(R), "column-config": E.value, data: r.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": y.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(ee, { title: "序号", type: "seq", width: "55" }), s(ee, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), s(ee, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: ce }) => [s(B, { content: ce.classifyParentFullName, disabled: !ce.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[oe, ce.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ee, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: ce }) => [s(B, { content: ce.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(ce.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(ee, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: ce }) => [C("span", null, K(ce.measureUnit || "-"), 1)]), _: 1 }), s(ee, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: ce }) => [l(A)(ce.measureUnit) ? (w(), U(q, { key: 0, modelValue: ce.quantity, "onUpdate:modelValue": (se) => ce.quantity = se, controls: false, max: 999999999, min: 0, precision: ce.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Zie, K(ce.quantity), 1))]), _: 1 }), s(ee, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: ce }) => [C("span", null, K(ce.accountingUnit || "-"), 1)]), _: 1 }), s(ee, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: ce }) => [s(q, { modelValue: ce.mete, "onUpdate:modelValue": (se) => ce.mete = se, controls: false, max: 999999999, min: 1e-6, precision: ce.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), e.fillableDetailAmount ? (w(), U(qo, { key: 0, "weight-attribute": "mete" })) : H("", true), s(ee, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: ce }) => [s(ae, { modelValue: ce.color, "onUpdate:modelValue": (se) => ce.color = se, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(ee, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: ce }) => [s(ae, { modelValue: ce.brand, "onUpdate:modelValue": (se) => ce.brand = se, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(go, { list: r.value, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: r.value, showWarehouse: "" }, null, 8, ["list"]), s(ee, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: ce, rowIndex: se }) => [s(j, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (he) => L(ce.sn, se, ce) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[ye, u.value]]);
  };
} }, t4 = ut(Jie, [["__scopeId", "data-v-fae7deb4"]]), Xie = Object.freeze(Object.defineProperty({ __proto__: null, default: t4 }, Symbol.toStringTag, { value: "Module" }));
const $ie = { __name: "aux-mat-table", props: { order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] }, basicClass: { type: Number, default: Ge.MATERIAL.V }, fillableDetailAmount: { type: Boolean, default: false } }, setup(e, { expose: o }) {
  const n = e, c = Z(false), u = Z([]), r = Z({ resizable: true }), E = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: false, threshold: 80 }), M = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (x, I) => I.measureUnit && A(I.measurePrecision) ? !!x : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (x, I) => A(x) ? x > 0 : true, message: "核算量必须大于0", trigger: "blur" }], projectId: [{ validator: (x, I) => A(n.order) && A(n.order.projects) && n.noDetail ? !!x : true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, S = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (x, I) => A(I.mete) && A(I.unitPrice) ? +Be(I.mete * I.unitPrice, Ze.YUAN) == +x : false, message: "金额有误，请手动修改", trigger: "blur" }] }, h = Ee(() => {
    let x = Object.assign({}, M);
    return n.fillableDetailAmount && (x = Object.assign(x, S)), x;
  }), T = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: _, cleanUpData: f, wrongCellMask: m } = ui({ rules: h, ditto: T });
  function R(x) {
    return x;
  }
  Ce(() => n.list, (x) => {
    A(n.list) ? u.value = JSON.parse(JSON.stringify(n.list)) : u.value = [], u.value.forEach((I) => {
      v(I);
    });
  }, { deep: true, immediate: true });
  function v(x) {
    Ce(() => x.mete, () => {
      N(x.mete, x);
    });
  }
  function N(x, I, Y) {
    A(I.unitPrice) && A(x) ? I.amount = Be(x * I.unitPrice, Ze.YUAN) : I.amount = void 0, L(I, Y || I);
  }
  function P(x, I, Y) {
    if (u.value.splice(I, 1), A(u) && u.value.length > 0) {
      const ee = u.value[0];
      u.value[0].projectId = ee.projectId && ee.projectId !== -1 ? ee.projectId : void 0, u.value[0].workshopId = ee.workshopId && ee.workshopId !== -1 ? ee.workshopId : void 0, u.value[0].warehouseId = ee.warehouseId && ee.warehouseId !== -1 ? ee.warehouseId : void 0;
    }
  }
  function L(x, { accountingUnitNet: I, measurePrecision: Y }) {
    !n.boolPartyA && x.measureUnit && I && (x.quantity = Be(x.mete * I, Y));
  }
  function O() {
    if (Ae(u.value)) return ot.error("明细不能为空"), false;
    const x = u.value.filter((Y, ee) => (Y.dataIndex = ee, true)), { validResult: I } = _(x);
    return I && (f(x), x.forEach((Y) => {
      var ee, B;
      u.value[Y.dataIndex].projectId = Y.projectId, u.value[Y.dataIndex].workshopId = Y.workshopId || ((ee = Y.workshop) == null ? void 0 : ee.id), u.value[Y.dataIndex].warehouseId = Y.warehouseId || ((B = Y.warehouse) == null ? void 0 : B.id), u.value[Y.dataIndex].quantity = Y.measureUnit && A(Y.measurePrecision) ? Y.quantity : void 0;
    })), I;
  }
  return o({ rowInit: R, rowWatch: v, validate: O, tableList: u }), (x, I) => {
    const Y = Ve("vxe-column"), ee = Ve("vxe-tooltip"), B = Ve("common-input-number"), q = Mt, ae = Ve("common-button"), j = Ve("vxe-table"), le = _t("empty-text"), oe = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(j, { key: `import_${e.basicClass}`, "cell-class-name": l(m), "column-config": r.value, data: u.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": E.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(Y, { title: "序号", type: "seq", width: "55" }), s(Y, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: ye }) => [s(ee, { content: ye.classifyParentFullName, disabled: !ye.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[le, ye.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(Y, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: ye }) => [s(ee, { content: ye.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(ye.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(Y, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: ye }) => [C("span", null, K(ye.measureUnit || "-"), 1)]), _: 1 }), s(Y, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: ye }) => [l(A)(ye.measureUnit) ? (w(), U(B, { key: 0, modelValue: ye.quantity, "onUpdate:modelValue": (ce) => ye.quantity = ce, controls: false, max: 999999999, min: 0, precision: ye.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : H("", true)]), _: 1 }), s(Y, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: ye }) => [C("span", null, K(ye.accountingUnit || "-"), 1)]), _: 1 }), s(Y, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: ye }) => [s(B, { modelValue: ye.mete, "onUpdate:modelValue": (ce) => ye.mete = ce, controls: false, max: 999999999, min: 1e-6, precision: ye.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), e.fillableDetailAmount ? (w(), U(qo, { key: 0, "weight-attribute": "mete" })) : H("", true), x.showColor ? (w(), U(Y, { key: 1, align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: ye }) => [s(q, { modelValue: ye.color, "onUpdate:modelValue": (ce) => ye.color = ce, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : H("", true), s(Y, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: ye }) => [s(q, { modelValue: ye.brand, "onUpdate:modelValue": (ce) => ye.brand = ce, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(go, { list: u.value, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: u.value, showWarehouse: "" }, null, 8, ["list"]), s(Y, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: ye, rowIndex: ce }) => [s(ae, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (se) => P(ye.sn, ce, ye) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[oe, c.value]])]);
  };
} }, i4 = ut($ie, [["__scopeId", "data-v-67a34918"]]), eae = Object.freeze(Object.defineProperty({ __proto__: null, default: i4 }, Symbol.toStringTag, { value: "Module" })), tae = { class: "detail-import-inbound" }, Su = { __name: "import-review-dialog", props: { modelValue: { type: Boolean, require: true }, basicClass: { type: Number }, list: { type: Array, default: () => [] }, order: { type: Object, default: () => {
} }, fillableDetailAmount: { type: Boolean, default: false } }, emits: ["success", "update:modelValue", "apply"], setup(e, { emit: o }) {
  const n = o, c = e, { visible: u, handleClose: r } = Ta({ emit: n, props: c, showHook: V }), E = Z(), y = Z(false), { maxHeight: b } = Kt({ mainBox: ".detail-import-inbound", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300 }, u);
  function V() {
  }
  const M = Ee(() => {
    switch (c.basicClass) {
      case Pe.STEEL_PLATE.V:
        return X3;
      case Pe.SECTION_STEEL.V:
        return $3;
      case Pe.STEEL_COIL.V:
        return e4;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return t4;
      case Pe.MATERIAL.V:
      case Pe.GAS.V:
      case Pe.OTHER.V:
        return i4;
      default:
        return null;
    }
  });
  async function g() {
    var h;
    y.value = true, ((h = E.value) == null ? void 0 : h.validate()) && (n("success", E.value.tableList), r()), y.value = false;
  }
  return (S, h) => {
    const T = Ve("common-button"), _ = Ve("common-dialog");
    return w(), U(_, { modelValue: l(u), "onUpdate:modelValue": h[0] || (h[0] = (f) => Gt(u) ? u.value = f : null), "before-close": l(r), "show-close": false, "close-on-click-modal": false, top: "5vh", width: "97%", "custom-class": "import-amount-error-fix-dialog", title: "物料明细批量导入" }, { titleRight: p(() => [s(T, { size: "default", type: "warning", onClick: l(r), loading: y.value }, { default: p(() => h[1] || (h[1] = [Te("取消导入")])), _: 1, __: [1] }, 8, ["onClick", "loading"]), s(T, { size: "default", type: "primary", onClick: g, loading: y.value }, { default: p(() => h[2] || (h[2] = [Te("保存")])), _: 1, __: [2] }, 8, ["loading"])]), default: p(() => [C("div", tae, [(w(), U(Ri(M.value), { ref_key: "steelRef", ref: E, "max-height": l(b) - 220, order: e.order, basicClass: e.basicClass, list: c.list, fillableDetailAmount: e.fillableDetailAmount }, null, 8, ["max-height", "order", "basicClass", "list", "fillableDetailAmount"]))])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, iae = Object.freeze(Object.defineProperty({ __proto__: null, default: Su }, Symbol.toStringTag, { value: "Module" }));
const aae = { class: "steel-inbound-application-container" }, lae = { class: "filter-container" }, oae = { class: "filter-left-box" }, nae = { class: "filter-right-box" }, sae = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success", "beginClose"], setup(e, { emit: o }) {
  const n = Ht(), c = o, { priceAbnormal: u, inboundFillWayCfg: r } = aa(), E = Ee(() => r.value.saveInboundState === Sl.MODIFY.V);
  du(), Wa(), Io(), Sr();
  const y = e, b = { supplierId: null, inboundWay: si.ORDINARY_STORAGE.V, purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [] }, V = Z(), M = Z(), g = Z(), S = Z(), h = Z(), T = Z(false), _ = Z({}), f = Z(false), m = Z(), R = Z([]), v = Z(false), N = Z(false), P = Z(false), L = Z([]), O = () => {
    se.value = true, me(I);
  }, { cu: x, form: I, FORM: Y } = Pa({ title: "钢材入库", formStoreKey: "WMS_INBOUND_APPLICATION_STEEL_SELF", permission: ab, useDraftCallback: O, defaultForm: b, clearDraftCallback: be, api: y.edit ? Vu : AX }, g, y.detail), ee = Ee(() => (I == null ? void 0 : I.inboundWay) === si.OPENING_RECEIPT.V), B = { steelPlateList: { K: "steelPlateList", L: "钢板", V: Pe.STEEL_PLATE.V, TABLE: F3, BEGINTABLE: B3 }, sectionSteelList: { K: "sectionSteelList", L: "型材", V: Pe.SECTION_STEEL.V, TABLE: H3, BEGINTABLE: q3 }, steelCoilList: { K: "steelCoilList", L: "钢卷", V: Pe.STEEL_COIL.V, TABLE: G3, BEGINTABLE: Q3 }, otherSteelMaterialList: { K: "otherSteelMaterialList", L: "其它钢材", V: Pe.OTHER_STEEL_MATERIALS.V, TABLE: Z3, BEGINTABLE: J3 } }, q = Ct({ steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null });
  ai();
  const ae = Ee(() => m.value ? { basicClass: B[m.value].V } : {}), j = Ee(() => {
    var Re;
    return m.value ? { id: (Re = h.value) == null ? void 0 : Re.id, basicClass: B[m.value].V } : {};
  }), le = Ee(() => r.value ? !!(r.value.amountFillWay === $l.APPLICATION.V && N.value) : false), oe = Ee(() => !!(m.value && h.value)), ye = Ee(() => {
    var Re;
    return (Re = I.list) == null ? void 0 : Re.filter((fe) => {
      var Ue, Je;
      return (Je = (Ue = x == null ? void 0 : x.submitResult) == null ? void 0 : Ue.data) == null ? void 0 : Je.includes(fe.classifyId);
    });
  });
  function ce(Re) {
    var Ue, Je, Xe, Ye;
    if (ee.value) return (Ue = I[Re]) == null ? void 0 : Ue.length;
    let fe = "";
    switch (Re) {
      case "steelPlateList":
        fe = v.value || N.value ? "steelPlateList" : "originSteelPlateList";
        break;
      case "sectionSteelList":
        fe = v.value || N.value ? "sectionSteelList" : "originSectionSteelList";
        break;
      case "steelCoilList":
        fe = v.value || N.value ? "steelCoilList" : "originSteelCoilList";
        break;
      case "otherSteelMaterialList":
        fe = v.value || N.value ? "otherSteelMaterialList" : "originOtherSteelMaterialList";
        break;
    }
    return v.value || N.value ? ((Je = I[fe]) == null ? void 0 : Je.length) || 0 : ((Ye = (Xe = I[fe]) == null ? void 0 : Xe.filter((Fe) => {
      var et, lt;
      return (lt = (et = I.selectObj) == null ? void 0 : et[Fe.mergeId]) == null ? void 0 : lt.isSelected;
    })) == null ? void 0 : Ye.length) || 0;
  }
  Ee(() => ji(0, Ze.YUAN)), Ee(() => ji(0, 2)), yi("matSpecRef", M);
  const se = Z(false), he = Ee(() => !y.edit && !se.value);
  function be() {
    se.value = false, we();
  }
  const me = (Re) => {
    const fe = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, Ue = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, Je = ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"];
    let Xe = false;
    Je.forEach((Ye) => {
      if (A(Re[Ye])) {
        if (!Xe) {
          Xe = true;
          const Fe = Ce(T, (et) => {
            et && pt(() => {
              m.value = Ye, Fe();
            });
          }, { immediate: true });
        }
        Re[Ye] = Re[Ye].map((Fe) => Ct(Fe)), fe[Ye] = Ce(q, (Fe) => {
          var et;
          Fe[Ye] && (Re[Ye].forEach((lt) => {
            var bt, gt;
            Fe[Ye].rowWatch(lt), !v.value && !N.value && ((gt = (bt = Re.selectObj) == null ? void 0 : bt[lt.mergeId]) != null && gt.isSelected) && Fe[Ye].toggleRowSelection(lt, true);
          }), ((et = h.value) != null && et.id && N.value || v.value) && (Ue[Ye] = Ce(M, () => {
            M.value && (M.value.initSelected(Re[Ye].map((lt) => ({ sn: lt.sn, classifyId: lt.classifyId }))), pt(() => {
              Ue[Ye]();
            }));
          }, { immediate: true })), pt(() => {
            fe[Ye]();
          }));
        }, { immediate: true, deep: true });
      }
    }), Le();
  };
  Ce(() => I.inboundWay, (Re) => {
    Re === si.OPENING_RECEIPT.V && (m.value = "steelPlateList"), I.steelPlateList = [], I.sectionSteelList = [], I.steelCoilList = [], I.otherSteelMaterialList = [], R.value = [], pt(() => {
      Re === si.OPENING_RECEIPT.V ? q.steelPlateList = V.value : q.steelPlateList = null, q.sectionSteelList = null, q.steelCoilList = null, q.otherSteelMaterialList = null;
    });
  });
  let ge = {};
  y.edit ? ge = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : ge = { mainBox: ".steel-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: Le, maxHeight: Ie, maxHeightStyle: Se } = Kt(ge), X = Ee(() => m.value ? ee.value ? B[m.value].BEGINTABLE : B[m.value].TABLE : y.edit ? null : B.steelPlateList.TABLE), $ = Ee(() => m.value ? B[m.value].V !== Pe.OTHER_STEEL_MATERIALS.V ? { amount: [{ validator: (Re, fe) => A(fe.weighingTotalWeight) && A(fe.unitPrice) && A(Re) ? +Be(fe.weighingTotalWeight * fe.unitPrice, Ze.YUAN) == +Re : true, message: "金额有误，请手动修改", trigger: "blur" }] } : { amount: [{ validator: (Re, fe) => A(fe.mete) && A(fe.unitPrice) && A(Re) ? +Be(fe.mete * fe.unitPrice, Ze.YUAN) == +Re : true, message: "金额有误，请手动修改", trigger: "blur" }] } : {});
  Ee(() => {
    const Re = h.value && h.value.weightMeasurementMode !== Wt.THEORY.V, fe = !_.value.steelPlateList || !_.value.sectionSteelList;
    return Re && fe;
  }), Ce(m, (Re) => {
    Re ? (N.value && (R.value = I[Re]), pt(() => {
      q[Re] || (q[Re] = V.value);
    })) : R.value = [];
  }, { immediate: true, deep: true }), Ce(R, (Re) => {
    m.value && N.value && (I[m.value] = Re);
  }), we();
  const { steelDensityCfg: k, loaded: J } = cn();
  yi("steelDensityCfg", k), Y.HOOK.beforeToEdit = async (Re, fe) => {
    var Ue;
    if (y.edit) {
      if (await pt(() => {
        var Je;
        fe.purchaseId = (Je = fe.purchaseOrder) == null ? void 0 : Je.id;
      }), fe.logistics || (fe.logistics = {}), await Xr(fe), fe.basicClass & ct.STEEL.V && A(fe.list) && J) {
        const Je = [];
        let Xe = [];
        const Ye = [];
        if ((Ue = fe.list) == null || Ue.forEach((Fe) => {
          (Fe.basicClass === Pe.STEEL_PLATE.V || Fe.basicClass === Pe.STEEL_COIL.V) && (Fe.basicClass === Pe.STEEL_PLATE.V || Fe.basicClass === Pe.STEEL_COIL.V) && Fe.steelDensity !== k.value[Fe.classifyId] && Je.push({ classifyName: Fe.classifyName, classifyId: Fe.classifyId });
        }), Xe = z(Je, "classifyId"), A(Xe)) {
          Xe.forEach((et) => {
            Ye.push(`当前【${et.classifyName}】物料密度有变，最新密度为【${k.value[et.classifyId]}】`);
          });
          const Fe = Ye.join(`，
`);
          fe.densityData = Xe.map((et) => et.classifyId), zi.confirm(`${Fe}，
是否重新计算总重？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消" }).then(() => {
            fe.densityData = Xe.map((et) => et.classifyId), pt(() => {
              fe.steelPlateList.forEach((et) => {
                fe.densityData.includes(et.classifyId) && (et.weighingTotalWeight = et.theoryTotalWeight);
              }), fe.steelCoilList.forEach((et) => {
                fe.densityData.includes(et.classifyId) && (et.length = et.theoryLength);
              });
            });
          }).catch(() => {
            fe.densityData = [];
          });
        }
      }
      me(fe), fe.originSteelPlateList = fe.steelPlateList, fe.originSectionSteelList = fe.sectionSteelList, fe.originSteelCoilList = fe.steelCoilList, fe.originOtherSteelMaterialList = fe.otherSteelMaterialList, fe.originList = [];
    }
  };
  function z(Re, fe) {
    return Re.filter((Ue, Je, Xe) => Je === Xe.findIndex((Ye) => fe ? Ye[fe] === Ue[fe] : JSON.stringify(Ye) === JSON.stringify(Ue)));
  }
  Y.HOOK.afterSubmit = () => {
    y.edit && c("success"), we();
  };
  function F(Re) {
    if (m.value) {
      const fe = [];
      let Ue = [];
      switch (m.value) {
        case "steelPlateList":
          Ue = I.originSteelPlateList;
          break;
        case "sectionSteelList":
          Ue = I.originSectionSteelList;
          break;
        case "steelCoilList":
          Ue = I.originSteelCoilList;
          break;
        case "otherSteelMaterialList":
          Ue = I.originOtherSteelMaterialList;
          break;
      }
      Ue.forEach((Je) => {
        (!A(Re.classifyId) || Re.classifyId.includes(Je.classifyId)) && (!(Re.thickness && Number(Re.thickness)) || Je.thickness === Number(Re.thickness)) && (!(Re.width && Number(Re.width)) || Je.width === Number(Re.width)) && (!Re.specification || Je.specification.includes(Re.specification)) && (!(Re.length && Number(Re.length)) || Je.length === Number(Re.length)) && (!Re.color || Je.color.includes(Re.color)) && (!Re.brand || Je.brand.includes(Re.brand)) && fe.push(Je);
      }), I[m.value] = fe;
    } else I.steelPlateList = [], I.sectionSteelList = [], I.steelCoilList = [], I.otherSteelMaterialList = [];
  }
  function G() {
    N.value || Object.keys(B).forEach((Re) => {
      var fe;
      if (B[Re].V & ((fe = h.value) == null ? void 0 : fe.basicClass)) {
        const Ue = B[Re].K;
        let Je = [];
        switch (Ue) {
          case "steelPlateList":
            Je = I.originSteelPlateList;
            break;
          case "sectionSteelList":
            Je = I.originSectionSteelList;
            break;
          case "steelCoilList":
            Je = I.originSteelCoilList;
            break;
          case "otherSteelMaterialList":
            Je = I.originOtherSteelMaterialList;
            break;
        }
        I[Ue] = Je, I[Ue].forEach((Xe) => {
          var Ye;
          (Ye = I.selectObj[Xe.mergeId]) != null && Ye.isSelected && I.originList.push(Xe);
        });
      }
    });
  }
  function ie() {
    Object.keys(B).forEach((Re) => {
      var fe;
      if (B[Re].V & ((fe = h.value) == null ? void 0 : fe.basicClass)) {
        const Ue = B[Re].K;
        let Je = [];
        switch (Ue) {
          case "steelPlateList":
            Je = I.steelPlateList;
            break;
          case "sectionSteelList":
            Je = I.sectionSteelList;
            break;
          case "steelCoilList":
            Je = I.steelCoilList;
            break;
          case "otherSteelMaterialList":
            Je = I.otherSteelMaterialList;
            break;
        }
        I[Ue] = Je, I[Ue].forEach((Xe) => {
          I.originList.push(Xe);
        });
      }
    });
  }
  async function ue() {
    var fe;
    return !!await ((fe = V.value) == null ? void 0 : fe.validate());
  }
  async function ne() {
    var fe, Ue;
    if (ee.value) return;
    if ((v.value || !v.value && Ae((fe = h.value) == null ? void 0 : fe.details)) && Ae(I.steelPlateList) && Ae(I.sectionSteelList) && Ae(I.steelCoilList) && Ae(I.otherSteelMaterialList)) return ot.warning("请填写数据"), false;
    I.originList = [], A((Ue = h.value) == null ? void 0 : Ue.details) ? G() : ie();
    const Re = te();
    if (Re) {
      if (!v.value && A(h.value.details) && Ae(I.originList)) return ot.warning("请选择数据"), false;
      let Je = true;
      if (Ae(h.value.details)) {
        const Ye = [];
        if (A(u.value) && u.value.forEach((Fe) => {
          var lt;
          const et = (lt = I.originList) == null ? void 0 : lt.filter((bt) => bt.basicClass === Fe.basicClass);
          A(et) && et.forEach((bt) => {
            Fe.minPrice && bt.unitPrice < Fe.minPrice && Ye.push({ msg: `${Pe.VL[bt.basicClass]} ${bt.serialNumber} ${bt.classifyName}：单价${bt.unitPrice} < 异常配置最小值${Fe.minPrice}` }), Fe.maxPrice && bt.unitPrice > Fe.maxPrice && Ye.push({ msg: `${Pe.VL[bt.basicClass]} ${bt.serialNumber} ${bt.classifyName}：单价${bt.unitPrice} > 异常配置最大值${Fe.maxPrice}` });
          });
        }), A(Ye)) {
          const Fe = Ye.map((et) => `<div>${et.msg}<div>`).join("");
          await zi.confirm("<div>单价异常明细如下,请确认！<div>" + Fe, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
            Je = true;
          }).catch((et) => {
            Je = false;
          });
        }
      }
      if (!Je) return false;
      const Xe = [];
      I.originList.forEach((Ye) => {
        var Fe;
        if (Ye.basicClass & Pe.STEEL_COIL.V && (Ye.quantity = Ye.length), Ye.basicClass & Pe.OTHER_STEEL_MATERIALS.V && (Ye.weighingTotalWeight = Ye.mete), (Fe = Ye.applyPurchase) != null && Fe.length) {
          let et = Ye.weighingTotalWeight;
          Ye.applyPurchase.forEach((lt, bt) => {
            var gt, qt, kt, Ii;
            if (Ye.basicClass & Pe.OTHER_STEEL_MATERIALS.V) {
              if (lt.quantity || lt.mete) {
                let ra = 0;
                bt !== Ye.applyPurchase.length - 1 && et !== 0 ? (ra = lt.mete, et -= ra) : ra += et;
                const wa = ra;
                Xe.push({ ...Ye, ...lt, serialNumber: Ye.serialNumber, quantity: lt.quantity, projectId: lt.projectId || ((gt = lt.project) == null ? void 0 : gt.id), uid: Tt(), mete: wa, weight: wa, weighingTotalWeight: wa, amount: A(lt.unitPrice) ? Be(wa * lt.unitPrice, Ze.YUAN) : A(Ye.unitPrice) ? Be(wa * Ye.unitPrice, Ze.YUAN) : void 0, applyPurchaseId: lt.applyPurchaseId, purchaseDetailId: lt.purchaseDetailId, purchaseProjectDisabled: lt.applyPurchaseId ? !((qt = lt.project) != null && qt.id) : false });
              }
            } else if (Ye.basicClass & Pe.STEEL_COIL.V && (lt.quantity = lt.length), lt.quantity) {
              let ra = 0;
              Ye.basicClass & Pe.SECTION_STEEL.V || Ye.basicClass & Pe.STEEL_PLATE.V ? ra = lt.weighingTotalWeight : bt !== Ye.applyPurchase.length - 1 && et !== 0 ? (ra = lt.weighingTotalWeight, et -= ra) : ra += et;
              const wa = ra;
              Xe.push({ ...Ye, ...lt, serialNumber: Ye.serialNumber, quantity: lt.quantity, projectId: lt.projectId || ((kt = lt.project) == null ? void 0 : kt.id), uid: Tt(), mete: wa, weight: wa, weighingTotalWeight: wa, amount: A(lt.unitPrice) ? Be(wa * lt.unitPrice, Ze.YUAN) : A(Ye.unitPrice) ? Be(wa * Ye.unitPrice, Ze.YUAN) : void 0, applyPurchaseId: lt.applyPurchaseId, purchaseDetailId: lt.purchaseDetailId, purchaseProjectDisabled: lt.applyPurchaseId ? !((Ii = lt.project) != null && Ii.id) : false });
            }
          });
        } else Xe.push({ ...Ye, uid: Tt(), mete: Ye.weighingTotalWeight, weight: Ye.weighingTotalWeight });
      }), I.list = Xe;
    }
    return A(ye.value) ? (ot.error("请先删除标红数据并重新添加"), false) : Re;
  }
  function te() {
    return Object.keys(q).every((Re) => q[Re] ? q[Re].validate() : true);
  }
  function de(Re) {
    return V.value.rowInit(Re);
  }
  async function pe(Re) {
    var fe;
    we(), h.value = Re, x.props.order = Re, v.value = (Re == null ? void 0 : Re.supplyType) === Ni.PARTY_A.V, N.value = Ae(Re == null ? void 0 : Re.details), he.value && (I.list = [], I.originSteelPlateList = [], I.originSectionSteelList = [], I.originSteelCoilList = [], I.originOtherSteelMaterialList = [], I.originList = []), Object.keys(B).forEach((Ue) => {
      if (he.value && (I[Ue] = []), B[Ue].V & (Re == null ? void 0 : Re.basicClass) ? (m.value || (m.value = B[Ue].K), _.value[Ue] = false) : I[Ue] = [], he.value && (Re != null && Re.id && N.value || v.value)) {
        const Je = Ce(M, () => {
          M.value && (M.value.clearByBasicClass(B[Ue].V), pt(() => {
            Je();
          }));
        }, { immediate: true });
      }
    }), Re ? (pt(() => {
      q.steelPlateList = null, q.sectionSteelList = null, q.steelCoilList = null, q.otherSteelMaterialList = null, q[m.value] = V.value, v.value && he.value && me(I);
    }), !v.value && ((fe = Re == null ? void 0 : Re.details) != null && fe.length) && (I.list = Re.details || [], await Xr(I), I.originSteelPlateList = I.steelPlateList, I.originSectionSteelList = I.sectionSteelList, I.originSteelCoilList = I.steelCoilList, I.originOtherSteelMaterialList = I.otherSteelMaterialList, I.originList = [], me(I))) : pt(() => {
      q.steelPlateList = null, q.sectionSteelList = null, q.steelCoilList = null, q.otherSteelMaterialList = null;
    }), T.value = true;
  }
  function re() {
    var Re;
    if (A(ye.value) && A((Re = x == null ? void 0 : x.submitResult) == null ? void 0 : Re.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    f.value = true;
  }
  async function we() {
    _.value = { steelPlateList: true, sectionSteelList: true, steelCoilList: true, otherSteelMaterialList: true }, m.value = void 0, T.value = false, v.value = false, await n.dispatch("wms/fetchSteelDensityCfg");
  }
  function Ke(Re) {
    var Xe;
    const fe = m.value, Ue = I[fe].length;
    I[fe].push.apply(I[fe], Re);
    const Je = I[fe].length;
    for (let Ye = Ue; Ye < Je; Ye++) le.value, A((Xe = I[fe][Ye]) == null ? void 0 : Xe.amount) && (I[fe][Ye].amount = Be(I[fe][Ye].amount, Ze.YUAN)), q[fe] = V.value, q[fe].rowWatch(I[fe][Ye]);
  }
  x.props.import = (Re) => {
    var Ye;
    if (ee.value) return Ke(Re);
    const fe = m.value, Ue = I[fe].length;
    Re.map((Fe, et) => {
      var lt, bt, gt;
      Fe.rowIndex = (I[fe].length || 0) + et, Fe.projectId = Fe.projectId || (et > 0 || Ue > 0 ? -1 : void 0), Fe.workshopId = Fe.workshopId || (et > 0 || Ue > 0 ? -1 : void 0), Fe.warehouseId = Fe.warehouseId || (et > 0 || Ue > 0 ? -1 : void 0), Fe.weightMeasurementMode = (lt = h.value) != null && lt.weightMeasurementMode ? ((bt = h.value) == null ? void 0 : bt.weightMeasurementMode) === Wt.MIXTURE.V ? Wt.THEORY.V : (gt = h.value) == null ? void 0 : gt.weightMeasurementMode : void 0;
    }), I[fe].push.apply(I[fe], Re);
    const Je = I[fe].length;
    for (let Fe = Ue; Fe < Je; Fe++) le.value || (I[fe][Fe].amount = void 0, I[fe][Fe].unitPrice = void 0), A((Ye = I[fe][Fe]) == null ? void 0 : Ye.amount) && (I[fe][Fe].amount = Be(I[fe][Fe].amount, Ze.YUAN)), q[fe].rowWatch(I[fe][Fe]);
    const Xe = Ce(M, () => {
      M.value && (M.value.initSelected(Re.map((Fe) => ({ sn: Fe.sn, classifyId: Fe.classifyId }))), pt(() => {
        Xe();
      }));
    }, { immediate: true });
  };
  async function Me() {
    try {
      const Re = en.cloneDeep(I[m.value]);
      if (Ae(Re)) return;
      Re.forEach((fe) => {
        fe.id && (fe != null && fe.weighingTotalWeight) ? fe.mete = fe.weighingTotalWeight : fe.mete = fe.mete || fe.weighingTotalWeight, fe.amount = Number(fe.amount), fe.amountExcludingVatFreight = Number(fe.amountExcludingVatFreight), fe.materialIsWholeName && (fe.materialIsWhole = fe.materialIsWholeName === "余料" ? 2 : 1), fe.unitPrice = fe.amount / fe.mete, fe.unitPriceExcludingVatFreight = fe.amountExcludingVatFreight / fe.mete, m.value === "sectionSteelList" && (fe.weight = fe.mete, fe.specification = fe.sectionSteelSpec + " * " + fe.doNotSectionSteelSpec), m.value === "steelCoilList" && (fe.quantity = fe.length);
      }), I.list = await Ut(Re, { basicClass: B[m.value].V, toSmallest: true, toNum: true }, { amount: ["unitPrice", "unitPriceExcludingVatFreight"] }), await NX(I), x.submitSuccessNotify(), x.resetForm(), ze();
    } catch (Re) {
      throw console.log(Re, "steelInboundApplicationBegin"), new Error(Re);
    }
  }
  function Ne() {
    c("beginClose");
  }
  const He = Z();
  function ze() {
    He.value.handleClose();
  }
  x.props.detailImport = (Re) => {
    var et;
    const fe = m.value, Ue = [], Je = {};
    Re.forEach((lt, bt) => {
      lt.index = bt + 1, Ue.includes(lt.uniqueIdentification) || (Ue.push(lt.uniqueIdentification), Je[lt.uniqueIdentification] = []);
    });
    let Xe = [];
    switch (fe) {
      case "steelPlateList":
        Xe = I.originSteelPlateList;
        break;
      case "sectionSteelList":
        Xe = I.originSectionSteelList;
        break;
      case "steelCoilList":
        Xe = I.originSteelCoilList;
        break;
      case "otherSteelMaterialList":
        Xe = I.originOtherSteelMaterialList;
        break;
    }
    const Ye = [], Fe = [];
    for (let lt = 0; lt < Ue.length; lt++) if (Xe.findIndex((bt) => bt.uniqueIdentification === Ue[lt]) > -1) {
      const bt = Re.filter((qt) => qt.uniqueIdentification === Ue[lt]), gt = Xe.find((qt) => qt.uniqueIdentification === Ue[lt]) || {};
      if (A(bt)) {
        const qt = [];
        bt.forEach((kt, Ii) => {
          if (gt.classifyId === kt.classifyId && (!gt.specification || gt.specification === kt.specification) && (!(kt.basicClass & Pe.STEEL_PLATE.V) || gt.thickness === kt.thickness)) qt.push({ originData: gt, ...kt });
          else {
            const ra = [];
            gt.classifyId !== kt.classifyId && ra.push("物料种类" + kt.classifyName), gt.specification && gt.specification !== kt.specification && ra.push("规格" + kt.specification), kt.basicClass & Pe.STEEL_PLATE.V && gt.thickness !== kt.thickness && ra.push("厚度" + kt.thickness), kt.errorMsg = ra.join("、"), Fe.push(kt);
          }
        }), Je[Ue[lt]] = qt;
      }
    } else Ye.push(Ue[lt]);
    if (A(Ye)) {
      ot.error(`采购订单不存在${Ye.map((lt) => `“${lt}”`).join("、")}${Ye.length > 1 ? "等" : ""}唯一标识`);
      return;
    }
    if (A(Fe)) {
      const lt = [];
      Fe.forEach((gt) => {
        const qt = "序号" + gt.index + "唯一标识" + gt.uniqueIdentification + " " + gt.errorMsg + ` 有误
`;
        lt.push({ errorMsg: qt });
      });
      const bt = lt.map((gt) => `<div>${gt.errorMsg}<div>`).join("");
      ot({ message: bt, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 });
      return;
    }
    L.value = [];
    for (const lt in Je) (et = Je[lt]) == null || et.forEach((bt) => {
      L.value.push(bt);
    });
    L.value.forEach((lt) => {
      lt.quantity || (lt.quantity = void 0);
    }), L.value.map((lt, bt) => {
      lt.projectId = lt.projectId || (bt > 0 ? -1 : void 0), lt.workshopId = lt.workshopId || (bt > 0 ? -1 : void 0), lt.warehouseId = lt.warehouseId || (bt > 0 ? -1 : void 0);
    }), P.value = true;
  };
  function Oe(Re) {
    const fe = m.value;
    let Ue = [];
    switch (fe) {
      case "steelPlateList":
        Ue = I.originSteelPlateList;
        break;
      case "sectionSteelList":
        Ue = I.originSectionSteelList;
        break;
      case "steelCoilList":
        Ue = I.originSteelCoilList;
        break;
      case "otherSteelMaterialList":
        Ue = I.originOtherSteelMaterialList;
        break;
    }
    Re.forEach((Je) => {
      const Xe = Ue.find((Ye) => Ye.uniqueIdentification === Je.uniqueIdentification);
      if (A(Xe)) {
        const Ye = Xe.applyPurchase[0];
        A(Ye) ? ((fe === "steelPlateList" || fe === "sectionSteelList") && !Ye.theoryTotalWeight || fe === "steelCoilList" && !Ye.weighingTotalWeight || fe === "otherSteelMaterialList" && !Ye.mete) && (Xe.applyPurchase = []) : Xe.applyPurchase = [], Xe.applyPurchase.length > 0 && (Je.isBranch = true), Xe.applyPurchase.push(Je), I.selectObj[Xe.mergeId].isSelected = true;
      }
    }), Ue.forEach((Je) => {
      var Xe, Ye;
      fe === "otherSteelMaterialList" ? Je.mete = ((Xe = Je == null ? void 0 : Je.applyPurchase) == null ? void 0 : Xe.reduce((Fe, et) => Fe + (et.mete || 0), 0)) || 0 : Je.weighingTotalWeight = (Ye = Je == null ? void 0 : Je.applyPurchase) == null ? void 0 : Ye.reduce((Fe, et) => Fe + (et.weighingTotalWeight || 0), 0);
    });
  }
  return (Re, fe) => {
    var lt, bt, gt, qt, kt;
    const Ue = Is, Je = Ve("common-button"), Xe = jt, Ye = Li, Fe = Ve("common-drawer"), et = _t("permission");
    return qe((w(), Q("div", aae, [s(Ar, { "basic-class": l(sl), "begin-permission": l(Id), "begin-validate": ue, "contract-unit": (lt = h.value) == null ? void 0 : lt.meteUnit, "contract-value": (bt = h.value) == null ? void 0 : bt.mete, "current-basic-class": (gt = B[m.value]) == null ? void 0 : gt.V, edit: y.edit, importAmountRules: $.value, "inbound-unit": l(ei).weight.unit, "inbound-value": (qt = h.value) == null ? void 0 : qt.inboundTotalMete, showContractTotal: !v.value && !!l(I).purchaseId, showInboundTotal: !v.value && !!l(I).purchaseId, showTotal: false, showTotalAmount: false, "total-name": v.value ? "总量合计" : "本次实收", validate: ne, unit: "t", onPurchaseOrderChange: pe }, { beginPreview: p((Ii) => {
      var ra;
      return [s(wu, { ref_key: "beginConfirmRef", ref: He, "class-name": (ra = B[m.value]) == null ? void 0 : ra.L, submit: Me, visible: Ii.visible, onSuccess: Ne, "onUpdate:visible": (wa) => Ii.onUpdateVisible(wa) }, { default: p(() => [(w(), U(Ri(X.value), { ref_key: "steelRef", ref: V, "bool-party-a": v.value, fillableAmount: le.value, isEdit: false, "max-height": l(Ie) + 120, noDetail: N.value, order: h.value, style: ri(l(Se)) }, null, 8, ["bool-party-a", "fillableAmount", "max-height", "noDetail", "order", "style"]))]), _: 2 }, 1032, ["class-name", "visible", "onUpdate:visible"])];
    }), default: p(() => {
      var Ii, ra, wa, Eo;
      return [C("div", lae, [C("div", oae, [s(l(Ls), { modelValue: m.value, "onUpdate:modelValue": fe[0] || (fe[0] = (da) => m.value = da), class: "filter-item", size: "default" }, { default: p(() => [(w(), Q(Qe, null, ki(B, (da) => s(Ue, { key: da.K, disabled: ee.value ? !!y.edit : _.value[da.K], value: da.K }, { default: p(() => [Te(K(da.L) + K(ce(da.K) ? `(${ce(da.K)})` : ""), 1)]), _: 2 }, 1032, ["disabled", "value"])), 64))]), _: 1 }, 8, ["modelValue"]), l(I).inboundWay === l(si).ORDINARY_STORAGE.V && !N.value && l(A)(m.value) ? (w(), U(bu, { key: 0, currentBasicClass: (Ii = B[m.value]) == null ? void 0 : Ii.V, onBlurQuery: F, onResetQuery: G }, null, 8, ["currentBasicClass"])) : H("", true)]), C("div", nae, [l(Ai)(l(Id).download) && l(I).inboundWay === l(si).OPENING_RECEIPT.V && m.value ? (w(), U(ia, { key: 0, fn: l(is), params: { basicClass: B[m.value].V, boolPartyA: false }, class: "filter-item" }, { default: p(() => [Te(K(B[m.value].L) + "期初入库模版下载 ", 1)]), _: 1 }, 8, ["fn", "params"])) : H("", true), l(I).inboundWay === l(si).ORDINARY_STORAGE.V && (v.value || !v.value && l(Ae)((ra = h.value) == null ? void 0 : ra.details)) ? (w(), U(ia, { key: 1, disabled: !m.value, fn: l(gd), params: ae.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(m.value ? B[m.value].L : "") + "入库模板下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), !v.value && l(A)((wa = h.value) == null ? void 0 : wa.details) && l(I).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(ia, { key: 2, disabled: !m.value, fn: l(Ed), params: j.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(m.value ? B[m.value].L : "") + "采购明细下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), ee.value && !y.edit ? (w(), Q(Qe, { key: 3 }, [l(Ai)((Eo = l(Id)) == null ? void 0 : Eo.import) ? (w(), U(Je, { key: 0, class: "filter-item", type: "success", onClick: re }, { default: p(() => fe[3] || (fe[3] = [Te(" 添加物料 ")])), _: 1, __: [3] })) : H("", true)], 64)) : H("", true), ee.value ? H("", true) : (w(), U(Xe, { key: 4, disabled: oe.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => {
        var da;
        return [C("span", null, [v.value || !v.value && l(Ae)((da = h.value) == null ? void 0 : da.details) ? (w(), U(Je, { key: 0, disabled: ee.value ? false : !oe.value, class: "filter-item", type: "success", onClick: re }, { default: p(() => fe[4] || (fe[4] = [Te(" 添加物料 ")])), _: 1, __: [4] }, 8, ["disabled"])) : H("", true)])];
      }), _: 1 }, 8, ["disabled"]))])]), s(Ye, { ref_key: "formRef", ref: g, model: l(I) }, { default: p(() => [(w(), U(Ri(X.value), { ref_key: "steelRef", ref: V, "bool-party-a": v.value, fillableAmount: le.value, "max-height": l(Ie), noDetail: N.value, order: h.value, style: ri(l(Se)) }, null, 8, ["bool-party-a", "fillableAmount", "max-height", "noDetail", "order", "style"]))]), _: 1 }, 8, ["model"])];
    }), _: 1 }, 8, ["basic-class", "begin-permission", "contract-unit", "contract-value", "current-basic-class", "edit", "importAmountRules", "inbound-unit", "inbound-value", "showContractTotal", "showInboundTotal", "total-name"]), s(Fe, { key: "ordinary", ref_key: "drawerRef", ref: S, modelValue: f.value, "onUpdate:modelValue": fe[1] || (fe[1] = (Ii) => f.value = Ii), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => [ee.value || oe.value ? (w(), U(to, { key: l(I).inboundWay, ref_key: "matSpecRef", ref: M, "basic-class": B[m.value].V, "max-height": l(Ie), "model-value": l(I)[m.value], "row-init-fn": de, "table-width": 350, visible: f.value, "auto-selected": "", "expand-query": "" }, null, 8, ["basic-class", "max-height", "model-value", "visible"])) : H("", true)]), _: 1 }, 8, ["modelValue"]), s(Su, { modelValue: P.value, "onUpdate:modelValue": fe[2] || (fe[2] = (Ii) => P.value = Ii), "basic-class": (kt = B[m.value]) == null ? void 0 : kt.V, list: L.value, order: h.value, onSuccess: Oe, fillableDetailAmount: E.value }, null, 8, ["modelValue", "basic-class", "list", "order", "fillableDetailAmount"])])), [[et, l(ab)]]);
  };
} }, wm = ut(sae, [["__scopeId", "data-v-f22d9713"]]), rae = Object.freeze(Object.defineProperty({ __proto__: null, default: wm }, Symbol.toStringTag, { value: "Module" }));
const uae = { style: { padding: "20px" } }, cae = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, dae = { key: 1 }, mae = { key: 1 }, pae = { key: 0 }, hae = { class: "color-green" }, fae = { class: "color-green" }, gae = { key: 1 }, Eae = { key: 1 }, yae = { key: 1 }, Tae = { __name: "aux-mat-table", props: { boolPartyA: { type: Boolean, default: false }, boolApplyPurchase: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, basicClass: { type: [String, Number], default: Ge.MATERIAL.V }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 } }, setup(e, { expose: o }) {
  const n = e, { baseUnit: c } = ai(n.basicClass), { purchaseCfg: u } = aa(), r = ft("matSpecRef"), { cu: E, form: y } = Wi(), b = Z(), V = Z(false), M = Z({ resizable: true }), g = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: false, threshold: 80 }), S = (he, be) => (be.measureUnit && A(be.measurePrecision) && A(be.quantity) && (be.quantity = Be(be.quantity, be.measurePrecision)), be.measureUnit && A(be.measurePrecision) ? !!be.quantity : true), h = (he, be) => n.noDetail ? !!he : true, _ = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: S, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (he, be) => (be.accountingUnit && A(be.accountingPrecision) && A(be.mete) && (be.mete = Be(be.mete, be.accountingPrecision)), !!be.mete), message: "核算量必须大于0", trigger: "blur" }], workshopId: [{ validator: h, message: "请选择仓库", trigger: "change" }], warehouseId: [{ validator: h, message: "请选择存储位置", trigger: "change" }] }, m = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (he, be) => A(be.mete) && A(be.unitPrice) ? +Be(be.mete * be.unitPrice, Ze.YUAN) == +he : false, message: "金额有误，请手动修改", trigger: "blur" }] }, R = Ee(() => {
    let he = Object.assign({}, _);
    return !n.boolPartyA && n.fillableAmount && (he = Object.assign(he, m)), he;
  }), v = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: N, cleanUpData: P, wrongCellMask: L } = ui({ rules: R, ditto: v }), { handleOverQuantity: O, handleOverMete: x } = Us({ meteField: "mete" });
  function I(he = false) {
  }
  function Y({ row: he, rowIndex: be }) {
    var me, ge;
    if ((ge = (me = E == null ? void 0 : E.submitResult) == null ? void 0 : me.data) != null && ge.includes(he.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ee(he) {
    const be = Ct({ uid: Tt(), sn: he.sn, specificationLabels: he.specificationLabels, classifySerialNumber: he.classify.serialNumber, serialNumber: he.serialNumber, classifyId: he.classify.id, classifyFullPathId: he.classify.fullPathId, classifyFullName: he.classify.fullName, classifyName: he.classify.name, classifyParentFullName: he.classify.parentFullName, basicClass: he.classify.basicClass, specification: he.spec, specificationMap: he.specKV, measureUnit: he.classify.measureUnit, accountingUnit: he.classify.accountingUnit, accountingPrecision: he.classify.accountingPrecision, measurePrecision: he.classify.measurePrecision, outboundUnitType: he.classify.outboundUnitType, unitNet: he.unitNet, accountingUnitNet: he.accountingUnitNet, mete: void 0, quantity: void 0, projectId: y.auxMatList.length > 0 ? -1 : void 0, workshopId: y.auxMatList.length > 0 ? -1 : void 0, warehouseId: y.auxMatList.length > 0 ? -1 : void 0, rowIndex: y.auxMatList.length });
    return !n.boolPartyA && n.fillableAmount && (be.unitPrice = void 0, be.amount = void 0), be;
  }
  function B(he) {
    Ce([() => he.boolApplyPurchase, () => he == null ? void 0 : he.applyPurchase], () => {
      var be, me;
      he.boolApplyPurchase && (he.quantity = (be = he == null ? void 0 : he.applyPurchase) == null ? void 0 : be.reduce((ge, Le) => ge + (Le.quantity || 0), 0), he.mete = (me = he == null ? void 0 : he.applyPurchase) == null ? void 0 : me.reduce((ge, Le) => ge + (Le.mete || 0), 0));
    }, { deep: true }), Ce(() => he, () => {
      var be, me, ge;
      if (!n.boolPartyA && !n.noDetail && ((me = (be = y.selectObj) == null ? void 0 : be[he.mergeId]) != null && me.isSelected)) {
        const Le = (ge = y.selectObj[he.mergeId]) == null ? void 0 : ge.isSelected;
        y.selectObj[he.mergeId] = { ...y.selectObj[he.mergeId], ...he, isSelected: Le };
      }
    }, { deep: true }), Ce(() => he.mete, () => {
      q(he.mete, he);
    });
  }
  function q(he, be, me) {
    A(be.unitPrice) && A(he) ? be.amount = Be(he * be.unitPrice, Ze.YUAN) : be.amount = void 0, oe(be, me || be);
  }
  function ae(he, be, me) {
    var ge, Le, Ie, Se;
    if ((Le = (ge = E == null ? void 0 : E.submitResult) == null ? void 0 : ge.data) != null && Le.includes(me.classifyId)) {
      const X = (Ie = E == null ? void 0 : E.submitResult) == null ? void 0 : Ie.data.findIndex((k) => k === me.classifyId);
      y.auxMatList.filter((k) => k.classifyId === me.classifyId).length === 1 && ((Se = E == null ? void 0 : E.submitResult) == null || Se.data.splice(X, 1));
    }
    if (r.value ? r.value.delListItem(he, be) : y.auxMatList.splice(be, 1), A(y.auxMatList) && y.auxMatList.length > 0) {
      const X = y.auxMatList[0];
      y.auxMatList[0].projectId = X.projectId && X.projectId !== -1 ? X.projectId : void 0, y.auxMatList[0].workshopId = X.workshopId && X.workshopId !== -1 ? X.workshopId : void 0, y.auxMatList[0].warehouseId = X.warehouseId && X.warehouseId !== -1 ? X.warehouseId : void 0;
    }
  }
  function j(he, be) {
    var Le;
    const me = JSON.parse(JSON.stringify(he)), ge = Ct({ uid: Tt(), sn: he.sn, specificationLabels: me.specificationLabels, classifySerialNumber: me.classifySerialNumber, serialNumber: me.serialNumber, classifyId: me.classifyId, classifyFullPathId: me.classifyFullPathId, classifyFullName: me.classifyFullName, classifyName: me.classifyName, classifyParentFullName: me.classifyParentFullName, basicClass: me.basicClass, specification: me.specification, model: me.model, specificationMap: me.specificationMap, measureUnit: me.measureUnit, accountingUnit: me.accountingUnit, accountingPrecision: me.accountingPrecision, measurePrecision: me.measurePrecision, outboundUnitType: me.outboundUnitType, unitNet: me.unitNet, accountingUnitNet: me.accountingUnitNet, mete: me.mete, quantity: me.quantity, projectId: me.projectId, workshopId: me.workshopId, warehouseId: me.warehouseId, color: me.color, rowIndex: y.auxMatList.length, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : me.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : me.amount });
    y.auxMatList.push(ge), B(ge), (Le = r.value) == null || Le.initSelected([ge]);
  }
  function le(he, { unitNet: be, accountingPrecision: me }) {
    !n.boolPartyA && be && (he.mete = Be(he.quantity * be, me));
  }
  function oe(he, { accountingUnitNet: be, measurePrecision: me }) {
    !n.boolPartyA && he.measureUnit && be && (he.quantity = Be(he.mete * be, me));
  }
  function ye() {
    const he = y.auxMatList.filter((me, ge) => {
      var Le;
      return me.dataIndex = ge, !!(n.boolPartyA || n.noDetail || (Le = y.selectObj[me.mergeId]) != null && Le.isSelected);
    }), { validResult: be } = N(he);
    return be && (P(he), he.forEach((me) => {
      var ge, Le;
      y.auxMatList[me.dataIndex].projectId = me.projectId, y.auxMatList[me.dataIndex].workshopId = me.workshopId || ((ge = me.workshop) == null ? void 0 : ge.id), y.auxMatList[me.dataIndex].warehouseId = me.warehouseId || ((Le = me.warehouse) == null ? void 0 : Le.id), y.auxMatList[me.dataIndex].quantity = me.measureUnit && A(me.measurePrecision) ? me.quantity : void 0;
    })), be;
  }
  function ce(he, be) {
  }
  Ce(() => y.auxMatList, (he) => {
    n.noDetail && b.value && b.value.updateFooter();
  }, { deep: true, immediate: true });
  function se(he) {
    var be;
    return [(be = he.columns) == null ? void 0 : be.map((me, ge) => {
      if (ge === 0) return "合计";
      if (me.property === "amount") {
        const Le = he.data.reduce((Ie, Se) => Ie + (Number(Se.amount) || 0), 0);
        return Mi(Le || 0);
      }
      return null;
    })];
  }
  return o({ rowInit: ee, toggleRowSelection: ce, setSelect: I, rowWatch: B, validate: ye }), (he, be) => {
    const me = Mt, ge = Ve("vxe-column"), Le = Ve("vxe-tooltip"), Ie = Ve("common-input-number"), Se = jt, X = vt, $ = Ve("common-button"), k = Ve("vxe-table"), J = _t("empty-text"), z = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(k, { key: `inbound_${e.basicClass}`, ref_key: "tableRef", ref: b, "cell-class-name": l(L), columnConfig: M.value, data: l(y).auxMatList, "empty-text": "暂无数据", "footer-method": se, "max-height": e.maxHeight, "row-style": Y, border: "", "scroll-y": g.value, class: "myTable-style", "show-footer": "", "show-overflow": "tooltip" }, { default: p(() => [s(ge, { type: "expand", width: "60" }, { content: p(({ row: F }) => [C("div", uae, [s(me, { modelValue: F.remark, "onUpdate:modelValue": (G) => F.remark = G, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(F.inboundList) ? (w(), Q("div", cae, [s(l(al), { "basic-class": e.basicClass, list: F.inboundList, material: F, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(ge, { title: "序号", type: "seq", width: "55" }), s(ge, { align: "center", field: "serialNumber", title: "编号", width: "100" }), s(ge, { align: "center", field: "classifyName", "min-width": "120", title: "物料种类" }, { default: p(({ row: F }) => [s(Le, { content: F.classifyParentFullName, disabled: !F.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[J, F.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ge, { align: "center", field: "specification", "min-width": "100px", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: F }) => [s(Le, { content: F.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(F.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(ge, { align: "center", field: "measureUnit", title: "计量单位", width: "80px" }, { default: p(({ row: F }) => [C("span", null, K(F.measureUnit || "-"), 1)]), _: 1 }), n.boolPartyA || n.noDetail ? (w(), Q(Qe, { key: 0 }, [s(ge, { key: "quantity", align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: F }) => [F.measureUnit && l(A)(F.measurePrecision) ? (w(), U(Ie, { key: 0, modelValue: F.quantity, "onUpdate:modelValue": (G) => F.quantity = G, controls: false, max: 999999999, min: 0, precision: F.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : qe((w(), Q("span", dae, null, 512)), [[J]])]), _: 1 }), s(ge, { key: "accountingUnit", align: "center", field: "accountingUnit", title: "核算单位", width: "80px" }, { default: p(({ row: F }) => [C("span", null, K(F.accountingUnit || "-"), 1)]), _: 1 }), s(ge, { key: "mete", align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: F }) => [s(Ie, { modelValue: F.mete, "onUpdate:modelValue": (G) => F.mete = G, controls: false, max: 999999999, min: 1e-6, precision: F.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" }, onChange: (G) => q(F.mete, F) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])]), _: 1 }), !n.boolPartyA && e.fillableAmount && e.noDetail ? (w(), U(qo, { key: 0, "weight-attribute": "mete" })) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [s(ge, { title: "关联项目", align: "right", field: "projects", "min-width": "100px" }, { default: p(({ row: F }) => [l(A)(F.projects) ? (w(true), Q(Qe, { key: 0 }, ki(F.projects, (G, ie) => {
      var ue;
      return w(), Q("span", { key: ie }, K(l(di)(G)) + " " + K(ie + 1 === ((ue = F.projects) == null ? void 0 : ue.length) ? "" : "、"), 1);
    }), 128)) : (w(), Q("span", mae, "-"))]), _: 1 }), s(ge, { key: "purchaseQuantity", title: "采购数量", align: "right", field: "purchaseQuantity", "min-width": "100px" }, { default: p(({ row: F }) => [F.measureUnit ? (w(), Q("span", pae, [s(Le, { content: "已入库数量", placement: "top" }, { default: p(() => [C("span", hae, K(F.inboundQuantity), 1)]), _: 2 }, 1024), Te(" / " + K(F.purchaseQuantity), 1)])) : H("", true)]), _: 1 }), s(ge, { key: "accountingUnit", align: "center", field: "accountingUnit", title: "核算单位", width: "80px" }, { default: p(({ row: F }) => [C("span", null, K(F.accountingUnit || "-"), 1)]), _: 1 }), s(ge, { key: "purchaseMete", title: "采购量", align: "right", field: "purchaseMete", "min-width": "100px" }, { default: p(({ row: F }) => [C("span", null, [s(Se, { content: "已入库量", effect: "dark", placement: "top" }, { default: p(() => [C("span", fae, K(F.inboundMete), 1)]), _: 2 }, 1024), Te(" / " + K(F.purchaseMete), 1)])]), _: 1 })], 64)), s(ge, { key: "color", align: "center", field: "color", "min-width": "100px", title: "颜色" }, { default: p(({ row: F }) => [n.boolPartyA || n.noDetail ? (w(), U(me, { key: 0, modelValue: F.color, "onUpdate:modelValue": (G) => F.color = G, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", gae, [Te(K(F.color), 1)])), [[J]])]), _: 1 }), s(ge, { key: "brand", align: "center", field: "brand", "min-width": "100px", title: "品牌" }, { default: p(({ row: F }) => [n.boolPartyA || n.noDetail ? (w(), U(me, { key: 0, modelValue: F.brand, "onUpdate:modelValue": (G) => F.brand = G, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : qe((w(), Q("span", Eae, [Te(K(F.brand), 1)])), [[J]])]), _: 1 }), !n.boolPartyA && !n.noDetail ? (w(), Q(Qe, { key: 2 }, [s(ge, { key: "realQuantity", align: "center", field: "quantity", "min-width": "120px", title: "本次实收数" }, { default: p(({ row: F }) => [C("span", null, K(F.quantity || "-"), 1)]), _: 1 }), s(ge, { key: "realMete", align: "center", field: "mete", "min-width": "120px", title: "本次实收量" }, { default: p(({ row: F }) => [C("span", null, K(F.mete ? F.mete.toFixed(F.accountingPrecision) : "-"), 1)]), _: 1 }), s(l(Td), { "base-unit": l(c), "basic-class": e.basicClass, "current-cfg": l(u), form: l(y), handleOverQuantity: l(O), list: l(y).auxMatList, order: e.order }, { editColumn: p(({ row: F }) => [s(X, { align: "center", label: "规格", "min-width": "100px", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: G }) => [s(Se, { content: G.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(G.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(X, { align: "center", label: "颜色", "min-width": "120px", prop: "color" }, { default: p(({ row: G }) => [s(me, { modelValue: G.color, "onUpdate:modelValue": (ie) => G.color = ie, modelModifiers: { trim: true }, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(X, { align: "center", label: "本次实收数", "min-width": "120px", prop: "quantity" }, { default: p(({ row: G }) => [F.measureUnit && l(A)(F.measurePrecision) ? (w(), U(Ie, { key: 0, modelValue: G.quantity, "onUpdate:modelValue": (ie) => G.quantity = ie, controls: false, max: 999999999, min: 0, precision: F.measurePrecision, step: 1, placeholder: "本次实收数", size: "default", onBlur: (ie) => l(O)(G), onChange: (ie) => le(G, G) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur", "onChange"])) : (w(), Q("span", yae, K(G.quantity || "-"), 1))]), _: 2 }, 1024), s(X, { align: "center", label: "本次实收量", "min-width": "120px", prop: "mete" }, { default: p(({ row: G }) => [s(Ie, { modelValue: G.mete, "onUpdate:modelValue": (ie) => G.mete = ie, controls: false, max: 999999999, min: 1e-6, precision: F.accountingPrecision, step: 1, placeholder: "实收量", size: "default", onBlur: (ie) => l(x)(G) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 2 }, 1024)]), _: 1 }, 8, ["base-unit", "basic-class", "current-cfg", "form", "handleOverQuantity", "list", "order"])], 64)) : H("", true), !n.boolPartyA && e.noDetail ? (w(), Q(Qe, { key: 3 }, [s(go, { list: l(y).auxMatList, order: e.order }, null, 8, ["list", "order"]), s(Go, { list: l(y).auxMatList, showWarehouse: "" }, null, 8, ["list"]), n.boolPartyA || n.noDetail ? (w(), U(ge, { key: 0, align: "center", fixed: "right", label: "操作", width: "160" }, { default: p(({ row: F, rowIndex: G }) => [s($, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (ie) => j(F, G) }, null, 8, ["onClick"]), s($, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (ie) => ae(F.sn, G, F) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)], 64)) : H("", true)]), _: 1 }, 8, ["cell-class-name", "columnConfig", "data", "max-height", "scroll-y"]))])), [[z, V.value]])]);
  };
} }, _d = ut(Tae, [["__scopeId", "data-v-fd541e8b"]]), _ae = Object.freeze(Object.defineProperty({ __proto__: null, default: _d }, Symbol.toStringTag, { value: "Module" }));
const bae = { style: { overflow: "hidden" } }, Vae = { style: {} }, wae = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Sae = { key: 1 }, vae = { key: 1 }, Rae = { key: 1 }, Mae = { key: 1 }, Aae = { key: 1 }, Nae = { key: 1 }, Lae = { __name: "aux-mat-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.MATERIAL.V, u = ft("matSpecRef"), { priceAbnormal: r } = aa(), { baseUnit: E } = ai(c), { cu: y, form: b } = Wi(), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g, currentCfg: S } = Va(E), h = Z(false), T = Z(null), _ = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const f = Z({ enabled: true, gt: 0, oSize: 5, scrollToTopOnChange: true, immediate: true }), m = Z([{ seq: "合计", amountExcludingVatFreight: "-", amount: "-" }]);
  Ce(() => b.auxMatList, (k) => {
    R();
  }, { deep: true, immediate: true });
  function R() {
    var z;
    let k = 0, J = 0;
    (z = b.auxMatList) == null || z.forEach((F) => {
      k += Number(F.amount) || 0, J += Number(F.amountExcludingVatFreight) || 0;
    }), k = k.toFixed(Ze.YUAN), J = J.toFixed(Ze.YUAN), m.value = [{ seq: "合计", amountExcludingVatFreight: J, amount: k }];
  }
  const { specSelectMaxHeight: v, specRef: N, drawerRef: P, editRow: L, editList: O, materialSelectVisible: x, handleClickEditSpec: I, handleSpecChange: Y } = Qa(), ee = /^(?!(0[0-9]{1,}$))[0-9]*[.]{0,}[0-9]{0,}$/, q = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (k, J) => A(J.measureUnit) ? !!J.quantity : true }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (k, J) => !!k, message: "核算量必须大于0", trigger: "blur" }], amount: [{ required: true, message: "请输入含税金额", trigger: "change" }, { pattern: ee, message: "含税金额必须大于0", trigger: "blur" }], amountExcludingVatFreight: [{ required: true, message: "请输入不含税金额", trigger: "change" }, { pattern: ee, message: "不含税金额必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, ae = Ee(() => {
    let k = Object.assign({}, q);
    return !n.boolPartyA && n.fillableAmount && (k = Object.assign(k, {})), k;
  }), j = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: le, cleanUpData: oe, wrongCellMask: ye } = ui({ rules: ae, ditto: j, errorMsg: "请修正【辅材清单】中标红的信息" });
  function ce() {
  }
  function se({ row: k, rowIndex: J }) {
    var z, F;
    if ((F = (z = y == null ? void 0 : y.submitResult) == null ? void 0 : z.data) != null && F.includes(k.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function he(k) {
    const J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, classifySerialNumber: k.classify.serialNumber, serialNumber: k.serialNumber, classifyId: k.classify.id, classifyFullName: k.classify.fullName, classifyName: k.classify.name, classifyParentFullName: k.classify.parentFullName, basicClass: k.classify.basicClass, specification: k.spec, model: k.spec, specificationMap: k.specKV, measureUnit: k.classify.measureUnit, accountingUnit: k.classify.accountingUnit, accountingPrecision: k.classify.accountingPrecision, measurePrecision: k.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, projectId: b.auxMatList.length > 0 ? -1 : void 0, workshopId: b.auxMatList.length > 0 ? -1 : void 0, warehouseId: b.auxMatList.length > 0 ? -1 : void 0, rowIndex: b.auxMatList.length });
    return !n.boolPartyA && n.fillableAmount && (J.unitPrice = void 0, J.amount = void 0), be(J), J;
  }
  function be(k) {
    Dt(() => {
      var J, z, F, G;
      k.needFirstCalcTheoryWeight && (k.boolApplyPurchase || (me(k), ge(k)), k.boolApplyPurchase && ((z = (J = b.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected) && (k.quantity = (F = k == null ? void 0 : k.applyPurchase) == null ? void 0 : F.reduce((ie, ue) => ie + (ue.quantity || 0), 0), k.theoryTotalWeight = (G = k == null ? void 0 : k.applyPurchase) == null ? void 0 : G.reduce((ie, ue) => ie + (ue.theoryTotalWeight || 0), 0)), k.needFirstCalcTheoryWeight = false), M(k);
    }), Ce([() => k.boolApplyPurchase, () => k == null ? void 0 : k.applyPurchase], () => {
      var J, z, F, G;
      k.boolApplyPurchase && ((z = (J = b.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected ? (k.quantity = (F = k == null ? void 0 : k.applyPurchase) == null ? void 0 : F.reduce((ie, ue) => ie + (ue.quantity || 0), 0), k.theoryTotalWeight = (G = k == null ? void 0 : k.applyPurchase) == null ? void 0 : G.reduce((ie, ue) => ie + (ue.theoryTotalWeight || 0), 0), k.weighingTotalWeight = k.theoryTotalWeight) : (k.quantity = 0, k.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => k, () => {
      var J, z, F;
      if (!n.boolPartyA && !n.noDetail && ((z = (J = b.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected)) {
        const G = (F = b.selectObj[k.mergeId]) == null ? void 0 : F.isSelected;
        b.selectObj[k.mergeId] = { ...b.selectObj[k.mergeId], ...k, mete: k.weighingTotalWeight, isSelected: G };
      }
    }, { deep: true }), k.boolApplyPurchase || (Ce([() => k.length, () => k.width, () => k.thickness, E], () => me(k)), Ce([() => k.theoryWeight, () => k.quantity], () => ge(k))), Ce(() => k.mete, () => {
      Le(k);
    });
  }
  async function me(k) {
    k.theoryWeight = await na({ classifyId: k.classifyId, name: k.classifyFullName, length: k.length, width: k.width, thickness: k.thickness });
  }
  function ge(k) {
    A(k.theoryWeight) && k.quantity ? (k.theoryTotalWeight = Be(k.theoryWeight * k.quantity, E.value.weight.precision), (n.boolPartyA || n.noDetail) && (k.weighingTotalWeight = Be(k.theoryWeight * k.quantity, E.value.weight.precision))) : (k.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (k.weighingTotalWeight = void 0));
  }
  function Le(k) {
    A(k.unitPrice) && A(k.weighingTotalWeight) ? k.amount = Be(k.weighingTotalWeight * k.unitPrice, Ze.YUAN) : (k.amount = void 0, k.amountExcludingVatFreight = void 0);
  }
  function Ie(k, J, z) {
    var F, G, ie, ue;
    if ((G = (F = y == null ? void 0 : y.submitResult) == null ? void 0 : F.data) != null && G.includes(z.classifyId)) {
      const ne = (ie = y == null ? void 0 : y.submitResult) == null ? void 0 : ie.data.findIndex((de) => de === z.classifyId);
      b.auxMatList.filter((de) => de.classifyId === z.classifyId).length === 1 && ((ue = y == null ? void 0 : y.submitResult) == null || ue.data.splice(ne, 1));
    }
    if (u.value ? u.value.delListItem(k, J) : b.auxMatList.splice(J, 1), A(b.auxMatList) && b.auxMatList.length > 0) {
      const ne = b.auxMatList[0];
      b.auxMatList[0].projectId = ne.projectId && ne.projectId !== -1 ? ne.projectId : void 0, b.auxMatList[0].workshopId = ne.workshopId && ne.workshopId !== -1 ? ne.workshopId : void 0, b.auxMatList[0].warehouseId = ne.warehouseId && ne.warehouseId !== -1 ? ne.warehouseId : void 0;
    }
  }
  function Se(k, J) {
    var G;
    const z = JSON.parse(JSON.stringify(k)), F = Ct({ uid: Tt(), sn: z.sn, specificationLabels: z.specificationLabels, classifySerialNumber: z.classifySerialNumber, serialNumber: z.serialNumber, classifyId: z.classifyId, classifyFullName: z.classifyFullName, classifyName: z.classifyName, classifyParentFullName: z.classifyParentFullName, basicClass: z.basicClass, specification: z.specification, model: z.spec, specificationMap: z.specificationMap, measureUnit: z.measureUnit, accountingUnit: z.accountingUnit, accountingPrecision: z.accountingPrecision, measurePrecision: z.measurePrecision, quantity: z.quantity, thickness: z.thickness, length: z.length, width: z.width, theoryWeight: z.theoryWeight, theoryTotalWeight: z.theoryTotalWeight, weighingTotalWeight: z.weighingTotalWeight, rowIndex: b.auxMatList.length, weightMeasurementMode: z.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : z.unitPrice, mete: z.mete, color: z.color, brand: z.brand, amount: z.amount, amountExcludingVatFreight: z.amountExcludingVatFreight, projectSerialNumber: z.projectSerialNumber, projectId: z.projectId, workshopName: z.workshopName, warehouseName: z.warehouseName, workshopId: z.workshopId, warehouseId: z.warehouseId });
    b.auxMatList.push(F), be(F), (G = u.value) == null || G.initSelected([F]);
  }
  async function X() {
    const k = At(b.auxMatList), { validResult: J } = le(b.auxMatList);
    if (J) {
      let z = true;
      const F = [];
      if (A(r.value) && r.value.forEach((G) => {
        var ue;
        const ie = (ue = b.auxMatList) == null ? void 0 : ue.filter((ne) => ne.basicClass === G.basicClass);
        A(ie) && ie.forEach((ne) => {
          G.minPrice && ne.amount < G.minPrice * ne.mete && F.push({ msg: `${Pe.VL[ne.basicClass]} ${ne.serialNumber} ${ne.classifyName}：含税金额${ne.amount} < 异常配置最小值${G.minPrice}*核算量` }), G.maxPrice && ne.amount > G.maxPrice * ne.mete && F.push({ msg: `${Pe.VL[ne.basicClass]} ${ne.serialNumber} ${ne.classifyName}：含税金额${ne.amount} > 异常配置最大值${G.maxPrice}*核算量` });
        });
      }), A(F)) {
        const G = F.map((ie) => `<div>${ie.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + G, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          z = true;
        }).catch((ie) => {
          z = false;
        });
      }
      if (!z) return false;
    }
    if (J) oe(k), k.forEach((z) => {
    });
    else {
      const z = b.auxMatList.find((F) => F.verify ? Object.values(F.verify).some((G) => G === false) : false);
      z && T.value && pt(() => {
        T.value.scrollToRow(z);
      });
    }
    return J;
  }
  function $(k, J) {
  }
  return o({ rowInit: he, rowWatch: be, toggleRowSelection: $, validate: X, setSelect: ce }), (k, J) => {
    const z = Mt, F = Ve("vxe-column"), G = Ve("vxe-tooltip"), ie = ya, ue = Ve("common-input-number"), ne = Ve("common-button"), te = Ve("vxe-table"), de = Ve("common-drawer"), pe = _t("empty-text"), re = oi;
    return w(), Q("div", null, [qe((w(), Q("div", bae, [(w(), U(te, { ref_key: "tableRef", ref: T, key: `inbound_${l(c)}`, "cell-class-name": l(ye), "column-config": _.value, data: l(b).auxMatList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": se, "scroll-y": f.value, border: "", "footer-data": m.value, "show-footer": "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(F, { type: "expand", width: "60" }, { content: p(({ row: we }) => [C("div", Vae, [s(z, { modelValue: we.remark, "onUpdate:modelValue": (Ke) => we.remark = Ke, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(we.inboundList) ? (w(), Q("div", wae, [s(l(al), { "basic-class": l(c), list: we.inboundList, material: we, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(F, { title: "序号", type: "seq", width: "55" }), s(F, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: we }) => [s(G, { content: we.classifyParentFullName, disabled: !we.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, we.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(F, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: we }) => {
      var Ke, Me, Ne;
      return [(Me = (Ke = l(b).selectObj) == null ? void 0 : Ke[we.mergeId]) != null && Me.isSelected && ((Ne = l(S)) == null ? void 0 : Ne.spec) & l(c) && !we.boolApplyPurchase ? (w(), U(ie, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (He) => l(I)(we) }, null, 8, ["onClick"])) : H("", true), s(G, { content: we.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(we.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(F, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: we }) => [C("span", null, K(we.measureUnit || "-"), 1)]), _: 1 }), s(F, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: we }) => [e.isEdit && l(A)(we.measureUnit) ? (w(), U(ue, { key: 0, modelValue: we.quantity, "onUpdate:modelValue": (Ke) => we.quantity = Ke, controls: false, max: 999999999, min: 0, precision: we.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Sae, K(we.quantity), 1))]), _: 1 }), s(F, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: we }) => [C("span", null, K(we.accountingUnit || "-"), 1)]), _: 1 }), s(F, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: we.mete, "onUpdate:modelValue": (Ke) => we.mete = Ke, controls: false, max: 999999999, min: 1e-6, precision: we.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", vae, K(we.mete), 1))]), _: 1 }), s(F, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(z, { key: 0, modelValue: we.color, "onUpdate:modelValue": (Ke) => we.color = Ke, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Rae, K(we.color), 1))]), _: 1 }), s(F, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(z, { key: 0, modelValue: we.brand, "onUpdate:modelValue": (Ke) => we.brand = Ke, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Mae, K(we.brand), 1))]), _: 1 }), s(F, { align: "center", field: "amount", title: "含税金额", width: "120" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: we.amount, "onUpdate:modelValue": (Ke) => we.amount = Ke, controls: false, min: 0, precision: 2, placeholder: "含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Aae, K(we.amount), 1))]), _: 1 }), s(F, { align: "center", field: "amountExcludingVatFreight", title: "不含税金额", width: "120" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: we.amountExcludingVatFreight, "onUpdate:modelValue": (Ke) => we.amountExcludingVatFreight = Ke, controls: false, min: 0, precision: 2, placeholder: "不含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Nae, K(we.amountExcludingVatFreight), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(b).auxMatList }, null, 8, ["list"])) : (w(), U(F, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: we }) => [C("span", null, K(we.projectFullName || we.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(b).auxMatList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(F, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: we }) => [C("span", null, K(we.workshopName), 1)]), _: 1 }), s(F, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: we }) => [C("span", null, K(we.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(F, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: we, rowIndex: Ke }) => [s(ne, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Me) => Se(we, Ke) }, null, 8, ["onClick"]), s(ne, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Me) => Ie(we.sn, Ke, we) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[re, h.value]]), s(de, { ref_key: "drawerRef", ref: P, modelValue: l(x), "onUpdate:modelValue": J[1] || (J[1] = (we) => Gt(x) ? x.value = we : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: N, modelValue: l(O), "onUpdate:modelValue": J[0] || (J[0] = (we) => Gt(O) ? O.value = we : null), classifyId: l(L).classifyId, "max-height": l(v), "show-classify": false, visible: l(x), "expand-query": "", mode: "selector", onChange: l(Y) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Sm = ut(Lae, [["__scopeId", "data-v-7b3b7e83"]]), Iae = Object.freeze(Object.defineProperty({ __proto__: null, default: Sm }, Symbol.toStringTag, { value: "Module" }));
const Cae = { class: "aux-mat-inbound-application-container" }, Pae = { class: "filter-container" }, Oae = { key: 0, class: "filter-left-box" }, kae = { class: "filter-right-box" }, Dae = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success", "beginClose"], setup(e, { emit: o }) {
  const n = o, c = e, u = { inboundWay: si.ORDINARY_STORAGE.V, purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], auxMatList: [] };
  Wa(), Io(), Sr();
  const r = Z(), E = Z(), y = Z(), b = Z(), V = Z(), M = Z(false), g = Z(false), S = Z(false), h = Z(false), T = Z([]), _ = Z(false), f = Ge.MATERIAL.V, { priceAbnormal: m, inboundFillWayCfg: R } = aa(), v = Ee(() => R.value ? !!(R.value.amountFillWay === $l.APPLICATION.V && S.value) : false), N = Ee(() => {
    var ne, te;
    return !!((te = (ne = V.value) == null ? void 0 : ne.applyPurchase) != null && te.length);
  }), P = Z(), L = Ee(() => (ce == null ? void 0 : ce.inboundWay) === si.OPENING_RECEIPT.V);
  function O() {
    P.value.handleClose();
  }
  const x = Ee(() => ({ basicClass: f })), I = Ee(() => {
    var ne;
    return f ? { id: (ne = V.value) == null ? void 0 : ne.id, basicClass: f } : {};
  }), Y = Ee(() => !!(f && V.value)), ee = Ee(() => {
    let ne = 0;
    return g.value || A(ce.auxMatList) && ce.auxMatList.forEach((te) => {
      A(te.amount) && (ne += +te.amount);
    }), ji(ne, Ze.YUAN);
  });
  yi("matSpecRef", E);
  const B = Z(false), q = Ee(() => !c.edit && !B.value), ae = Ee(() => ({ amount: [{ validator: (ne, te) => A(te.mete) && A(te.unitPrice) && A(ne) ? +Be(te.mete * te.unitPrice, Ze.YUAN) == +ne : true, message: "金额有误，请手动修改", trigger: "blur" }] })), j = () => {
    B.value = true, oe(ce);
  };
  function le() {
    B.value = false, J();
  }
  const oe = (ne) => {
    var de;
    ne.auxMatList = (de = ne.auxMatList) == null ? void 0 : de.map((pe) => Ct(pe));
    const te = Ce(r, (pe) => {
      var re;
      if (pe) {
        if (pt(() => {
          var we;
          (we = r.value) == null || we.setSelect();
        }), g.value || ne.auxMatList.forEach((we) => {
          var Ke, Me;
          r.value.rowWatch(we), !g.value && !S.value && ((Me = (Ke = ne.selectObj) == null ? void 0 : Ke[we.mergeId]) != null && Me.isSelected) && r.value.toggleRowSelection(we, true);
        }), (re = V.value) != null && re.id && S.value || g.value) {
          const we = Ce(E, () => {
            E.value && (E.value.initSelected(ne.auxMatList.map((Ke) => ({ sn: Ke.sn, classifyId: Ke.classifyId }))), pt(() => {
              q.value && (q.value = false), we();
            }));
          }, { immediate: true });
        }
        pt(() => {
          te();
        });
      }
    }, { immediate: true, deep: true });
    me();
  }, { cu: ye, form: ce, FORM: se } = Pa({ title: "辅材入库", formStoreKey: "WMS_INBOUND_APPLICATION_AUX_MAT_SELF", permission: lb, useDraftCallback: j, defaultForm: u, clearDraftCallback: le, api: c.edit ? Vu : LX }, y, c.detail), { maxHeight: he } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => b.value.loaded);
  let be = {};
  c.edit ? be = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : be = { mainBox: ".aux-mat-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: me, maxHeight: ge } = Kt(be), Le = Ee(() => {
    var ne;
    return (ne = ce.list) == null ? void 0 : ne.filter((te) => {
      var de, pe;
      return (pe = (de = ye == null ? void 0 : ye.submitResult) == null ? void 0 : de.data) == null ? void 0 : pe.includes(te.classifyId);
    });
  });
  J(), se.HOOK.beforeToEdit = async (ne, te) => {
    var de, pe;
    if (c.edit && (await pt(() => {
      var re;
      te.purchaseId = (re = te.purchaseOrder) == null ? void 0 : re.id;
    }), te.logistics || (te.logistics = {}), g.value || Ae((de = te.purchaseOrder) == null ? void 0 : de.details))) {
      const re = JSON.parse(te.jsonData);
      (pe = te.list) != null && pe.length || (te.list = re.list), te.auxMatList = te.list, oe(te);
    }
  }, se.HOOK.afterSubmit = () => {
    c.edit && n("success"), J();
  };
  function Ie(ne) {
    if (f) {
      const te = [];
      ce.originAuxMatList.forEach((pe) => {
        (!A(ne.classifyId) || ne.classifyId.includes(pe.classifyId)) && (!ne.specification || pe.specification.includes(ne.specification)) && (!ne.color || pe.color.includes(ne.color)) && (!ne.brand || pe.brand.includes(ne.brand)) && te.push(pe);
      }), ce.auxMatList = te;
    } else ce.auxMatList = [];
  }
  function Se() {
    if (ce.auxMatList = [], f) {
      const ne = ce.originAuxMatList;
      ce.auxMatList = ne;
    }
  }
  async function X() {
    var te;
    if (L.value) return;
    A((te = V.value) == null ? void 0 : te.details) && Se();
    const ne = r.value ? r.value.validate() : true;
    if (ne) {
      let de = true;
      const pe = [];
      if (A(m.value) && m.value.forEach((we) => {
        var Me;
        const Ke = (Me = ce.auxMatList) == null ? void 0 : Me.filter((Ne) => Ne.basicClass === we.basicClass);
        A(Ke) && Ke.forEach((Ne) => {
          we.minPrice && Ne.unitPrice < we.minPrice && pe.push({ msg: `${Pe.VL[Ne.basicClass]} ${Ne.serialNumber} ${Ne.classifyName}：单价${Ne.unitPrice} < 异常配置最小值${we.minPrice}` }), we.maxPrice && Ne.unitPrice > we.maxPrice && pe.push({ msg: `${Pe.VL[Ne.basicClass]} ${Ne.serialNumber} ${Ne.classifyName}：单价${Ne.unitPrice} > 异常配置最大值${we.maxPrice}` });
        });
      }), A(pe)) {
        const we = pe.map((Ke) => `<div>${Ke.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + we, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          de = true;
        }).catch((Ke) => {
          de = false;
        });
      }
      if (!de) return false;
      const re = [];
      ce.auxMatList.forEach((we) => {
        var Ke, Me;
        (Ke = we.applyPurchase) != null && Ke.length ? we.applyPurchase.forEach((Ne) => {
          var He, ze, Oe, Re;
          (Ne.quantity || Ne.mete) && re.push({ ...we, brand: Ne.brand, color: Ne.color, quantity: Ne.quantity, projectId: Ne.projectId || ((He = Ne.project) == null ? void 0 : He.id), uid: Tt(), mete: Ne.mete, unitPrice: A(Ne.unitPrice) ? Ne.unitPrice : we.unitPrice, amount: A(Ne.unitPrice) ? Be(Ne.mete * Ne.unitPrice, Ze.YUAN) : A(we.unitPrice) ? Be(Ne.mete * we.unitPrice, Ze.YUAN) : void 0, applyPurchaseId: Ne.applyPurchaseId, purchaseDetailId: Ne.purchaseDetailId, purchaseProjectDisabled: Ne.applyPurchaseId ? !((ze = Ne.project) != null && ze.id) : false, workshopId: Ne.workshopId || ((Oe = Ne.workshop) == null ? void 0 : Oe.id), warehouseId: Ne.warehouseId || ((Re = Ne.warehouse) == null ? void 0 : Re.id) });
        }) : (g.value || S.value || (Me = ce.selectObj[we.mergeId]) != null && Me.isSelected) && re.push(we);
      }), ce.list = re;
    }
    return A(Le.value) ? (ot.error("请先删除标红数据并重新添加"), false) : ne;
  }
  function $(ne) {
    return ne.model = ne.spec, r.value.rowInit(ne);
  }
  async function k(ne) {
    var te;
    if (J(), V.value = ne, ye.props.order = ne, g.value = (ne == null ? void 0 : ne.supplyType) === Ni.PARTY_A.V, S.value = Ae(ne == null ? void 0 : ne.details), q.value && (ce.auxMatList = [], ce.originAuxMatList = []), q.value && (ne != null && ne.id && S.value || g.value)) {
      const de = Ce(E, () => {
        E.value && (E.value.clearByBasicClass(f), pt(() => {
          de();
        }));
      }, { immediate: true });
    }
    g.value && q.value && oe(ce), (te = ne == null ? void 0 : ne.details) != null && te.length && (ce.auxMatList = ne.details.map((de, pe) => (de.uid = Tt(), de.rowIndex = pe, de)), oe(ce), ce.originAuxMatList = ce.auxMatList), M.value = true;
  }
  function J() {
    M.value = false, g.value = false;
  }
  function z() {
    var ne;
    if (A(Le.value) && A((ne = ye == null ? void 0 : ye.submitResult) == null ? void 0 : ne.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    _.value = true;
  }
  ye.props.import = (ne) => {
    var re;
    if (ce.inboundWay === si.OPENING_RECEIPT.V) return ce.auxMatList.push.apply(ce.auxMatList, ne);
    v.value || ne.forEach((we) => {
      we.amount = void 0, we.unitPrice = void 0;
    });
    let te = [];
    if (V.value.auxMaterialIds.includes(0) || ne.forEach((we) => {
      let Ke = false;
      for (const Me of V.value.auxMaterialIds) if (we.classifyFullPathId.includes(Me)) {
        Ke = true;
        break;
      }
      Ke || te.push(we.classifyName);
    }), (te == null ? void 0 : te.length) > 0) throw te = Array.from(new Set(te)), new Error(`当前订单辅材明细中不存在${te.map((we) => `“${we}”`).join("、")}等科目`);
    const de = ((re = ce.auxMatList) == null ? void 0 : re.length) || 0;
    ne.map((we, Ke) => {
      var Me;
      we.rowIndex = (((Me = ce.auxMatList) == null ? void 0 : Me.length) || 0) + Ke, we.projectId = we.projectId || (Ke > 0 || de > 0 ? -1 : void 0), we.workshopId = we.workshopId || (Ke > 0 || de > 0 ? -1 : void 0), we.warehouseId = we.warehouseId || (Ke > 0 || de > 0 ? -1 : void 0);
    }), ce.auxMatList.push.apply(ce.auxMatList, ne);
    const pe = Ce(E, () => {
      E.value && (E.value.initSelected(ne.map((we) => ({ sn: we.sn, classifyId: we.classifyId }))), pt(() => {
        pe();
      }));
    }, { immediate: true });
  }, Ce(() => ce.inboundWay, (ne) => {
    ce.auxMatList = [], ce.list = [];
  });
  async function F() {
    return !!await r.value.validate();
  }
  async function G() {
    try {
      const ne = At(ce.auxMatList);
      if (Ae(ne)) return;
      ne.forEach((te) => {
        te.amount = Number(te.amount), te.amountExcludingVatFreight = Number(te.amountExcludingVatFreight), te.unitPrice = te.amount / te.mete, te.unitPriceExcludingVatFreight = te.amountExcludingVatFreight / te.mete;
      }), ce.list = await Ut(ne, { basicClass: f, toSmallest: true, toNum: true }, { amount: ["unitPrice", "unitPriceExcludingVatFreight"] }), await IX(ce), ye.submitSuccessNotify(), ye.resetForm(), O();
    } catch (ne) {
      throw console.log(ne, "beginSubmit"), new Error(ne);
    }
  }
  function ie() {
    n("beginClose");
  }
  ye.props.detailImport = (ne) => {
    var Ke;
    const te = [], de = {};
    ne.forEach((Me, Ne) => {
      Me.index = Ne + 1, te.includes(Me.uniqueIdentification) || (te.push(Me.uniqueIdentification), de[Me.uniqueIdentification] = []);
    });
    const pe = ce.originAuxMatList, re = [], we = [];
    for (let Me = 0; Me < te.length; Me++) if (pe.findIndex((Ne) => Ne.uniqueIdentification === te[Me]) > -1) {
      const Ne = ne.filter((ze) => ze.uniqueIdentification === te[Me]), He = pe.find((ze) => ze.uniqueIdentification === te[Me]) || {};
      if (A(Ne)) {
        const ze = [];
        Ne.forEach((Oe, Re) => {
          if (He.classifyId === Oe.classifyId && (!He.specification || He.specification === Oe.specification)) ze.push({ originData: He, ...Oe });
          else {
            const fe = [];
            He.classifyId !== Oe.classifyId && fe.push("物料种类" + Oe.classifyName), He.specification && He.specification !== Oe.specification && fe.push("规格" + Oe.specification), Oe.errorMsg = fe.join("、"), we.push(Oe);
          }
        }), de[te[Me]] = ze;
      }
    } else re.push(te[Me]);
    if (A(re)) {
      ot.error(`采购订单不存在${re.map((Me) => `“${Me}”`).join("、")}${re.length > 1 ? "等" : ""}唯一标识`);
      return;
    }
    if (A(we)) {
      let Me = "";
      we.forEach((Ne) => {
        Me += "序号" + Ne.index + "唯一标识" + Ne.uniqueIdentification + "：" + Ne.errorMsg + `有误
`;
      }), ot.error(Me);
      return;
    }
    T.value = [];
    for (const Me in de) (Ke = de[Me]) == null || Ke.forEach((Ne) => {
      T.value.push(Ne);
    });
    T.value.forEach((Me) => {
      Me.quantity || (Me.quantity = void 0);
    }), T.value.map((Me, Ne) => {
      Me.projectId = Me.projectId || (Ne > 0 ? -1 : void 0), Me.workshopId = Me.workshopId || (Ne > 0 ? -1 : void 0), Me.warehouseId = Me.warehouseId || (Ne > 0 ? -1 : void 0);
    }), h.value = true;
  };
  function ue(ne) {
    const te = ce.originAuxMatList;
    ne.forEach((de) => {
      const pe = te.find((re) => re.uniqueIdentification === de.uniqueIdentification);
      if (A(pe)) {
        const re = pe.applyPurchase[0];
        A(re) ? re.mete || (pe.applyPurchase = []) : pe.applyPurchase = [], pe.applyPurchase.length > 0 && (de.isBranch = true), pe.applyPurchase.push(de), ce.selectObj[pe.mergeId].isSelected = true;
      }
    }), te.forEach((de) => {
      var pe;
      de.mete = ((pe = de == null ? void 0 : de.applyPurchase) == null ? void 0 : pe.reduce((re, we) => re + (we.mete || 0), 0)) || 0;
    });
  }
  return (ne, te) => {
    const de = Ve("common-button"), pe = jt, re = Li, we = Ve("common-drawer"), Ke = _t("permission");
    return qe((w(), Q("div", Cae, [s(Ar, { "basic-class": l(f), "begin-permission": l(Cd), "begin-validate": F, edit: c.edit, importAmountRules: L.value ? {} : ae.value, "show-total": false, "show-total-amount": L.value ? false : !g.value && v.value, "total-amount": ee.value, validate: X, onPurchaseOrderChange: k }, { beginPreview: p((Me) => [s(wu, { ref_key: "beginConfirmRef", ref: P, submit: G, visible: Me.visible, title: "辅材", onSuccess: ie, "onUpdate:visible": (Ne) => Me.onUpdateVisible(Ne) }, { default: p(() => [s(Sm, { "is-edit": false, "max-height": l(ge) + 120 }, null, 8, ["max-height"])]), _: 2 }, 1032, ["visible", "onUpdate:visible"])]), default: p(() => {
      var Me, Ne, He, ze, Oe, Re;
      return [C("div", Pae, [!S.value && l(A)(l(f)) && !l(Ae)((Me = V.value) == null ? void 0 : Me.details) ? (w(), Q("div", Oae, [s(bu, { currentBasicClass: l(f), onBlurQuery: Ie, onResetQuery: Se }, null, 8, ["currentBasicClass"])])) : H("", true), C("div", kae, [l(ce).inboundWay === l(si).OPENING_RECEIPT.V && l(Ai)(l(Cd).download) ? (w(), U(ia, { key: 0, fn: l(is), params: { basicClass: l(Pe).MATERIAL.V, boolPartyA: g.value }, class: "filter-item" }, { default: p(() => te[2] || (te[2] = [Te("辅材期初入库模版下载 ")])), _: 1, __: [2] }, 8, ["fn", "params"])) : H("", true), l(ce).inboundWay === l(si).ORDINARY_STORAGE.V && (g.value || !g.value && l(Ae)((Ne = V.value) == null ? void 0 : Ne.details)) ? (w(), U(ia, { key: 1, disabled: !l(f) || !((He = V.value) != null && He.id), fn: l(gd), params: x.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(l(f) ? l(Ge).VL[l(f)] : "") + "入库模板下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), !g.value && l(A)((ze = V.value) == null ? void 0 : ze.details) ? (w(), U(ia, { key: 2, disabled: !l(f) || !((Oe = V.value) != null && Oe.id), fn: l(Ed), params: I.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(l(f) ? l(Ge).VL[l(f)] : "") + "采购明细下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), L.value ? (w(), Q(Qe, { key: 3 }, [l(Ai)((Re = l(Cd)) == null ? void 0 : Re.import) ? (w(), U(de, { key: 0, class: "filter-item", type: "success", onClick: z }, { default: p(() => te[3] || (te[3] = [Te("添加物料 ")])), _: 1, __: [3] })) : H("", true)], 64)) : (w(), U(pe, { key: 4, disabled: Y.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => {
        var fe;
        return [C("span", null, [g.value || !g.value && l(Ae)((fe = V.value) == null ? void 0 : fe.details) ? (w(), U(de, { key: 0, disabled: !Y.value, class: "filter-item", type: "success", onClick: z }, { default: p(() => te[4] || (te[4] = [Te(" 添加物料 ")])), _: 1, __: [4] }, 8, ["disabled"])) : H("", true)])];
      }), _: 1 }, 8, ["disabled"]))])]), l(ce).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(re, { key: 0, ref_key: "formRef", ref: y, model: l(ce) }, { default: p(() => [s(_d, { ref_key: "tableRef", ref: r, "bool-apply-purchase": N.value, "bool-party-a": g.value, fillableAmount: v.value, "max-height": l(ge), noDetail: S.value, order: V.value }, null, 8, ["bool-apply-purchase", "bool-party-a", "fillableAmount", "max-height", "noDetail", "order"])]), _: 1 }, 8, ["model"])) : (w(), U(Sm, { key: l(ce).inboundWay, ref_key: "tableRef", ref: r, "max-height": l(ge) }, null, 8, ["max-height"]))];
    }), _: 1 }, 8, ["basic-class", "begin-permission", "edit", "importAmountRules", "show-total-amount", "total-amount"]), s(we, { ref_key: "drawerRef", ref: b, modelValue: _.value, "onUpdate:modelValue": te[0] || (te[0] = (Me) => _.value = Me), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => {
      var Me;
      return [(w(), U(to, { key: l(ce).inboundWay, ref_key: "matSpecRef", ref: E, "basic-class": l(f), "classify-ids": (Me = V.value) == null ? void 0 : Me.auxMaterialIds, "max-height": l(he), "model-value": l(ce).auxMatList, "row-init-fn": $, "table-width": 430, visible: _.value, "auto-selected": "", "expand-query": "" }, null, 8, ["basic-class", "classify-ids", "max-height", "model-value", "visible"]))];
    }), _: 1 }, 8, ["modelValue"]), s(Su, { list: T.value, modelValue: h.value, "onUpdate:modelValue": te[1] || (te[1] = (Me) => h.value = Me), order: V.value, "basic-class": l(f), onSuccess: ue }, null, 8, ["list", "modelValue", "order", "basic-class"])])), [[Ke, l(lb)]]);
  };
} }, a4 = ut(Dae, [["__scopeId", "data-v-c49a7cad"]]), xae = Object.freeze(Object.defineProperty({ __proto__: null, default: a4 }, Symbol.toStringTag, { value: "Module" }));
const Uae = { style: { overflow: "hidden" } }, Yae = { style: {} }, Kae = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Wae = { key: 1 }, jae = { key: 1 }, Fae = { key: 1 }, zae = { key: 1 }, Bae = { key: 1 }, Hae = { key: 1 }, qae = { __name: "office-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.MATERIAL.V, u = ft("matSpecRef"), { priceAbnormal: r } = aa(), { baseUnit: E } = ai(c), { cu: y, form: b } = Wi(), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g, currentCfg: S } = Va(E), h = Z(false), T = Z(null), _ = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const f = Z({ enabled: true, gt: 0, oSize: 5, scrollToTopOnChange: true, immediate: true }), m = Z([{ seq: "合计", amountExcludingVatFreight: "-", amount: "-" }]);
  Ce(() => b.auxMatList, (k) => {
    R();
  }, { deep: true, immediate: true });
  function R() {
    var z;
    let k = 0, J = 0;
    (z = b.auxMatList) == null || z.forEach((F) => {
      k += Number(F.amount) || 0, J += Number(F.amountExcludingVatFreight) || 0;
    }), k = k.toFixed(Ze.YUAN), J = J.toFixed(Ze.YUAN), m.value = [{ seq: "合计", amountExcludingVatFreight: J, amount: k }];
  }
  const { specSelectMaxHeight: v, specRef: N, drawerRef: P, editRow: L, editList: O, materialSelectVisible: x, handleClickEditSpec: I, handleSpecChange: Y } = Qa(), ee = /^(?!(0[0-9]{1,}$))[0-9]*[.]{0,}[0-9]{0,}$/, q = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (k, J) => !!k, message: "核算量必须大于0", trigger: "blur" }], quantity: [{ validator: (k, J) => A(J.measureUnit) ? !!J.quantity : true }], amount: [{ required: true, message: "请输入含税金额", trigger: "change" }, { pattern: ee, message: "含税金额必须大于0", trigger: "blur" }], amountExcludingVatFreight: [{ required: true, message: "请输入不含税金额", trigger: "change" }, { pattern: ee, message: "不含税金额必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, ae = Ee(() => {
    let k = Object.assign({}, q);
    return !n.boolPartyA && n.fillableAmount && (k = Object.assign(k, {})), k;
  }), j = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: le, cleanUpData: oe, wrongCellMask: ye } = ui({ rules: ae, ditto: j, errorMsg: "请修正【办公用品清单】中标红的信息" });
  function ce() {
  }
  function se({ row: k, rowIndex: J }) {
    var z, F;
    if ((F = (z = y == null ? void 0 : y.submitResult) == null ? void 0 : z.data) != null && F.includes(k.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function he(k) {
    const J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, classifySerialNumber: k.classify.serialNumber, serialNumber: k.serialNumber, classifyId: k.classify.id, classifyFullName: k.classify.fullName, classifyName: k.classify.name, classifyParentFullName: k.classify.parentFullName, basicClass: k.classify.basicClass, specification: k.spec, model: k.spec, specificationMap: k.specKV, measureUnit: k.classify.measureUnit, accountingUnit: k.classify.accountingUnit, accountingPrecision: k.classify.accountingPrecision, measurePrecision: k.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, projectId: b.auxMatList.length > 0 ? -1 : void 0, workshopId: b.auxMatList.length > 0 ? -1 : void 0, warehouseId: b.auxMatList.length > 0 ? -1 : void 0, rowIndex: b.auxMatList.length });
    return !n.boolPartyA && n.fillableAmount && (J.unitPrice = void 0, J.amount = void 0), be(J), J;
  }
  function be(k) {
    Dt(() => {
      var J, z, F, G;
      k.needFirstCalcTheoryWeight && (k.boolApplyPurchase || (me(k), ge(k)), k.boolApplyPurchase && ((z = (J = b.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected) && (k.quantity = (F = k == null ? void 0 : k.applyPurchase) == null ? void 0 : F.reduce((ie, ue) => ie + (ue.quantity || 0), 0), k.theoryTotalWeight = (G = k == null ? void 0 : k.applyPurchase) == null ? void 0 : G.reduce((ie, ue) => ie + (ue.theoryTotalWeight || 0), 0)), k.needFirstCalcTheoryWeight = false), M(k);
    }), Ce([() => k.boolApplyPurchase, () => k == null ? void 0 : k.applyPurchase], () => {
      var J, z, F, G;
      k.boolApplyPurchase && ((z = (J = b.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected ? (k.quantity = (F = k == null ? void 0 : k.applyPurchase) == null ? void 0 : F.reduce((ie, ue) => ie + (ue.quantity || 0), 0), k.theoryTotalWeight = (G = k == null ? void 0 : k.applyPurchase) == null ? void 0 : G.reduce((ie, ue) => ie + (ue.theoryTotalWeight || 0), 0), k.weighingTotalWeight = k.theoryTotalWeight) : (k.quantity = 0, k.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => k, () => {
      var J, z, F;
      if (!n.boolPartyA && !n.noDetail && ((z = (J = b.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected)) {
        const G = (F = b.selectObj[k.mergeId]) == null ? void 0 : F.isSelected;
        b.selectObj[k.mergeId] = { ...b.selectObj[k.mergeId], ...k, mete: k.weighingTotalWeight, isSelected: G };
      }
    }, { deep: true }), k.boolApplyPurchase || (Ce([() => k.length, () => k.width, () => k.thickness, E], () => me(k)), Ce([() => k.theoryWeight, () => k.quantity], () => ge(k))), Ce(() => k.weighingTotalWeight, () => {
      Le(k);
    });
  }
  async function me(k) {
    k.theoryWeight = await na({ classifyId: k.classifyId, name: k.classifyFullName, length: k.length, width: k.width, thickness: k.thickness });
  }
  function ge(k) {
    A(k.theoryWeight) && k.quantity ? (k.theoryTotalWeight = Be(k.theoryWeight * k.quantity, E.value.weight.precision), (n.boolPartyA || n.noDetail) && (k.weighingTotalWeight = Be(k.theoryWeight * k.quantity, E.value.weight.precision))) : (k.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (k.weighingTotalWeight = void 0));
  }
  function Le(k) {
    A(k.unitPrice) && A(k.weighingTotalWeight) ? k.amount = Be(k.weighingTotalWeight * k.unitPrice, Ze.YUAN) : k.amount = void 0;
  }
  function Ie(k, J, z) {
    var F, G, ie, ue;
    if ((G = (F = y == null ? void 0 : y.submitResult) == null ? void 0 : F.data) != null && G.includes(z.classifyId)) {
      const ne = (ie = y == null ? void 0 : y.submitResult) == null ? void 0 : ie.data.findIndex((de) => de === z.classifyId);
      b.auxMatList.filter((de) => de.classifyId === z.classifyId).length === 1 && ((ue = y == null ? void 0 : y.submitResult) == null || ue.data.splice(ne, 1));
    }
    if (u.value ? u.value.delListItem(k, J) : b.auxMatList.splice(J, 1), A(b.auxMatList) && b.auxMatList.length > 0) {
      const ne = b.auxMatList[0];
      b.auxMatList[0].projectId = ne.projectId && ne.projectId !== -1 ? ne.projectId : void 0, b.auxMatList[0].workshopId = ne.workshopId && ne.workshopId !== -1 ? ne.workshopId : void 0, b.auxMatList[0].warehouseId = ne.warehouseId && ne.warehouseId !== -1 ? ne.warehouseId : void 0;
    }
  }
  function Se(k, J) {
    var G;
    const z = JSON.parse(JSON.stringify(k)), F = Ct({ uid: Tt(), sn: z.sn, specificationLabels: z.specificationLabels, classifySerialNumber: z.classifySerialNumber, serialNumber: z.serialNumber, classifyId: z.classifyId, classifyFullName: z.classifyFullName, classifyName: z.classifyName, classifyParentFullName: z.classifyParentFullName, basicClass: z.basicClass, specification: z.specification, model: z.spec, specificationMap: z.specificationMap, measureUnit: z.measureUnit, accountingUnit: z.accountingUnit, accountingPrecision: z.accountingPrecision, measurePrecision: z.measurePrecision, quantity: z.quantity, thickness: z.thickness, length: z.length, width: z.width, theoryWeight: z.theoryWeight, theoryTotalWeight: z.theoryTotalWeight, weighingTotalWeight: z.weighingTotalWeight, rowIndex: b.auxMatList.length, weightMeasurementMode: z.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : z.unitPrice, mete: z.mete, color: z.color, brand: z.brand, amount: z.amount, amountExcludingVatFreight: z.amountExcludingVatFreight, projectSerialNumber: z.projectSerialNumber, projectId: z.projectId, workshopName: z.workshopName, warehouseName: z.warehouseName, workshopId: z.workshopId, warehouseId: z.warehouseId });
    b.auxMatList.push(F), be(F), (G = u.value) == null || G.initSelected([F]);
  }
  async function X() {
    const k = At(b.auxMatList), { validResult: J } = le(b.auxMatList);
    if (J) {
      let z = true;
      const F = [];
      if (A(r.value) && r.value.forEach((G) => {
        var ue;
        const ie = (ue = b.auxMatList) == null ? void 0 : ue.filter((ne) => ne.basicClass === G.basicClass);
        A(ie) && ie.forEach((ne) => {
          G.minPrice && ne.amount < G.minPrice * ne.mete && F.push({ msg: `${Pe.VL[ne.basicClass]} ${ne.serialNumber} ${ne.classifyName}：含税金额${ne.amount} < 异常配置最小值${G.minPrice}*核算量` }), G.maxPrice && ne.amount > G.maxPrice * ne.mete && F.push({ msg: `${Pe.VL[ne.basicClass]} ${ne.serialNumber} ${ne.classifyName}：含税金额${ne.amount} > 异常配置最大值${G.maxPrice}*核算量` });
        });
      }), A(F)) {
        const G = F.map((ie) => `<div>${ie.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + G, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          z = true;
        }).catch((ie) => {
          z = false;
        });
      }
      if (!z) return false;
    }
    if (J) oe(k), k.forEach((z) => {
    });
    else {
      const z = b.auxMatList.find((F) => F.verify ? Object.values(F.verify).some((G) => G === false) : false);
      z && T.value && pt(() => {
        T.value.scrollToRow(z);
      });
    }
    return J;
  }
  function $(k, J) {
  }
  return o({ rowInit: he, rowWatch: be, toggleRowSelection: $, validate: X, setSelect: ce }), (k, J) => {
    const z = Mt, F = Ve("vxe-column"), G = Ve("vxe-tooltip"), ie = ya, ue = Ve("common-input-number"), ne = Ve("common-button"), te = Ve("vxe-table"), de = Ve("common-drawer"), pe = _t("empty-text"), re = oi;
    return w(), Q("div", null, [qe((w(), Q("div", Uae, [(w(), U(te, { ref_key: "tableRef", ref: T, key: `inbound_${l(c)}`, "cell-class-name": l(ye), "column-config": _.value, data: l(b).auxMatList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": se, "scroll-y": f.value, border: "", "footer-data": m.value, "show-footer": "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(F, { type: "expand", width: "60" }, { content: p(({ row: we }) => [C("div", Yae, [s(z, { modelValue: we.remark, "onUpdate:modelValue": (Ke) => we.remark = Ke, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(we.inboundList) ? (w(), Q("div", Kae, [s(l(al), { "basic-class": l(c), list: we.inboundList, material: we, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(F, { title: "序号", type: "seq", width: "55" }), s(F, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: we }) => [s(G, { content: we.classifyParentFullName, disabled: !we.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, we.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(F, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: we }) => {
      var Ke, Me, Ne;
      return [(Me = (Ke = l(b).selectObj) == null ? void 0 : Ke[we.mergeId]) != null && Me.isSelected && ((Ne = l(S)) == null ? void 0 : Ne.spec) & l(c) && !we.boolApplyPurchase ? (w(), U(ie, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (He) => l(I)(we) }, null, 8, ["onClick"])) : H("", true), s(G, { content: we.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(we.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(F, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: we }) => [C("span", null, K(we.measureUnit || "-"), 1)]), _: 1 }), s(F, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: we }) => [e.isEdit && l(A)(we.measureUnit) ? (w(), U(ue, { key: 0, modelValue: we.quantity, "onUpdate:modelValue": (Ke) => we.quantity = Ke, controls: false, max: 999999999, min: 0, precision: we.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Wae, K(we.quantity), 1))]), _: 1 }), s(F, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: we }) => [C("span", null, K(we.accountingUnit || "-"), 1)]), _: 1 }), s(F, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: we.mete, "onUpdate:modelValue": (Ke) => we.mete = Ke, controls: false, max: 999999999, min: 1e-6, precision: we.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", jae, K(we.mete), 1))]), _: 1 }), s(F, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(z, { key: 0, modelValue: we.color, "onUpdate:modelValue": (Ke) => we.color = Ke, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Fae, K(we.color), 1))]), _: 1 }), s(F, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(z, { key: 0, modelValue: we.brand, "onUpdate:modelValue": (Ke) => we.brand = Ke, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", zae, K(we.brand), 1))]), _: 1 }), s(F, { align: "center", field: "amount", title: "含税金额", width: "120" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: we.amount, "onUpdate:modelValue": (Ke) => we.amount = Ke, controls: false, min: 0, precision: 2, placeholder: "含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Bae, K(we.amount), 1))]), _: 1 }), s(F, { align: "center", field: "amountExcludingVatFreight", title: "不含税金额", width: "120" }, { default: p(({ row: we }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: we.amountExcludingVatFreight, "onUpdate:modelValue": (Ke) => we.amountExcludingVatFreight = Ke, controls: false, min: 0, precision: 2, placeholder: "不含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Hae, K(we.amountExcludingVatFreight), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(b).auxMatList }, null, 8, ["list"])) : (w(), U(F, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: we }) => [C("span", null, K(we.projectFullName || we.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(b).auxMatList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(F, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: we }) => [C("span", null, K(we.workshopName), 1)]), _: 1 }), s(F, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: we }) => [C("span", null, K(we.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(F, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: we, rowIndex: Ke }) => [s(ne, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Me) => Se(we, Ke) }, null, 8, ["onClick"]), s(ne, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Me) => Ie(we.sn, Ke, we) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[re, h.value]]), s(de, { ref_key: "drawerRef", ref: P, modelValue: l(x), "onUpdate:modelValue": J[1] || (J[1] = (we) => Gt(x) ? x.value = we : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: N, modelValue: l(O), "onUpdate:modelValue": J[0] || (J[0] = (we) => Gt(O) ? O.value = we : null), classifyId: l(L).classifyId, "max-height": l(v), "show-classify": false, visible: l(x), "expand-query": "", mode: "selector", onChange: l(Y) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, vm = ut(qae, [["__scopeId", "data-v-21832877"]]), Gae = Object.freeze(Object.defineProperty({ __proto__: null, default: vm }, Symbol.toStringTag, { value: "Module" }));
const Qae = { class: "aux-mat-inbound-application-container" }, Zae = { class: "filter-container" }, Jae = { key: 0, class: "filter-left-box" }, Xae = { class: "filter-right-box" }, $ae = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success", "beginClose"], setup(e, { emit: o }) {
  const n = o, c = e, u = { inboundWay: si.ORDINARY_STORAGE.V, purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], auxMatList: [] };
  Wa(), Io(), Sr();
  const r = Z(), E = Z(), y = Z(), b = Z(), V = Z(), M = Z(false), g = Z(false), S = Z(false), h = Z(false), T = Z([]), _ = Z(false), f = Pe.OTHER.V, { priceAbnormal: m, inboundFillWayCfg: R } = aa(), v = Ee(() => R.value ? !!(R.value.amountFillWay === $l.APPLICATION.V && S.value) : false), N = Ee(() => {
    var ne, te;
    return !!((te = (ne = V.value) == null ? void 0 : ne.applyPurchase) != null && te.length);
  }), P = Ee(() => ({ basicClass: f })), L = Ee(() => {
    var ne;
    return f ? { id: (ne = V.value) == null ? void 0 : ne.id, basicClass: f } : {};
  }), O = Ee(() => !!(f && V.value)), x = Ee(() => {
    let ne = 0;
    return g.value || A(oe.auxMatList) && oe.auxMatList.forEach((te) => {
      A(te.amount) && (ne += +te.amount);
    }), ji(ne, Ze.YUAN);
  });
  yi("matSpecRef", E);
  const I = Z(false), Y = Ee(() => !c.edit && !I.value), ee = Ee(() => ({ amount: [{ validator: (ne, te) => A(te.mete) && A(te.unitPrice) && A(ne) ? +Be(te.mete * te.unitPrice, Ze.YUAN) == +ne : true, message: "金额有误，请手动修改", trigger: "blur" }] })), B = () => {
    I.value = true, j(oe);
  }, q = Ee(() => {
    var ne;
    return (ne = oe.list) == null ? void 0 : ne.filter((te) => {
      var de, pe;
      return (pe = (de = le == null ? void 0 : le.submitResult) == null ? void 0 : de.data) == null ? void 0 : pe.includes(te.classifyId);
    });
  });
  function ae() {
    I.value = false, $();
  }
  const j = (ne) => {
    var de;
    ne.auxMatList = (de = ne.auxMatList) == null ? void 0 : de.map((pe) => Ct(pe));
    const te = Ce(r, (pe) => {
      if (pe) {
        pt(() => {
          var we;
          (we = r.value) == null || we.setSelect();
        }), g.value || ne.auxMatList.forEach((we) => {
          var Ke, Me;
          r.value.rowWatch(we), !g.value && !S.value && ((Me = (Ke = ne.selectObj) == null ? void 0 : Ke[we.mergeId]) != null && Me.isSelected) && r.value.toggleRowSelection(we, true);
        });
        const re = Ce(E, () => {
          E.value && (E.value.initSelected(ne.auxMatList.map((we) => ({ sn: we.sn, classifyId: we.classifyId }))), pt(() => {
            re();
          }));
        }, { immediate: true });
        pt(() => {
          te();
        });
      }
    }, { immediate: true, deep: true });
    he();
  }, { cu: le, form: oe, FORM: ye } = Pa({ title: "其它入库", formStoreKey: "WMS_INBOUND_APPLICATION_OTHER_MAT_SELF", permission: ob, useDraftCallback: B, defaultForm: u, clearDraftCallback: ae, api: c.edit ? Vu : CX }, y, c.detail), { maxHeight: ce } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => b.value.loaded);
  let se = {};
  c.edit ? se = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : se = { mainBox: ".aux-mat-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: he, maxHeight: be } = Kt(se);
  $(), ye.HOOK.beforeToEdit = async (ne, te) => {
    var de, pe;
    if (c.edit && (await pt(() => {
      var re;
      te.purchaseId = (re = te.purchaseOrder) == null ? void 0 : re.id;
    }), te.logistics || (te.logistics = {}), g.value || Ae((de = te.purchaseOrder) == null ? void 0 : de.details))) {
      const re = JSON.parse(te.jsonData);
      (pe = te.list) != null && pe.length || (te.list = re.list), te.auxMatList = te.list, j(te);
    }
  }, ye.HOOK.afterSubmit = () => {
    c.edit && n("success"), $();
  };
  function me(ne) {
    if (f) {
      const te = [];
      oe.originAuxMatList.forEach((pe) => {
        (!A(ne.classifyId) || ne.classifyId.includes(pe.classifyId)) && (!ne.specification || pe.specification.includes(ne.specification)) && (!ne.color || pe.color === ne.color) && (!ne.brand || pe.brand.includes(ne.brand)) && te.push(pe);
      }), oe.auxMatList = te;
    } else oe.auxMatList = [];
  }
  function ge() {
    if (f) {
      const ne = oe.originAuxMatList;
      oe.auxMatList = ne;
    }
  }
  async function Le() {
    var te;
    A((te = V.value) == null ? void 0 : te.details) && ge();
    const ne = r.value ? r.value.validate() : true;
    if (ne) {
      !S.value && !k.value && ge();
      let de = true;
      const pe = [];
      if (A(m.value) && m.value.forEach((we) => {
        var Me;
        const Ke = (Me = oe.auxMatList) == null ? void 0 : Me.filter((Ne) => Ne.basicClass === we.basicClass);
        A(Ke) && Ke.forEach((Ne) => {
          we.minPrice && Ne.unitPrice < we.minPrice && pe.push({ msg: `${Pe.VL[Ne.basicClass]} ${Ne.serialNumber} ${Ne.classifyName}：单价${Ne.unitPrice} < 异常配置最小值${we.minPrice}` }), we.maxPrice && Ne.unitPrice > we.maxPrice && pe.push({ msg: `${Pe.VL[Ne.basicClass]} ${Ne.serialNumber} ${Ne.classifyName}：单价${Ne.unitPrice} > 异常配置最大值${we.maxPrice}` });
        });
      }), A(pe)) {
        const we = pe.map((Ke) => `<div>${Ke.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + we, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          de = true;
        }).catch((Ke) => {
          de = false;
        });
      }
      if (!de) return false;
      const re = [];
      oe.auxMatList.forEach((we) => {
        var Ke, Me;
        (Ke = we.applyPurchase) != null && Ke.length ? we.applyPurchase.forEach((Ne) => {
          var He, ze;
          (Ne.quantity || Ne.mete) && re.push({ ...we, quantity: Ne.quantity, projectId: Ne.projectId || ((He = Ne.project) == null ? void 0 : He.id), uid: Tt(), brand: Ne.brand, color: Ne.color, mete: Ne.mete, unitPrice: A(Ne.unitPrice) ? Ne.unitPrice : we.unitPrice, amount: A(Ne.unitPrice) ? Be(Ne.mete * Ne.unitPrice, Ze.YUAN) : A(we.unitPrice) ? Be(Ne.mete * we.unitPrice, Ze.YUAN) : void 0, applyPurchaseId: Ne.applyPurchaseId, purchaseDetailId: Ne.purchaseDetailId, purchaseProjectDisabled: Ne.applyPurchaseId ? !((ze = Ne.project) != null && ze.id) : false, workshopId: Ne.workshopId, warehouseId: Ne.warehouseId });
        }) : (g.value || S.value || (Me = oe.selectObj[we.mergeId]) != null && Me.isSelected) && re.push(we);
      }), oe.list = re;
    }
    return A(q.value) ? (ot.error("请先删除标红数据并重新添加"), false) : ne;
  }
  function Ie(ne) {
    return ne.model = ne.spec, r.value.rowInit(ne);
  }
  async function Se(ne) {
    var de;
    $(), V.value = ne, le.props.order = ne, g.value = (ne == null ? void 0 : ne.supplyType) === Ni.PARTY_A.V, S.value = Ae(ne == null ? void 0 : ne.details), Y.value && (oe.auxMatList = [], oe.originAuxMatList = []);
    const te = Ce(E, () => {
      E.value && (E.value.clearByBasicClass(f), pt(() => {
        te();
      }));
    }, { immediate: true });
    (de = ne == null ? void 0 : ne.details) != null && de.length && (oe.auxMatList = ne.details.map((pe) => (pe.uid = Tt(), pe)), oe.originAuxMatList = oe.auxMatList, j(oe)), M.value = true;
  }
  function X() {
    var ne;
    if (A(q.value) && A((ne = le == null ? void 0 : le.submitResult) == null ? void 0 : ne.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    _.value = true;
  }
  function $() {
    M.value = false, g.value = false;
  }
  le.props.import = (ne) => {
    if (oe.inboundWay === si.OPENING_RECEIPT.V) return oe.auxMatList.push.apply(oe.auxMatList, ne);
    v.value || ne.forEach((re) => {
      re.amount = void 0, re.unitPrice = void 0;
    });
    let te = [];
    if (V.value.otherMaterialIds.includes(0) || ne.forEach((re) => {
      let we = false;
      for (const Ke of V.value.otherMaterialIds) if (re.classifyFullPathId.includes(Ke)) {
        we = true;
        break;
      }
      we || te.push(re.classifyName);
    }), te.length > 0) throw te = Array.from(new Set(te)), new Error(`当前订单其它明细中不存在${te.map((re) => `“${re}”`).join("、")}等科目`);
    const de = oe.auxMatList.length;
    ne.map((re, we) => {
      var Ke;
      re.rowIndex = (((Ke = oe.auxMatList) == null ? void 0 : Ke.length) || 0) + we, re.projectId = re.projectId || (we > 0 || de > 0 ? -1 : void 0), re.workshopId = re.workshopId || (we > 0 || de > 0 ? -1 : void 0), re.warehouseId = re.warehouseId || (we > 0 || de > 0 ? -1 : void 0);
    }), oe.auxMatList.push.apply(oe.auxMatList, ne);
    const pe = Ce(E, () => {
      E.value && (E.value.initSelected(ne.map((re) => ({ sn: re.sn, classifyId: re.classifyId }))), pt(() => {
        pe();
      }));
    }, { immediate: true });
  };
  const k = Ee(() => (oe == null ? void 0 : oe.inboundWay) === si.OPENING_RECEIPT.V);
  Ce(() => oe.inboundWay, (ne) => {
    oe.auxMatList = [], oe.list = [];
  });
  async function J() {
    return !!await r.value.validate();
  }
  const z = Z();
  function F() {
    z.value.handleClose();
  }
  async function G() {
    try {
      const ne = At(oe.auxMatList);
      if (Ae(ne)) return;
      ne.forEach((te) => {
        te.amount = Number(te.amount), te.amountExcludingVatFreight = Number(te.amountExcludingVatFreight), te.unitPrice = te.amount / te.mete, te.unitPriceExcludingVatFreight = te.amountExcludingVatFreight / te.mete;
      }), oe.list = await Ut(ne, { basicClass: f, toSmallest: true, toNum: true }, { amount: ["unitPrice", "unitPriceExcludingVatFreight"] }), await u3(oe), le.submitSuccessNotify(), le.resetForm(), F();
    } catch (ne) {
      throw console.log(ne), new Error(ne);
    }
  }
  function ie() {
    n("beginClose");
  }
  le.props.detailImport = (ne) => {
    var Ke;
    const te = [], de = {};
    ne.forEach((Me, Ne) => {
      Me.index = Ne + 1, te.includes(Me.uniqueIdentification) || (te.push(Me.uniqueIdentification), de[Me.uniqueIdentification] = []);
    });
    const pe = oe.originAuxMatList, re = [], we = [];
    for (let Me = 0; Me < te.length; Me++) if (pe.findIndex((Ne) => Ne.uniqueIdentification === te[Me]) > -1) {
      const Ne = ne.filter((ze) => ze.uniqueIdentification === te[Me]), He = pe.find((ze) => ze.uniqueIdentification === te[Me]) || {};
      if (A(Ne)) {
        const ze = [];
        Ne.forEach((Oe, Re) => {
          if (He.classifyId === Oe.classifyId && (!He.specification || He.specification === Oe.specification)) ze.push({ originData: He, ...Oe });
          else {
            const fe = [];
            He.classifyId !== Oe.classifyId && fe.push("物料种类" + Oe.classifyName), He.specification && He.specification !== Oe.specification && fe.push("规格" + Oe.specification), Oe.errorMsg = fe.join("、"), we.push(Oe);
          }
        }), de[te[Me]] = ze;
      }
    } else re.push(te[Me]);
    if (A(re)) {
      ot.error(`采购订单不存在${re.map((Me) => `“${Me}”`).join("、")}${re.length > 1 ? "等" : ""}唯一标识`);
      return;
    }
    if (A(we)) {
      let Me = "";
      we.forEach((Ne) => {
        Me += "序号" + Ne.index + "唯一标识" + Ne.uniqueIdentification + "：" + Ne.errorMsg + `有误
`;
      }), ot.error(Me);
      return;
    }
    T.value = [];
    for (const Me in de) (Ke = de[Me]) == null || Ke.forEach((Ne) => {
      T.value.push(Ne);
    });
    T.value.forEach((Me) => {
      Me.quantity || (Me.quantity = void 0);
    }), T.value.map((Me, Ne) => {
      Me.projectId = Me.projectId || (Ne > 0 ? -1 : void 0), Me.workshopId = Me.workshopId || (Ne > 0 ? -1 : void 0), Me.warehouseId = Me.warehouseId || (Ne > 0 ? -1 : void 0);
    }), h.value = true;
  };
  function ue(ne) {
    const te = oe.originAuxMatList;
    ne.forEach((de) => {
      const pe = te.find((re) => re.uniqueIdentification === de.uniqueIdentification);
      if (A(pe)) {
        const re = pe.applyPurchase[0];
        A(re) ? re.mete || (pe.applyPurchase = []) : pe.applyPurchase = [], pe.applyPurchase.length > 0 && (de.isBranch = true), pe.applyPurchase.push(de), oe.selectObj[pe.mergeId].isSelected = true;
      }
    }), te.forEach((de) => {
      var pe;
      de.mete = ((pe = de == null ? void 0 : de.applyPurchase) == null ? void 0 : pe.reduce((re, we) => re + (we.mete || 0), 0)) || 0;
    });
  }
  return (ne, te) => {
    const de = jt, pe = Ve("common-button"), re = Li, we = Ve("common-drawer"), Ke = _t("permission");
    return qe((w(), Q("div", Qae, [s(Ar, { "basic-class": l(f), "begin-permission": l(Od), "begin-validate": J, edit: c.edit, importAmountRules: ee.value, "show-total": false, "show-total-amount": k.value ? false : !g.value && v.value, "total-amount": x.value, validate: Le, onPurchaseOrderChange: Se }, { beginPreview: p((Me) => [s(wu, { ref_key: "beginConfirmRef", ref: z, submit: G, visible: Me.visible, onSuccess: ie, title: "办公用品", "onUpdate:visible": (Ne) => Me.onUpdateVisible(Ne) }, { default: p(() => [s(vm, { "is-edit": false, "max-height": l(be) + 120 }, null, 8, ["max-height"])]), _: 2 }, 1032, ["visible", "onUpdate:visible"])]), default: p(() => {
      var Me, Ne;
      return [C("div", Zae, [!S.value && l(A)(l(f)) && !l(Ae)((Me = V.value) == null ? void 0 : Me.details) ? (w(), Q("div", Jae, [s(bu, { currentBasicClass: l(f), onBlurQuery: me, onResetQuery: ge }, null, 8, ["currentBasicClass"])])) : H("", true), C("div", Xae, [k.value && l(Ai)(l(Od).download) ? (w(), U(ia, { key: 0, fn: l(is), params: { basicClass: l(Pe).OTHER.V, boolPartyA: g.value }, class: "filter-item" }, { default: p(() => te[2] || (te[2] = [Te(" 办公用品期初入库模版下载 ")])), _: 1, __: [2] }, 8, ["fn", "params"])) : H("", true), !k.value && (g.value || S.value) ? (w(), U(ia, { key: 1, disabled: !l(f), fn: l(gd), params: P.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(l(f) ? l(Pe).VL[l(f)] : "") + "入库模板下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : (w(), U(de, { key: 2, disabled: O.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => {
        var He, ze;
        return [C("span", null, [!g.value && l(A)((He = V.value) == null ? void 0 : He.details) ? (w(), U(ia, { key: 0, disabled: !l(f) || !((ze = V.value) != null && ze.id), fn: l(Ed), params: L.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(l(f) ? l(Pe).VL[l(f)] : "") + "采购明细下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true)])];
      }), _: 1 }, 8, ["disabled"])), k.value ? (w(), Q(Qe, { key: 3 }, [l(Ai)((Ne = l(Od)) == null ? void 0 : Ne.import) ? (w(), U(pe, { key: 0, class: "filter-item", type: "success", onClick: X }, { default: p(() => te[3] || (te[3] = [Te(" 添加物料 ")])), _: 1, __: [3] })) : H("", true)], 64)) : H("", true), s(de, { disabled: O.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => [C("span", null, [!k.value && (g.value || S.value) ? (w(), U(pe, { key: 0, disabled: !O.value, class: "filter-item", type: "success", onClick: X }, { default: p(() => te[4] || (te[4] = [Te(" 添加物料 ")])), _: 1, __: [4] }, 8, ["disabled"])) : H("", true)])]), _: 1 }, 8, ["disabled"])])]), l(oe).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(re, { key: 0, ref_key: "formRef", ref: y, model: l(oe) }, { default: p(() => [s(_d, { ref_key: "tableRef", ref: r, "basic-class": l(f), "bool-apply-purchase": N.value, "bool-party-a": g.value, fillableAmount: v.value, "max-height": l(be), noDetail: S.value, order: V.value }, null, 8, ["basic-class", "bool-apply-purchase", "bool-party-a", "fillableAmount", "max-height", "noDetail", "order"])]), _: 1 }, 8, ["model"])) : (w(), U(vm, { key: l(oe).inboundWay, ref_key: "tableRef", ref: r, "max-height": l(be) }, null, 8, ["max-height"]))];
    }), _: 1 }, 8, ["basic-class", "begin-permission", "edit", "importAmountRules", "show-total-amount", "total-amount"]), s(we, { ref_key: "drawerRef", ref: b, modelValue: _.value, "onUpdate:modelValue": te[0] || (te[0] = (Me) => _.value = Me), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => {
      var Me;
      return [k.value || O.value ? (w(), U(to, { key: l(oe).inboundWay, ref_key: "matSpecRef", ref: E, "basic-class": l(f), "classify-ids": (Me = V.value) == null ? void 0 : Me.otherMaterialIds, "max-height": l(ce), "model-value": l(oe).auxMatList, "row-init-fn": Ie, "table-width": 430, visible: _.value, "auto-selected": "", "expand-query": "" }, null, 8, ["basic-class", "classify-ids", "max-height", "model-value", "visible"])) : H("", true)];
    }), _: 1 }, 8, ["modelValue"]), s(Su, { list: T.value, modelValue: h.value, "onUpdate:modelValue": te[1] || (te[1] = (Me) => h.value = Me), order: V.value, "basic-class": l(f), onSuccess: ue }, null, 8, ["list", "modelValue", "order", "basic-class"])])), [[Ke, l(ob)]]);
  };
} }, l4 = ut($ae, [["__scopeId", "data-v-e57ef72a"]]), ele = Object.freeze(Object.defineProperty({ __proto__: null, default: l4 }, Symbol.toStringTag, { value: "Module" }));
const tle = { style: { overflow: "hidden" } }, ile = { style: {} }, ale = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, lle = { key: 1 }, ole = { key: 1 }, nle = { key: 1 }, sle = { key: 1 }, rle = { key: 1 }, ule = { key: 1 }, cle = { __name: "gas-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.MATERIAL.V, u = ft("matSpecRef"), { priceAbnormal: r } = aa(), { baseUnit: E } = ai(c), { cu: y, form: b } = Wi(), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g, currentCfg: S } = Va(E), h = Z(false), T = Z(null), _ = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true }), Z({ enabled: true, gt: 0, oSize: 5, scrollToTopOnChange: true, immediate: true });
  const f = Z([{ seq: "合计", amountExcludingVatFreight: "-", amount: "-" }]);
  Ce(() => b.auxMatList, ($) => {
    m();
  }, { deep: true, immediate: true });
  function m() {
    var J;
    let $ = 0, k = 0;
    (J = b.auxMatList) == null || J.forEach((z) => {
      $ += Number(z.amount) || 0, k += Number(z.amountExcludingVatFreight) || 0;
    }), $ = $.toFixed(Ze.YUAN), k = k.toFixed(Ze.YUAN), f.value = [{ seq: "合计", amountExcludingVatFreight: k, amount: $ }];
  }
  const { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), Y = /^(?!(0[0-9]{1,}$))[0-9]*[.]{0,}[0-9]{0,}$/, B = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: ($, k) => !!$, message: "核算量必须大于0", trigger: "blur" }], quantity: [{ validator: ($, k) => A(k.measureUnit) ? !!k.quantity : true }], amount: [{ required: true, message: "请输入含税金额", trigger: "change" }, { pattern: Y, message: "含税金额必须大于0", trigger: "blur" }], amountExcludingVatFreight: [{ required: true, message: "请输入不含税金额", trigger: "change" }, { pattern: Y, message: "不含税金额必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, q = Ee(() => {
    let $ = Object.assign({}, B);
    return !n.boolPartyA && n.fillableAmount && ($ = Object.assign($, {})), $;
  }), ae = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: j, cleanUpData: le, wrongCellMask: oe } = ui({ rules: q, ditto: ae, errorMsg: "请修正【气体清单】中标红的信息" });
  function ye() {
  }
  function ce({ row: $, rowIndex: k }) {
    var J, z;
    if ((z = (J = y == null ? void 0 : y.submitResult) == null ? void 0 : J.data) != null && z.includes($.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function se($) {
    const k = Ct({ uid: Tt(), sn: $.sn, specificationLabels: $.specificationLabels, classifySerialNumber: $.classify.serialNumber, serialNumber: $.serialNumber, classifyId: $.classify.id, classifyFullName: $.classify.fullName, classifyName: $.classify.name, classifyParentFullName: $.classify.parentFullName, basicClass: $.classify.basicClass, specification: $.spec, model: $.spec, specificationMap: $.specKV, measureUnit: $.classify.measureUnit, accountingUnit: $.classify.accountingUnit, accountingPrecision: $.classify.accountingPrecision, measurePrecision: $.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, projectId: b.auxMatList.length > 0 ? -1 : void 0, workshopId: b.auxMatList.length > 0 ? -1 : void 0, warehouseId: b.auxMatList.length > 0 ? -1 : void 0, rowIndex: b.auxMatList.length });
    return !n.boolPartyA && n.fillableAmount && (k.unitPrice = void 0, k.amount = void 0), he(k), k;
  }
  function he($) {
    Dt(() => {
      var k, J, z, F;
      $.needFirstCalcTheoryWeight && ($.boolApplyPurchase || (be($), me($)), $.boolApplyPurchase && ((J = (k = b.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected) && ($.quantity = (z = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : z.reduce((G, ie) => G + (ie.quantity || 0), 0), $.theoryTotalWeight = (F = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : F.reduce((G, ie) => G + (ie.theoryTotalWeight || 0), 0)), $.needFirstCalcTheoryWeight = false), M($);
    }), Ce([() => $.boolApplyPurchase, () => $ == null ? void 0 : $.applyPurchase], () => {
      var k, J, z, F;
      $.boolApplyPurchase && ((J = (k = b.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected ? ($.quantity = (z = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : z.reduce((G, ie) => G + (ie.quantity || 0), 0), $.theoryTotalWeight = (F = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : F.reduce((G, ie) => G + (ie.theoryTotalWeight || 0), 0), $.weighingTotalWeight = $.theoryTotalWeight) : ($.quantity = 0, $.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => $, () => {
      var k, J, z;
      if (!n.boolPartyA && !n.noDetail && ((J = (k = b.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected)) {
        const F = (z = b.selectObj[$.mergeId]) == null ? void 0 : z.isSelected;
        b.selectObj[$.mergeId] = { ...b.selectObj[$.mergeId], ...$, mete: $.weighingTotalWeight, isSelected: F };
      }
    }, { deep: true }), $.boolApplyPurchase || (Ce([() => $.length, () => $.width, () => $.thickness, E], () => be($)), Ce([() => $.theoryWeight, () => $.quantity], () => me($))), Ce(() => $.mete, () => {
      ge($);
    });
  }
  async function be($) {
    $.theoryWeight = await na({ classifyId: $.classifyId, name: $.classifyFullName, length: $.length, width: $.width, thickness: $.thickness });
  }
  function me($) {
    A($.theoryWeight) && $.quantity ? ($.theoryTotalWeight = Be($.theoryWeight * $.quantity, E.value.weight.precision), (n.boolPartyA || n.noDetail) && ($.weighingTotalWeight = Be($.theoryWeight * $.quantity, E.value.weight.precision))) : ($.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && ($.weighingTotalWeight = void 0));
  }
  function ge($) {
    A($.unitPrice) && A($.weighingTotalWeight) ? $.amount = Be($.weighingTotalWeight * $.unitPrice, Ze.YUAN) : ($.amount = void 0, $.amountExcludingVatFreight = void 0);
  }
  function Le($, k, J) {
    var z, F, G, ie;
    if ((F = (z = y == null ? void 0 : y.submitResult) == null ? void 0 : z.data) != null && F.includes(J.classifyId)) {
      const ue = (G = y == null ? void 0 : y.submitResult) == null ? void 0 : G.data.findIndex((te) => te === J.classifyId);
      b.auxMatList.filter((te) => te.classifyId === J.classifyId).length === 1 && ((ie = y == null ? void 0 : y.submitResult) == null || ie.data.splice(ue, 1));
    }
    if (u.value ? u.value.delListItem($, k) : b.auxMatList.splice(k, 1), A(b.auxMatList) && b.auxMatList.length > 0) {
      const ue = b.auxMatList[0];
      b.auxMatList[0].projectId = ue.projectId && ue.projectId !== -1 ? ue.projectId : void 0, b.auxMatList[0].workshopId = ue.workshopId && ue.workshopId !== -1 ? ue.workshopId : void 0, b.auxMatList[0].warehouseId = ue.warehouseId && ue.warehouseId !== -1 ? ue.warehouseId : void 0;
    }
  }
  function Ie($, k) {
    var F;
    const J = JSON.parse(JSON.stringify($)), z = Ct({ uid: Tt(), sn: J.sn, specificationLabels: J.specificationLabels, classifySerialNumber: J.classifySerialNumber, serialNumber: J.serialNumber, classifyId: J.classifyId, classifyFullName: J.classifyFullName, classifyName: J.classifyName, classifyParentFullName: J.classifyParentFullName, basicClass: J.basicClass, specification: J.specification, model: J.spec, specificationMap: J.specificationMap, measureUnit: J.measureUnit, accountingUnit: J.accountingUnit, accountingPrecision: J.accountingPrecision, measurePrecision: J.measurePrecision, quantity: J.quantity, thickness: J.thickness, length: J.length, width: J.width, theoryWeight: J.theoryWeight, theoryTotalWeight: J.theoryTotalWeight, weighingTotalWeight: J.weighingTotalWeight, rowIndex: b.auxMatList.length, weightMeasurementMode: J.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : J.unitPrice, mete: J.mete, color: J.color, brand: J.brand, amount: J.amount, amountExcludingVatFreight: J.amountExcludingVatFreight, projectSerialNumber: J.projectSerialNumber, projectId: J.projectId, workshopName: J.workshopName, warehouseName: J.warehouseName, workshopId: J.workshopId, warehouseId: J.warehouseId });
    b.auxMatList.push(z), he(z), (F = u.value) == null || F.initSelected([z]);
  }
  async function Se() {
    const $ = At(b.auxMatList), { validResult: k } = j(b.auxMatList);
    if (k) {
      let J = true;
      const z = [];
      if (A(r.value) && r.value.forEach((F) => {
        var ie;
        const G = (ie = b.auxMatList) == null ? void 0 : ie.filter((ue) => ue.basicClass === F.basicClass);
        A(G) && G.forEach((ue) => {
          F.minPrice && ue.amount < F.minPrice * ue.mete && z.push({ msg: `${Pe.VL[ue.basicClass]} ${ue.serialNumber} ${ue.classifyName}：含税金额${ue.amount} < 异常配置最小值${F.minPrice}*核算量` }), F.maxPrice && ue.amount > F.maxPrice * ue.mete && z.push({ msg: `${Pe.VL[ue.basicClass]} ${ue.serialNumber} ${ue.classifyName}：含税金额${ue.amount} > 异常配置最大值${F.maxPrice}*核算量` });
        });
      }), A(z)) {
        const F = z.map((G) => `<div>${G.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + F, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          J = true;
        }).catch((G) => {
          J = false;
        });
      }
      if (!J) return false;
    }
    if (k) le($), $.forEach((J) => {
    });
    else {
      const J = b.auxMatList.find((z) => z.verify ? Object.values(z.verify).some((F) => F === false) : false);
      J && T.value && pt(() => {
        T.value.scrollToRow(J);
      });
    }
    return k;
  }
  function X($, k) {
  }
  return o({ rowInit: se, rowWatch: he, toggleRowSelection: X, validate: Se, setSelect: ye }), ($, k) => {
    const J = Mt, z = Ve("vxe-column"), F = Ve("vxe-tooltip"), G = ya, ie = Ve("common-input-number"), ue = Ve("common-button"), ne = Ve("vxe-table"), te = Ve("common-drawer"), de = _t("empty-text"), pe = oi;
    return w(), Q("div", null, [qe((w(), Q("div", tle, [(w(), U(ne, { ref_key: "tableRef", ref: T, key: `inbound_${l(c)}`, "cell-class-name": l(oe), "column-config": _.value, data: l(b).auxMatList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": ce, border: "", "footer-data": f.value, "show-footer": "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(z, { type: "expand", width: "60" }, { content: p(({ row: re }) => [C("div", ile, [s(J, { modelValue: re.remark, "onUpdate:modelValue": (we) => re.remark = we, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(re.inboundList) ? (w(), Q("div", ale, [s(l(al), { "basic-class": l(c), list: re.inboundList, material: re, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(z, { title: "序号", type: "seq", width: "55" }), s(z, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: re }) => [s(F, { content: re.classifyParentFullName, disabled: !re.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[de, re.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(z, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: re }) => {
      var we, Ke, Me;
      return [(Ke = (we = l(b).selectObj) == null ? void 0 : we[re.mergeId]) != null && Ke.isSelected && ((Me = l(S)) == null ? void 0 : Me.spec) & l(c) && !re.boolApplyPurchase ? (w(), U(G, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Ne) => l(x)(re) }, null, 8, ["onClick"])) : H("", true), s(F, { content: re.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(re.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(z, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: re }) => [C("span", null, K(re.measureUnit || "-"), 1)]), _: 1 }), s(z, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: re }) => [e.isEdit && l(A)(re.measureUnit) ? (w(), U(ie, { key: 0, modelValue: re.quantity, "onUpdate:modelValue": (we) => re.quantity = we, controls: false, max: 999999999, min: 0, precision: re.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", lle, K(re.quantity), 1))]), _: 1 }), s(z, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: re }) => [C("span", null, K(re.accountingUnit || "-"), 1)]), _: 1 }), s(z, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: re }) => [e.isEdit ? (w(), U(ie, { key: 0, modelValue: re.mete, "onUpdate:modelValue": (we) => re.mete = we, controls: false, max: 999999999, min: 1e-6, precision: re.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", ole, K(re.mete), 1))]), _: 1 }), s(z, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: re }) => [e.isEdit ? (w(), U(J, { key: 0, modelValue: re.color, "onUpdate:modelValue": (we) => re.color = we, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", nle, K(re.color), 1))]), _: 1 }), s(z, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: re }) => [e.isEdit ? (w(), U(J, { key: 0, modelValue: re.brand, "onUpdate:modelValue": (we) => re.brand = we, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", sle, K(re.brand), 1))]), _: 1 }), s(z, { align: "center", field: "amount", title: "含税金额", width: "120" }, { default: p(({ row: re }) => [e.isEdit ? (w(), U(ie, { key: 0, modelValue: re.amount, "onUpdate:modelValue": (we) => re.amount = we, controls: false, min: 0, precision: 2, placeholder: "含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", rle, K(re.amount), 1))]), _: 1 }), s(z, { align: "center", field: "amountExcludingVatFreight", title: "不含税金额", width: "120" }, { default: p(({ row: re }) => [e.isEdit ? (w(), U(ie, { key: 0, modelValue: re.amountExcludingVatFreight, "onUpdate:modelValue": (we) => re.amountExcludingVatFreight = we, controls: false, min: 0, precision: 2, placeholder: "不含税金额", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", ule, K(re.amountExcludingVatFreight), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(b).auxMatList }, null, 8, ["list"])) : (w(), U(z, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: re }) => [C("span", null, K(re.projectFullName || re.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(b).auxMatList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(z, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: re }) => [C("span", null, K(re.workshopName), 1)]), _: 1 }), s(z, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: re }) => [C("span", null, K(re.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(z, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: re, rowIndex: we }) => [s(ue, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Ke) => Ie(re, we) }, null, 8, ["onClick"]), s(ue, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ke) => Le(re.sn, we, re) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "footer-data"]))])), [[pe, h.value]]), s(te, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": k[1] || (k[1] = (re) => Gt(O) ? O.value = re : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": k[0] || (k[0] = (re) => Gt(L) ? L.value = re : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Rm = ut(cle, [["__scopeId", "data-v-7e9bda80"]]), dle = Object.freeze(Object.defineProperty({ __proto__: null, default: Rm }, Symbol.toStringTag, { value: "Module" }));
const mle = { class: "aux-mat-inbound-application-container" }, ple = { class: "filter-container" }, hle = { key: 0, class: "filter-left-box" }, fle = { class: "filter-right-box" }, gle = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success", "beginClose"], setup(e, { emit: o }) {
  const n = o, c = e, u = { inboundWay: si.ORDINARY_STORAGE.V, purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [] };
  Wa(), Io(), Sr();
  const r = Z(), E = Z(), y = Z(), b = Z(), V = Z(), M = Z(false), g = Z(false), S = Z(false), h = Z(false), T = Z([]), _ = Z(false), f = Pe.GAS.V, { priceAbnormal: m, inboundFillWayCfg: R } = aa(), v = Ee(() => R.value ? !!(R.value.amountFillWay === $l.APPLICATION.V && S.value) : false), N = Ee(() => {
    var ne, te;
    return !!((te = (ne = V.value) == null ? void 0 : ne.applyPurchase) != null && te.length);
  }), P = Ee(() => ({ basicClass: f })), L = Ee(() => {
    var ne;
    return f ? { id: (ne = V.value) == null ? void 0 : ne.id, basicClass: f } : {};
  }), O = Ee(() => !!(f && V.value)), x = Ee(() => {
    let ne = 0;
    return g.value || A(le.auxMatList) && le.auxMatList.forEach((te) => {
      A(te.amount) && (ne += +te.amount);
    }), ji(ne, Ze.YUAN);
  });
  yi("matSpecRef", E);
  const I = Z(false), Y = Ee(() => !c.edit && !I.value), ee = Ee(() => ({ amount: [{ validator: (ne, te) => A(te.mete) && A(te.unitPrice) && A(ne) ? +Be(te.mete * te.unitPrice, Ze.YUAN) == +ne : true, message: "金额有误，请手动修改", trigger: "blur" }] })), B = () => {
    I.value = true, ae(le);
  };
  function q() {
    I.value = false, $();
  }
  const ae = (ne) => {
    var de;
    ne.auxMatList = (de = ne.auxMatList) == null ? void 0 : de.map((pe) => Ct(pe));
    const te = Ce(r, (pe) => {
      if (pe) {
        pt(() => {
          var we;
          (we = r.value) == null || we.setSelect();
        }), g.value || ne.auxMatList.forEach((we) => {
          var Ke, Me;
          r.value.rowWatch(we), !g.value && !S.value && ((Me = (Ke = ne.selectObj) == null ? void 0 : Ke[we.mergeId]) != null && Me.isSelected) && r.value.toggleRowSelection(we, true);
        });
        const re = Ce(E, () => {
          E.value && (E.value.initSelected(ne.auxMatList.map((we) => ({ sn: we.sn, classifyId: we.classifyId }))), pt(() => {
            re();
          }));
        }, { immediate: true });
        pt(() => {
          te();
        });
      }
    }, { immediate: true, deep: true });
    se();
  }, { cu: j, form: le, FORM: oe } = Pa({ title: "气体入库", formStoreKey: "WMS_INBOUND_APPLICATION_GAS_SELF", permission: nb, useDraftCallback: B, defaultForm: u, clearDraftCallback: q, api: c.edit ? Vu : PX }, y, c.detail), { maxHeight: ye } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => b.value.loaded);
  let ce = {};
  c.edit ? ce = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : ce = { mainBox: ".aux-mat-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: se, maxHeight: he } = Kt(ce), be = Ee(() => {
    var ne;
    return (ne = le.list) == null ? void 0 : ne.filter((te) => {
      var de, pe;
      return (pe = (de = j == null ? void 0 : j.submitResult) == null ? void 0 : de.data) == null ? void 0 : pe.includes(te.classifyId);
    });
  });
  $(), oe.HOOK.beforeToEdit = async (ne, te) => {
    var de, pe;
    if (c.edit && (await pt(() => {
      var re;
      te.purchaseId = (re = te.purchaseOrder) == null ? void 0 : re.id;
    }), te.logistics || (te.logistics = {}), g.value || Ae((de = te.purchaseOrder) == null ? void 0 : de.details))) {
      const re = JSON.parse(te.jsonData);
      (pe = te.list) != null && pe.length || (te.list = re.list), te.auxMatList = te.list, ae(te);
    }
  }, oe.HOOK.afterSubmit = () => {
    c.edit && n("success"), $();
  };
  function me(ne) {
    if (f) {
      const te = [];
      le.originAuxMatList.forEach((pe) => {
        (!A(ne.classifyId) || ne.classifyId.includes(pe.classifyId)) && (!ne.specification || pe.specification.includes(ne.specification)) && (!ne.color || pe.color === ne.color) && (!ne.brand || pe.brand.includes(ne.brand)) && te.push(pe);
      }), le.auxMatList = te;
    } else le.auxMatList = [];
  }
  function ge() {
    if (le.auxMatList = [], f) {
      const ne = le.originAuxMatList;
      le.auxMatList = ne;
    }
  }
  async function Le() {
    var te;
    A((te = V.value) == null ? void 0 : te.details) && ge();
    const ne = r.value ? r.value.validate() : true;
    if (ne) {
      let de = true;
      const pe = [];
      if (A(m.value) && m.value.forEach((we) => {
        var Me;
        const Ke = (Me = le.auxMatList) == null ? void 0 : Me.filter((Ne) => Ne.basicClass === we.basicClass);
        A(Ke) && Ke.forEach((Ne) => {
          we.minPrice && Ne.unitPrice < we.minPrice && pe.push({ msg: `${Pe.VL[Ne.basicClass]} ${Ne.serialNumber} ${Ne.classifyName}：单价${Ne.unitPrice} < 异常配置最小值${we.minPrice}` }), we.maxPrice && Ne.unitPrice > we.maxPrice && pe.push({ msg: `${Pe.VL[Ne.basicClass]} ${Ne.serialNumber} ${Ne.classifyName}：单价${Ne.unitPrice} > 异常配置最大值${we.maxPrice}` });
        });
      }), A(pe)) {
        const we = pe.map((Ke) => `<div>${Ke.msg}<div>`).join("");
        await zi.confirm("<div>单价异常明细如下,请确认！<div>" + we, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
          de = true;
        }).catch((Ke) => {
          de = false;
        });
      }
      if (!de) return false;
      const re = [];
      le.auxMatList.forEach((we) => {
        var Ke, Me;
        (Ke = we.applyPurchase) != null && Ke.length ? we.applyPurchase.forEach((Ne) => {
          var He, ze;
          (Ne.quantity || Ne.mete) && re.push({ ...we, quantity: Ne.quantity, projectId: Ne.projectId || ((He = Ne.project) == null ? void 0 : He.id), uid: Tt(), brand: Ne.brand, color: Ne.color, mete: Ne.mete, unitPrice: A(Ne.unitPrice) ? Ne.unitPrice : we.unitPrice, amount: A(Ne.unitPrice) ? Be(Ne.mete * Ne.unitPrice, Ze.YUAN) : A(we.unitPrice) ? Be(Ne.mete * we.unitPrice, Ze.YUAN) : void 0, applyPurchaseId: Ne.applyPurchaseId, purchaseDetailId: Ne.purchaseDetailId, purchaseProjectDisabled: Ne.applyPurchaseId ? !((ze = Ne.project) != null && ze.id) : false, workshopId: Ne.workshopId, warehouseId: Ne.warehouseId });
        }) : (g.value || S.value || (Me = le.selectObj[we.mergeId]) != null && Me.isSelected) && re.push(we);
      }), le.list = re;
    }
    return A(be.value) ? (ot.error("请先删除标红数据并重新添加"), false) : ne;
  }
  function Ie(ne) {
    return ne.model = ne.spec, r.value.rowInit(ne);
  }
  async function Se(ne) {
    var de;
    $(), V.value = ne, j.props.order = ne, g.value = (ne == null ? void 0 : ne.supplyType) === Ni.PARTY_A.V, S.value = Ae(ne == null ? void 0 : ne.details), Y.value && (le.auxMatList = [], le.originAuxMatList = []);
    const te = Ce(E, () => {
      E.value && (E.value.clearByBasicClass(f), pt(() => {
        te();
      }));
    }, { immediate: true });
    (de = ne == null ? void 0 : ne.details) != null && de.length && (le.auxMatList = ne.details.map((pe) => (pe.uid = Tt(), pe)), ae(le), le.originAuxMatList = le.auxMatList), M.value = true;
  }
  function X() {
    var ne;
    if (A(be.value) && A((ne = j == null ? void 0 : j.submitResult) == null ? void 0 : ne.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    _.value = true;
  }
  function $() {
    M.value = false, g.value = false;
  }
  j.props.import = (ne) => {
    if (le.inboundWay === si.OPENING_RECEIPT.V) return le.auxMatList.push.apply(le.auxMatList, ne);
    v.value || ne.forEach((re) => {
      re.amount = void 0, re.unitPrice = void 0;
    });
    let te = [];
    if (V.value.otherMaterialIds.includes(0) || ne.forEach((re) => {
      let we = false;
      for (const Ke of V.value.otherMaterialIds) if (re.classifyFullPathId.includes(Ke)) {
        we = true;
        break;
      }
      we || te.push(re.classifyName);
    }), te.length > 0) throw te = Array.from(new Set(te)), new Error(`当前订单其它明细中不存在${te.map((re) => `“${re}”`).join("、")}等科目`);
    const de = le.auxMatList.length;
    ne.map((re, we) => {
      var Ke;
      re.rowIndex = (((Ke = le.auxMatList) == null ? void 0 : Ke.length) || 0) + we, re.projectId = re.projectId || (we > 0 || de > 0 ? -1 : void 0), re.workshopId = re.workshopId || (we > 0 || de > 0 ? -1 : void 0), re.warehouseId = re.warehouseId || (we > 0 || de > 0 ? -1 : void 0);
    }), le.auxMatList.push.apply(le.auxMatList, ne);
    const pe = Ce(E, () => {
      E.value && (E.value.initSelected(ne.map((re) => ({ sn: re.sn, classifyId: re.classifyId }))), pt(() => {
        pe();
      }));
    }, { immediate: true });
  };
  const k = Ee(() => (le == null ? void 0 : le.inboundWay) === si.OPENING_RECEIPT.V);
  Ce(() => le.inboundWay, (ne) => {
    le.auxMatList = [], le.list = [];
  });
  async function J() {
    return !!await r.value.validate();
  }
  const z = Z();
  function F() {
    z.value.handleClose();
  }
  async function G() {
    try {
      const ne = At(le.auxMatList);
      if (Ae(ne)) return;
      ne.forEach((te) => {
        te.amount = Number(te.amount), te.amountExcludingVatFreight = Number(te.amountExcludingVatFreight), te.unitPrice = te.amount / te.mete, te.unitPriceExcludingVatFreight = te.amountExcludingVatFreight / te.mete;
      }), le.list = await Ut(ne, { basicClass: f, toSmallest: true, toNum: true }, { amount: ["unitPrice", "unitPriceExcludingVatFreight"] }), await u3(le), j.submitSuccessNotify(), j.resetForm(), F();
    } catch (ne) {
      throw console.log(ne), new Error(ne);
    }
  }
  function ie() {
    n("beginClose");
  }
  j.props.detailImport = (ne) => {
    var Ke;
    const te = [], de = {};
    ne.forEach((Me, Ne) => {
      Me.index = Ne + 1, te.includes(Me.uniqueIdentification) || (te.push(Me.uniqueIdentification), de[Me.uniqueIdentification] = []);
    });
    const pe = le.originAuxMatList, re = [], we = [];
    for (let Me = 0; Me < te.length; Me++) if (pe.findIndex((Ne) => Ne.uniqueIdentification === te[Me]) > -1) {
      const Ne = ne.filter((ze) => ze.uniqueIdentification === te[Me]), He = pe.find((ze) => ze.uniqueIdentification === te[Me]) || {};
      if (A(Ne)) {
        const ze = [];
        Ne.forEach((Oe, Re) => {
          if (He.classifyId === Oe.classifyId && (!He.specification || He.specification === Oe.specification)) ze.push({ originData: He, ...Oe });
          else {
            const fe = [];
            He.classifyId !== Oe.classifyId && fe.push("物料种类" + Oe.classifyName), He.specification && He.specification !== Oe.specification && fe.push("规格" + Oe.specification), Oe.errorMsg = fe.join("、"), we.push(Oe);
          }
        }), de[te[Me]] = ze;
      }
    } else re.push(te[Me]);
    if (A(re)) {
      ot.error(`采购订单不存在${re.map((Me) => `“${Me}”`).join("、")}${re.length > 1 ? "等" : ""}唯一标识`);
      return;
    }
    if (A(we)) {
      let Me = "";
      we.forEach((Ne) => {
        Me += "序号" + Ne.index + "唯一标识" + Ne.uniqueIdentification + "：" + Ne.errorMsg + `有误
`;
      }), ot.error(Me);
      return;
    }
    T.value = [];
    for (const Me in de) (Ke = de[Me]) == null || Ke.forEach((Ne) => {
      T.value.push(Ne);
    });
    T.value.forEach((Me) => {
      Me.quantity || (Me.quantity = void 0);
    }), T.value.map((Me, Ne) => {
      Me.projectId = Me.projectId || (Ne > 0 ? -1 : void 0), Me.workshopId = Me.workshopId || (Ne > 0 ? -1 : void 0), Me.warehouseId = Me.warehouseId || (Ne > 0 ? -1 : void 0);
    }), h.value = true;
  };
  function ue(ne) {
    const te = le.originAuxMatList;
    ne.forEach((de) => {
      const pe = te.find((re) => re.uniqueIdentification === de.uniqueIdentification);
      if (A(pe)) {
        const re = pe.applyPurchase[0];
        A(re) ? re.mete || (pe.applyPurchase = []) : pe.applyPurchase = [], pe.applyPurchase.length > 0 && (de.isBranch = true), pe.applyPurchase.push(de), le.selectObj[pe.mergeId].isSelected = true;
      }
    }), te.forEach((de) => {
      var pe;
      de.mete = ((pe = de == null ? void 0 : de.applyPurchase) == null ? void 0 : pe.reduce((re, we) => re + (we.mete || 0), 0)) || 0;
    });
  }
  return (ne, te) => {
    const de = Ve("common-button"), pe = jt, re = Li, we = Ve("common-drawer"), Ke = _t("permission");
    return qe((w(), Q("div", mle, [s(Ar, { "basic-class": l(f), "begin-permission": l(Pd), "begin-validate": J, edit: c.edit, importAmountRules: ee.value, "show-total": false, "show-total-amount": k.value ? false : !g.value && v.value, "total-amount": x.value, validate: Le, onPurchaseOrderChange: Se }, { beginPreview: p((Me) => [s(wu, { ref_key: "beginConfirmRef", ref: z, submit: G, visible: Me.visible, onSuccess: ie, title: "气体", "onUpdate:visible": (Ne) => Me.onUpdateVisible(Ne) }, { default: p(() => [s(Rm, { "is-edit": false, "max-height": l(he) + 120 }, null, 8, ["max-height"])]), _: 2 }, 1032, ["visible", "onUpdate:visible"])]), default: p(() => {
      var Me, Ne, He, ze;
      return [C("div", ple, [!S.value && l(A)(l(f)) && !l(Ae)((Me = V.value) == null ? void 0 : Me.details) ? (w(), Q("div", hle, [s(bu, { currentBasicClass: l(f), onBlurQuery: me, onResetQuery: ge }, null, 8, ["currentBasicClass"])])) : H("", true), C("div", fle, [k.value && l(Ai)(l(Pd).download) ? (w(), U(ia, { key: 0, fn: l(is), params: { basicClass: l(Pe).GAS.V, boolPartyA: g.value }, class: "filter-item" }, { default: p(() => te[2] || (te[2] = [Te("气体期初入库模版下载 ")])), _: 1, __: [2] }, 8, ["fn", "params"])) : H("", true), !k.value && (g.value || S.value) ? (w(), U(ia, { key: 1, disabled: !l(f), fn: l(gd), params: P.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(l(f) ? l(Ge).VL[l(f)] : "") + "入库模板下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), !g.value && l(A)((Ne = V.value) == null ? void 0 : Ne.details) ? (w(), U(ia, { key: 2, disabled: !l(f) || !((He = V.value) != null && He.id), fn: l(Ed), params: L.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(l(f) ? l(Ge).VL[l(f)] : "") + "采购明细下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), k.value ? (w(), Q(Qe, { key: 3 }, [l(Ai)((ze = l(Pd)) == null ? void 0 : ze.import) ? (w(), U(de, { key: 0, class: "filter-item", type: "success", onClick: X }, { default: p(() => te[3] || (te[3] = [Te("添加物料 ")])), _: 1, __: [3] })) : H("", true)], 64)) : (w(), U(pe, { key: 4, disabled: O.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => [C("span", null, [!k.value && (g.value || S.value) ? (w(), U(de, { key: 0, disabled: !O.value, class: "filter-item", type: "success", onClick: X }, { default: p(() => te[4] || (te[4] = [Te(" 添加物料 ")])), _: 1, __: [4] }, 8, ["disabled"])) : H("", true)])]), _: 1 }, 8, ["disabled"]))])]), l(le).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(re, { key: 0, ref_key: "formRef", ref: y, model: l(le) }, { default: p(() => [s(_d, { ref_key: "tableRef", ref: r, "basic-class": l(f), "bool-apply-purchase": N.value, "bool-party-a": g.value, fillableAmount: v.value, "max-height": l(he), noDetail: S.value, order: V.value }, null, 8, ["basic-class", "bool-apply-purchase", "bool-party-a", "fillableAmount", "max-height", "noDetail", "order"])]), _: 1 }, 8, ["model"])) : (w(), U(Rm, { key: l(le).inboundWay, ref_key: "tableRef", ref: r, "max-height": l(he) }, null, 8, ["max-height"]))];
    }), _: 1 }, 8, ["basic-class", "begin-permission", "edit", "importAmountRules", "show-total-amount", "total-amount"]), s(we, { ref_key: "drawerRef", ref: b, modelValue: _.value, "onUpdate:modelValue": te[0] || (te[0] = (Me) => _.value = Me), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => {
      var Me;
      return [k.value || O.value ? (w(), U(to, { key: l(le).inboundWay, ref_key: "matSpecRef", ref: E, "basic-class": l(f), "classify-ids": (Me = V.value) == null ? void 0 : Me.otherMaterialIds, "max-height": l(ye), "model-value": l(le).auxMatList, "row-init-fn": Ie, "table-width": 430, visible: _.value, "auto-selected": "", "expand-query": "" }, null, 8, ["basic-class", "classify-ids", "max-height", "model-value", "visible"])) : H("", true)];
    }), _: 1 }, 8, ["modelValue"]), s(Su, { list: T.value, modelValue: h.value, "onUpdate:modelValue": te[1] || (te[1] = (Me) => h.value = Me), order: V.value, "basic-class": l(f), onSuccess: ue }, null, 8, ["list", "modelValue", "order", "basic-class"])])), [[Ke, l(nb)]]);
  };
} }, o4 = ut(gle, [["__scopeId", "data-v-debf7620"]]), Ele = Object.freeze(Object.defineProperty({ __proto__: null, default: o4 }, Symbol.toStringTag, { value: "Module" }));
function Ift(e) {
  return W({ module: "wms", url: "inbound/application/steel", method: "post", data: e });
}
function Cft(e) {
  return W({ module: "wms", url: "inbound/application/auxiliary-material", method: "post", data: e });
}
function Pft(e) {
  return W({ module: "wms", url: "inbound/application/other-material", method: "post", data: e });
}
function Oft(e) {
  return W({ module: "wms", url: "inbound/application/gas", method: "post", data: e });
}
function yle(e) {
  return W({ module: "wms", url: "inbound/manufactured/application/save", method: "post", data: e });
}
function Tle(e) {
  return W({ module: "wms", url: "inbound/application/record/raw-materials", method: "get", params: e });
}
function _le(e) {
  return W({ module: "wms", url: "inbound/application/record/raw-materials", method: "put", data: e });
}
function ble(e) {
  return W({ module: "wms", url: "inbound/manufactured/application/update", method: "put", data: e });
}
function Vle(e) {
  return W({ module: "wms", url: "inbound/application/record/raw-materials", method: "delete", data: e });
}
function wle(e) {
  return W({ module: "wms", url: `inbound/application/record/raw-materials/${e}`, method: "get" });
}
