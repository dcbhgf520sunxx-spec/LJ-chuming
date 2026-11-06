import { useStore as Oe } from "vuex";
import { ref as h } from "vue";
import { inject as F } from "vue";
import { provide as we } from "vue";
import { computed as L } from "vue";
import { nextTick as $ } from "vue";
import { watchEffect as ke } from "vue";
import { ElMessageBox as Le } from "element-plus";
import { ElMessage as Be } from "element-plus";
import { resolveComponent as R } from "vue";
import { resolveDirective as qe } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as u } from "vue";
import { renderSlot as De } from "vue";
import { createBlock as f } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as C } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as b } from "vue";
import { createVNode as i } from "vue";
import { normalizeStyle as He } from "vue";
import { Fragment as _ } from "vue";
import { renderList as ze } from "vue";
import { toDisplayString as Fe } from "vue";
import { withModifiers as B } from "vue";
import { withDirectives as $e } from "vue";
import { ElFormItem as Ke } from "element-plus";
import { ElInput as Ye } from "element-plus";
import { ElCheckbox as Ge } from "element-plus";
import { ElTag as Je } from "element-plus";
import { ElTableColumn as We } from "element-plus";
import { ElForm as Ze } from "element-plus";
import { _ as Qe, jZ as Xe, jJ as S, bD as el, bR as K, jU as Y, jV as G, jT as J, gD as ll, tB as al, vk as tl, vl as sl, cP as g, cO as il, jl as ol, V as W, i as q, ai as rl, t0 as Z, vg as Q, fE as X, jS as ee, vA as nl, ap as le, lo as dl, fD as ul, cU as pl, D as ml, bG as cl, jP as fl, fv as ae, R as bl, S as gl, jG as yl, k5 as hl, jH as vl, bv as Vl, uP as te, vt as Il, vu as Tl } from "../../../../../shared/runtime.js";
const Ul = { style: { display: "flex" } }, El = { style: { flex: "1", "text-align": "right" } }, xl = { class: "main-content" }, Ml = { class: "form-left" }, Cl = { class: "order-details" }, Al = { class: "flex-rss child-mr-10" }, _l = { class: "flex-rss child-mr-10" }, Sl = { class: "flex-rss child-mr-10" }, jl = { class: "flex-rss child-mr-10" }, Nl = { class: "input-underline flex-rss child-mr-10" }, Pl = { class: "input-underline flex-rss child-mr-10" }, Rl = { class: "form-right" }, Ol = { class: "right-head flex-rbs" }, wl = { class: "assoc-preparation-list" }, kl = { key: 0, class: "opt-content" }, Ll = { __name: "raw-material", props: { edit: { type: Boolean, default: false }, dialogVisible: { type: Boolean, default: false }, detail: { type: Object }, maxHeight: { type: Number, default: 100 }, heightStyle: { type: String, default: "" }, isPassedEdit: { type: Boolean, default: false } }, emits: "success", setup(v, { expose: se, emit: ie }) {
  const O = Oe(), oe = { boolTemporaryStorage: false, boolDetail: false, serialNumber: void 0, boolAnnual: true, boolPartyA: false, supplyType: Xe.SELF.V, purchaseType: S.RAW_MATERIAL.V, basicClass: null, isAllMaterial: false, auxMaterialIds: void 0, isAllOtherMaterial: false, otherMaterialIds: void 0, projectIds: void 0, projectId: void 0, requisitionsSN: void 0, supplierId: void 0, branchCompanyId: void 0, mete: void 0, amount: void 0, invoiceType: el.SPECIAL.V, taxRate: void 0, weightMeasurementMode: K.THEORY.V, logisticsTransportType: Y.FREIGHT.V, logisticsPayerType: G.SUPPLIER.V, purchaseOrderPaymentMode: J.ARRIVAL.V, projectAttribute: ll.SELF_SUPPORT.V, remark: void 0, attachments: void 0, attachmentIds: void 0, list: [], level: void 0 }, re = ie, E = h(), D = h([]), ne = F("supplyUsedProject"), de = F("projectAllType"), c = v, { cu: x, form: e, FORM: V } = al({ title: "采购合同", formStore: !c.edit, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER", defaultForm: oe, useDraftCallback: ue, clearDraftCallback: pe, api: c.edit ? tl : sl }, E, c.detail);
  we("cu", x);
  function ue() {
  }
  function pe() {
  }
  const me = (s, a, r) => {
    e.invoiceType || e.invoiceType === 0 ? r() : r(new Error("请选择发票及税率"));
  }, ce = { serialNumber: [{ max: 30, message: "订单编号长度不可超过30位", trigger: "blur" }], boolAnnual: [{ required: true, message: "请选择合同类型", trigger: "change" }], supplyType: [{ required: true, message: "请选择供货类型", trigger: "change" }], level: [{ required: true, message: "请选择采购目的", trigger: "change" }], purchaseType: [{ required: true, message: "请选择物料种类", trigger: "change" }], basicClass: [{ required: true, message: "请选择物料类型", trigger: "change" }], supplierId: [{ required: true, message: "请选择供应商", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择签订主体", trigger: "change" }], projectAttribute: [{ required: true, message: "请选择项目属性", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }] }, fe = { supplierId: [{ required: true, message: "请选择供应商", trigger: "change" }] }, be = { weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], logisticsTransportType: [{ required: true, message: "请选择物流运输方式", trigger: "change" }], logisticsPayerType: [{ required: true, message: "请选择物流费用承担方", trigger: "change" }], purchaseOrderPaymentMode: [{ required: true, message: "请选择订单类型", trigger: "change" }], invoiceType: [{ required: true, validator: me, trigger: "change" }], taxRate: [{ max: 2, message: "请输入税率", trigger: "blur" }], mete: [{ required: true, message: "请填写合同量", trigger: "blur" }], amount: [{ required: true, message: "请填写合同额", trigger: "blur" }] }, ge = { projectIds: [{ required: true, message: "请选择项目", trigger: "change" }] }, ye = { auxMaterialIds: [{ required: true, validator: (s, a, r) => {
    e.isAllMaterial || a ? r() : r(new Error("请选择辅材"));
  }, trigger: "change" }] }, he = { otherMaterialIds: [{ required: true, validator: (s, a, r) => {
    e.isAllOtherMaterial || a ? r() : r(new Error("请选择办公用品"));
  }, trigger: "change" }] }, ve = L(() => {
    $(() => {
      E.value && E.value.clearValidate();
    });
    const s = {};
    return Object.assign(s, ce), e.boolPartyA ? (Object.assign(s, ge), delete s.supplierId) : Object.assign(s, be), e.basicClass & g.MATERIAL.V && Object.assign(s, ye), e.basicClass & g.OTHER.V && Object.assign(s, he), e.boolTemporaryStorage ? fe : s;
  });
  ke(() => {
    c.dialogVisible && $(() => {
      E.value && E.value.clearValidate();
    });
  });
  function Ve(s) {
    s === S.MANUFACTURED.V && (e.boolAnnual = ee.NOT_YEAR.V);
  }
  function Ie(s) {
    e.branchCompany = s, e.projectIds = [];
  }
  function Te(s) {
    let a = [];
    q(s == null ? void 0 : s.basicClass) && (a = Vl.getBits(g.ENUM, s.basicClass, "V"));
    const r = [];
    for (let o = 0; o < a.length; o++) r.push({ V: a[o] });
    const m = [];
    for (const o in g.ENUM) r.findIndex((d) => d.V & g.ENUM[o].V) < 0 && (m.includes(g.ENUM[o].V) || m.push(g.ENUM[o].V));
    D.value = e.id ? m : [], e.annualContractId = s == null ? void 0 : s.annualContractId;
  }
  function Ue() {
    e.boolSysgen && (N.value.supplierId === e.supplierId ? e.serialNumber = N.value.serialNumber : e.serialNumber = void 0);
  }
  const Ee = L(() => e.preparationSNList && e.preparationSNList.length > 0), y = h(), A = h(/* @__PURE__ */ new Map()), I = h([]), H = L(() => {
    let s = [];
    return y.value ? s = A.value.get(y.value) : s = I.value, s || [];
  }), T = h(false), j = h([]), N = h({});
  V.HOOK.afterToAdd = () => {
  }, V.HOOK.afterToCU = () => {
    e.clickTime = (/* @__PURE__ */ new Date()).getTime();
  }, V.HOOK.beforeToCU = () => {
    y.value = void 0, A.value = /* @__PURE__ */ new Map(), I.value = [];
  }, V.HOOK.beforeToEdit = async (s, a) => {
    N.value.serialNumber = a.serialNumber, N.value.supplierId = a.supplierId, console.log(a, "form"), Array.isArray(a.preparationList) && a.preparationList.length > 0 && (await il(a.preparationList), await ol(a.preparationList, { toNum: true }), a.preparationList.forEach((r) => {
      const m = A.value.get(r.preparationSN);
      m ? m.push(r) : A.value.set(r.preparationSN, [r]);
      const o = I.value.findIndex((d) => d.serialNumber === r.serialNumber && d.color === r.color && d.brand === r.brand);
      if (o > -1) I.value[o].quantity += r.quantity, I.value[o].mete += r.mete, I.value[o].preparationSNList.push(r.preparationSN);
      else {
        const d = W(r);
        d.preparationSNList = [r.preparationSN], I.value.push(d);
      }
    }));
  }, V.HOOK.beforeSubmit = async () => {
    var m;
    if (e.materialType = void 0, e.list = [], !z()) return false;
    const s = [], a = [];
    if (e.projectId && (!c.edit || c.edit && e.projectId !== e.originEditProjectId) && a.push(e.projectId), q(e.projectIds) && (!c.edit || c.edit && !rl(e.projectIds, e.originEditProjectIds))) for (let o = 0; o < e.projectIds.length; o++) {
      const d = e.projectIds[o];
      (!c.edit || c.edit && !((m = e.originEditProjectIds) != null && m.includes(d))) && a.push(d);
    }
    for (let o = 0; o < a.length; o++) {
      const d = a[o];
      if (ne.value.includes(d) && s.findIndex((M) => M.id === d) < 0) {
        const M = de.value.find((P) => P.id === d);
        s.push(M);
      }
    }
    let r = true;
    if (q(s)) {
      const o = s.map((d) => d.name).join("、");
      await Le.confirm(`您已经为《${o}》创建过采购，是否继续创建，请确认?`, "提示", { distinguishCancelAndClose: true, confirmButtonText: "确认", cancelButtonText: "取消" }).then(() => {
        r = true;
      }).catch((d) => {
        r = false;
      });
    }
    return r;
  }, V.HOOK.afterSubmit = async () => {
    D.value = [], await O.dispatch("approval_list/fetchTSNum", Z.PURCHASE_ORDER_V2.V), await O.dispatch("approval_list/fetchSubNum", Z.PURCHASE_ORDER_V2.V), await O.dispatch("config/fetchSupplyUsedProject"), re("success");
  }, x.submitFormFormat = (s) => (s.attachmentIds = s.attachments ? s.attachments.map((a) => a.id) : void 0, s.auxMaterialIds = s.isAllMaterial ? [0] : s.auxMaterialIds, s.otherMaterialIds = s.isAllOtherMaterial ? [0] : s.otherMaterialIds, s.projectId && (s.projectIds = [s.projectId]), s);
  function xe(s) {
    if (!z()) return false;
    s !== y.value ? y.value = s : y.value = void 0;
  }
  function z() {
    return T.value ? (Be.warning({ message: "请先“保存”或“取消编辑”分拣信息", duration: 4e3 }), false) : true;
  }
  function Me() {
    T.value = true, j.value = W(H.value);
  }
  function Ce(s, a) {
    j.value.splice(a, 1);
  }
  function Ae() {
    T.value = false;
  }
  function _e() {
    T.value = false, A.value.set(y.value, j.value);
  }
  async function w(s) {
    try {
      e.boolTemporaryStorage = !!s, c.isPassedEdit && c.edit && (e.dataStatus === te.PASSED.V && (x.api = Il), e.dataStatus === te.UNDER_APPROVAL.V && (x.api = Tl)), await x.submit();
    } catch (a) {
      console.log("采购合同提交", a);
    }
  }
  return se({ submit: w }), (s, a) => {
    const r = R("common-button"), m = R("common-radio"), o = Ke, d = Ye, M = Ge, P = R("common-input-number"), Se = Je, k = We, je = R("common-table"), Ne = Ze, Pe = qe("split");
    return p(), U("div", null, [u("div", Ul, [u("div", null, [De(s.$slots, "chose", {}, void 0, true)]), u("div", El, [(v.isPassedEdit ? v.isPassedEdit && !c.edit : c.edit) ? (p(), f(r, { key: 0, loading: l(x).status.edit === l(V).STATUS.PROCESSING, size: "default", type: "primary", onClick: a[0] || (a[0] = (t) => w(l(Q).NO.V)) }, { default: n(() => a[26] || (a[26] = [C(" 提 交 ")])), _: 1, __: [26] }, 8, ["loading"])) : b("", true), (v.isPassedEdit ? v.isPassedEdit && !c.edit : c.edit) ? (p(), f(r, { key: 1, size: "default", type: "warning", onClick: a[1] || (a[1] = (t) => w(l(Q).YES.V)) }, { default: n(() => a[27] || (a[27] = [C(" 暂 存 ")])), _: 1, __: [27] })) : b("", true)])]), u("div", xl, [i(Ne, { ref_key: "formRef", ref: E, model: l(e), rules: ve.value, "label-position": "right", "label-width": "110px", size: "small" }, { default: n(() => [u("div", { style: He(`height: ${v.maxHeight - 90}px`), class: "form-content" }, [u("div", Ml, [u("div", Cl, [i(o, { class: "el-form-item-18", label: "采购目的", prop: "level" }, { default: n(() => [i(m, { modelValue: l(e).level, "onUpdate:modelValue": a[2] || (a[2] = (t) => l(e).level = t), disabled: !!l(e).boolUsed, options: l(X).ENUM, size: "small", type: "enumSL" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), i(o, { class: "el-form-item-3", label: "采购类型", prop: "purchaseType" }, { default: n(() => [u("div", Al, [i(m, { modelValue: l(e).purchaseType, "onUpdate:modelValue": a[3] || (a[3] = (t) => l(e).purchaseType = t), disabled: l(e).id && !!l(e).boolUsed, options: l(S).ENUM, type: "enum", onChange: Ve }, null, 8, ["modelValue", "disabled", "options"])])]), _: 1 }), l(e).purchaseType !== l(S).MANUFACTURED.V ? (p(), f(o, { key: 0, class: "el-form-item-2", label: "合同类型", prop: "boolAnnual" }, { default: n(() => [i(m, { modelValue: l(e).boolAnnual, "onUpdate:modelValue": a[4] || (a[4] = (t) => l(e).boolAnnual = t), disabled: l(e).id && !!l(e).boolUsed, options: l(ee).ENUM, type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })) : b("", true), i(o, { class: "el-form-item-1", label: "采购合同编号", prop: "serialNumber" }, { default: n(() => [i(d, { modelValue: l(e).serialNumber, "onUpdate:modelValue": a[5] || (a[5] = (t) => l(e).serialNumber = t), modelModifiers: { trim: true }, disabled: l(e).boolUsed, class: "input-underline", maxlength: "30", placeholder: "可输入采购合同编号（不填写则自动生成）", size: "small" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), i(o, { class: "el-form-item-3", label: "物料种类", prop: "basicClass" }, { default: n(() => [u("div", _l, [i(nl, { modelValue: l(e).basicClass, "onUpdate:modelValue": a[6] || (a[6] = (t) => l(e).basicClass = t), disabled: l(e).boolUsed, type: l(e).purchaseType, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择物料种类", style: { flex: "auto" } }, null, 8, ["modelValue", "disabled", "type"])])]), _: 1 }), l(e).basicClass & l(g).MATERIAL.V ? (p(), f(o, { key: 1, class: "el-form-item-5", label: "辅材明细", prop: "auxMaterialIds" }, { default: n(() => [u("div", Sl, [i(M, { modelValue: l(e).isAllMaterial, "onUpdate:modelValue": a[7] || (a[7] = (t) => l(e).isAllMaterial = t), disabled: !!l(e).boolUsed, border: "", label: "所有辅材", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), i(le, { modelValue: l(e).auxMaterialIds, "onUpdate:modelValue": a[8] || (a[8] = (t) => l(e).auxMaterialIds = t), "basic-class": l(g).MATERIAL.V, "collapse-tags": false, deep: 2, disabled: l(e).boolUsed ? !!l(e).boolUsed : l(e).isAllMaterial, class: "input-underline", clearable: "", isDefaultExpand: "", multiple: "", placeholder: "请选择辅材", separator: " > ", size: "small", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : b("", true), l(e).basicClass & l(g).OTHER.V ? (p(), f(o, { key: 2, class: "el-form-item-5", label: "办公用品", prop: "otherMaterialIds" }, { default: n(() => [u("div", jl, [i(M, { modelValue: l(e).isAllOtherMaterial, "onUpdate:modelValue": a[9] || (a[9] = (t) => l(e).isAllOtherMaterial = t), disabled: !!l(e).boolUsed, border: "", label: "所有办公用品", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), i(le, { modelValue: l(e).otherMaterialIds, "onUpdate:modelValue": a[10] || (a[10] = (t) => l(e).otherMaterialIds = t), "basic-class": l(g).OTHER.V, "collapse-tags": false, deep: 2, disabled: l(e).boolUsed ? !!l(e).boolUsed : l(e).isAllOtherMaterial, class: "input-underline", clearable: "", isDefaultExpand: "", multiple: "", placeholder: "请选择办公用品", separator: " > ", size: "small", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : b("", true), i(o, { class: "el-form-item-7", label: "供应商", prop: "supplierId" }, { default: n(() => [i(dl, { modelValue: l(e).supplierId, "onUpdate:modelValue": a[11] || (a[11] = (t) => l(e).supplierId = t), "basic-class": l(e).basicClass, disabled: l(e).id && !!l(e).boolUsed, isAnnual: l(e).boolAnnual, type: l(e).purchaseType, class: "input-underline", clearable: "", filterable: "", mode: "contain", onChange: Ue, onInfoChange: Te }, null, 8, ["modelValue", "basic-class", "disabled", "isAnnual", "type"])]), _: 1 }), i(o, { class: "el-form-item-18", label: "签订主体", prop: "branchCompanyId" }, { default: n(() => [i(ul, { modelValue: l(e).branchCompanyId, "onUpdate:modelValue": a[12] || (a[12] = (t) => l(e).branchCompanyId = t), defaultLevel: l(e).level, disabled: l(e).boolUsed || !l(e).level, class: "input-underline", placeholder: "合同签订主体", style: { width: "100%" }, onCurrentChange: Ie }, null, 8, ["modelValue", "defaultLevel", "disabled"])]), _: 1 }), l(e).boolPartyA ? b("", true) : (p(), U(_, { key: 3 }, [i(o, { class: "el-form-item-8", label: "合同量", prop: "mete", style: { display: "inline-flex", width: "320px" } }, { default: n(() => [u("div", Nl, [i(P, { modelValue: l(e).mete, "onUpdate:modelValue": a[13] || (a[13] = (t) => l(e).mete = t), controls: false, disabled: l(e).boolUsed, max: 999999999999, step: 1, autocomplete: "off", placeholder: "请填写合同量", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"]), i(pl, { modelValue: l(e).meteUnit, "onUpdate:modelValue": a[14] || (a[14] = (t) => l(e).meteUnit = t), disabled: l(e).boolUsed, clearable: "", filterable: "", size: "small", style: { width: "80px", flex: "none" } }, null, 8, ["modelValue", "disabled"])])]), _: 1 }), i(o, { class: "el-form-item-9", label: "合同额", "label-width": "80px", prop: "amount", style: { display: "inline-flex", width: "240px" } }, { default: n(() => [u("div", Pl, [i(P, { modelValue: l(e).amount, "onUpdate:modelValue": a[15] || (a[15] = (t) => l(e).amount = t), controls: false, disabled: !!l(e).boolUsed, max: 999999999999, precision: l(ml).YUAN, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写合同额", style: { width: "100%" } }, null, 8, ["modelValue", "disabled", "precision"]), a[28] || (a[28] = u("span", null, "元", -1))])]), _: 1 }), i(o, { class: "el-form-item-10", label: "发票及税率", prop: "invoiceType" }, { default: n(() => [i(cl, { invoiceType: l(e).invoiceType, "onUpdate:invoiceType": a[16] || (a[16] = (t) => l(e).invoiceType = t), taxRate: l(e).taxRate, "onUpdate:taxRate": a[17] || (a[17] = (t) => l(e).taxRate = t), classification: l(e).basicClass, disabled: l(e).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification", "disabled"])]), _: 1 }), l(e).basicClass & l(fl).STEEL.V ? (p(), U(_, { key: 0 }, [i(o, { class: "el-form-item-11", label: "计量方式", prop: "weightMeasurementMode" }, { default: n(() => [i(m, { modelValue: l(e).weightMeasurementMode, "onUpdate:modelValue": a[18] || (a[18] = (t) => l(e).weightMeasurementMode = t), disabled: l(e).boolUsed, options: l(K).ENUM, props: { key: "K", label: "SL", value: "V" }, size: "small", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), i(o, { class: "el-form-item-13", label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: n(() => [i(m, { modelValue: l(e).purchaseOrderPaymentMode, "onUpdate:modelValue": a[19] || (a[19] = (t) => l(e).purchaseOrderPaymentMode = t), disabled: l(e).boolUsed, options: l(J).ENUM, size: "small", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })], 64)) : b("", true), i(o, { class: "el-form-item-16", label: "物流运输方式", prop: "logisticsTransportType" }, { default: n(() => [i(m, { modelValue: l(e).logisticsTransportType, "onUpdate:modelValue": a[20] || (a[20] = (t) => l(e).logisticsTransportType = t), disabled: l(e).boolUsed, options: l(Y).ENUM, size: "small", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), i(o, { class: "el-form-item-17", label: "物流费用承担", prop: "logisticsPayerType" }, { default: n(() => [i(m, { modelValue: l(e).logisticsPayerType, "onUpdate:modelValue": a[21] || (a[21] = (t) => l(e).logisticsPayerType = t), disabled: l(e).boolUsed, options: l(G).ENUM, size: "small", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })], 64)), l(e).level === l(X).CONSTRUCTION_SITE.V || l(e).purchaseType === l(S).MANUFACTURED.V ? (p(), f(o, { key: 4, class: "el-form-item-4", label: "选择项目", "label-width": "80px", prop: "projectId" }, { default: n(() => [i(l(ae), { modelValue: l(e).projectId, "onUpdate:modelValue": a[22] || (a[22] = (t) => l(e).projectId = t), branchCompanyId: l(e).branchCompanyId, disabled: l(e).boolUsed ? !!l(e).boolUsed : !l(e).branchCompanyId, projectAttribute: l(e).projectAttribute, class: "input-underline", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "branchCompanyId", "disabled", "projectAttribute"])]), _: 1 })) : (p(), f(o, { key: 5, class: "el-form-item-4", label: "选择项目", "label-width": "80px", prop: "projectIds" }, { default: n(() => [i(l(ae), { modelValue: l(e).projectIds, "onUpdate:modelValue": a[23] || (a[23] = (t) => l(e).projectIds = t), branchCompanyId: l(e).branchCompanyId, disabled: l(e).boolUsed ? !!l(e).boolUsed : !l(e).branchCompanyId, projectAttribute: l(e).projectAttribute, class: "input-underline", clearable: "", multiple: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "branchCompanyId", "disabled", "projectAttribute"])]), _: 1 })), i(o, { class: "el-form-item-14", "label-width": "0", prop: "remark" }, { default: n(() => [i(d, { modelValue: l(e).remark, "onUpdate:modelValue": a[24] || (a[24] = (t) => l(e).remark = t), disabled: l(e).boolUsed, rows: 3, maxlength: "1000", placeholder: "备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), i(bl, { files: l(e).attachments, "onUpdate:files": a[25] || (a[25] = (t) => l(e).attachments = t), "file-classify": l(gl).PURCHASE_ORDER_ATT.V, showView: true, class: "el-form-item-15", "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])])]), Ee.value ? (p(), U(_, { key: 0 }, [a[33] || (a[33] = u("div", { class: "vertical-dashed-divider" }, null, -1)), u("div", Rl, [u("div", Ol, [u("span", wl, [a[29] || (a[29] = u("span", { class: "label" }, "关联备料单", -1)), (p(true), U(_, null, ze(l(e).preparationSNList, (t) => (p(), f(Se, { key: t, effect: y.value === t ? "dark" : "plain", class: "preparation-sn-tag", onClick: (Re) => xe(t) }, { default: n(() => [C(Fe(t), 1)]), _: 2 }, 1032, ["effect", "onClick"]))), 128))]), y.value ? (p(), U("span", kl, [T.value ? (p(), U(_, { key: 1 }, [i(r, { size: "default", onClick: B(Ae, ["stop"]) }, { default: n(() => a[31] || (a[31] = [C("取消编辑")])), _: 1, __: [31] }), i(r, { size: "default", type: "success", onClick: B(_e, ["stop"]) }, { default: n(() => a[32] || (a[32] = [C("保存")])), _: 1, __: [32] })], 64)) : (p(), f(r, { key: 0, size: "default", type: "warning", onClick: Me }, { default: n(() => a[30] || (a[30] = [C(" 编辑分拣信息 ")])), _: 1, __: [30] }))])) : b("", true)]), i(je, { ref: "tableRef", data: T.value ? j.value : H.value, "default-expand-all": false, "max-height": v.maxHeight - 150, "highlight-current-row": "", "row-key": "id" }, { default: n(() => [i(k, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), y.value ? b("", true) : (p(), f(k, { key: "preparationSNList", fixed: "left", label: "备料单号", "min-width": "140px", prop: "preparationSNList", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [$e(u("span", null, null, 512), [[Pe, t.preparationSNList]])]), _: 1 })), i(yl, { "show-index": false, fixed: "left", "spec-merge": "" }), i(hl, { fixed: "left" }), i(vl), T.value ? (p(), f(k, { key: 1, align: "center", fixed: "right", label: "操作", width: "80px" }, { default: n(({ $index: t }) => [i(r, { icon: "el-icon-delete", size: "default", type: "danger", onClick: B((Re) => Ce(t), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : b("", true)]), _: 1 }, 8, ["data", "max-height"])])], 64)) : b("", true)], 4)]), _: 1 }, 8, ["model", "rules"])])]);
  };
} }, zl = Qe(Ll, [["__scopeId", "data-v-ec0a84eb"]]);
export {
  zl as default
};
