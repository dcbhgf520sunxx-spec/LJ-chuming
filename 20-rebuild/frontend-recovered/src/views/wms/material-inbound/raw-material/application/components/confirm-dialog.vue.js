import { computed as b } from "vue";
import { ref as C } from "vue";
import { provide as ue } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as n } from "vue";
import { createBlock as d } from "vue";
import { withCtx as g } from "vue";
import { unref as r } from "vue";
import { createCommentVNode as m } from "vue";
import { createVNode as _ } from "vue";
import { createElementVNode as P } from "vue";
import { createTextVNode as ne } from "vue";
import { toDisplayString as k } from "vue";
import { createElementBlock as ce } from "vue";
import { Fragment as de } from "vue";
import { isRef as me } from "vue";
import { cloneDeep as pe } from "lodash";
import { ElTableColumn as fe } from "element-plus";
import { ElForm as ve } from "element-plus";
import { _ as be, xC as ge, t as he, jX as _e, bD as ye, D as S, u as we, tC as xe, jY as je, mx as Ie, b as c, jZ as D, gS as Te, jV as Re, j_ as Ae, i as j, o as Ce, V as Pe, jl as Se, xm as Ve, aR as Ee, k4 as Ne, jG as ke, k5 as De, jH as Be, xD as Oe, yq as Fe, aw as Me, a$ as Ue, ba as We, jN as qe, fE as He } from "../../../../../../shared/runtime.js";
import { _ as $e } from "../../../../../../modules/index-e817c507.js";
import Ye from "../../components/project-set-columns.vue.js";
import Le from "../../components/warehouse-set-columns.vue.js";
import Ke from "./common-footer.vue.js";
const Ge = { __name: "confirm-dialog", props: { modelValue: { type: Boolean, default: false }, basicClass: { type: Number } }, emits: ["saveSuccess", "update:modelValue"], setup(H, { emit: $ }) {
  const { realTimeValidate: Y } = ge(), { decimalPrecision: B } = he(), L = $, I = H, K = b(() => [..._e, ["invoiceType", ["parse-enum", ye, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", B.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", B.value.wms]], ["amount", ["to-thousand", S.YUAN]], ["amountExcludingVAT", ["to-thousand", S.YUAN]], ["inputVAT", ["to-thousand", S.YUAN]], ["brand", "empty-text"], ["heatNoAndBatchNo", "empty-text"], ["remark", "empty-text"]]), y = C([]), T = C([]), { visible: w, handleClose: O } = we({ emit: L, props: I, showHook: te, closeHook: le }), { cu: i, form: p, FORM: R } = xe(), { inboundFillWayCfg: F } = je(), { projectsAll: G } = Ie(), V = C(), l = b(() => c(i.props.order) ? {} : i.props.order.supplyType === D.PARTY_A.V ? { ...i.props.order, projects: G.value } : i.props.order), x = b(() => F.value ? F.value.amountFillWay === Te.APPLICATION.V : false), E = C(true), M = b(() => l.value.logisticsPayerType === Re.DEMAND.V), v = b(() => {
    var e;
    return ((e = l.value) == null ? void 0 : e.supplyType) === D.PARTY_A.V;
  }), h = b(() => l.value.materialType === Ae.MANUFACTURED.V), U = b(() => {
    const e = x.value && !v.value && (l.value.projects && l.value.requisitionsSN || E.value), t = x.value && v.value && l.value.projects && l.value.requisitionsSN && E.value;
    return !(e || t);
  }), z = { workshopId: [{ validator: (e, t) => !h.value || h.value && t.destination === He.FACTORY.V ? !!j(e) : true, message: "请选择车间", trigger: "change" }], warehouseId: [{ validator: (e, t) => h.value ? true : !!j(e), message: "请选择仓库", trigger: "change" }] }, X = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, Z = { projectId: [{ validator: (e, t) => c(t.applyPurchaseId) ? !!e : true, message: "请选择项目", trigger: "change" }] }, J = b(() => {
    var o;
    const e = { ...z };
    return x.value && !v.value && Object.assign(e, X), j(l.value.projects) && (v.value || !((o = l.value) != null && o.boolApplyPurchase)) && Object.assign(e, Z), Object.assign(e, { realTime: [{ validator: Y, message: "请选择实际入库时间", trigger: "change" }] }), e;
  }), { maxHeight: Q } = Ce({ mainBox: ".inbound-application-preview", extraBox: [".el-dialog__header", ".logistics-form-content", ".footer"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, w), A = /* @__PURE__ */ new Map([["requisitionsSN", -1], ["projectId", -1], ["monomerId", -1], ["areaId", -1], ["workshopId", -1], ["warehouseId", -1]]);
  ue("ditto", A);
  const { tableValidate: ee, wrongCellMask: ae } = Me({ rules: J, ditto: A });
  function se({ row: e, rowIndex: t }) {
    var o, u, s;
    if ((u = (o = i == null ? void 0 : i.submitResult) == null ? void 0 : o.data) != null && u.includes(e.classifyId) && ((s = i == null ? void 0 : i.submitResult) == null ? void 0 : s.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  function te() {
    y.value = p.list.filter((e) => {
      var t, o;
      return !!(v.value || (t = p.selectObj[e.mergeId]) != null && t.isSelected || !v.value && c((o = l.value) == null ? void 0 : o.details));
    }), re(y.value), p.list.map((e) => {
      e.realTime = e.realTime || (/* @__PURE__ */ new Date()).getTime();
    });
  }
  function oe(e, t = /* @__PURE__ */ new Map()) {
    const o = pe(e);
    e.length = 0, o.forEach((s, f) => {
      t.forEach((N, W) => {
        s[W] === N && delete s[W];
      }), delete s.uid, Ue(s).some((N) => j(N)) && e.push(s);
    });
    const u = /* @__PURE__ */ new Map();
    return e.forEach((s) => {
      delete s.verify, t.forEach((f, a) => {
        c(s[a]) ? s[a] = u.get(a) : u.set(a, s[a]), ["projectId", "monomerId", "areaId"].indexOf(a) > -1 && j(s.purchaseProjectDisabled) && s.purchaseProjectDisabled && (s[a] = void 0);
      });
    }), e;
  }
  i.submitFormFormat = async (e) => {
    const t = Pe(e.list);
    return oe(t, A), e.list = await Se(t, { toSmallest: true, toNum: true }), e.list.forEach((o) => {
      var u;
      h.value && (o.projectId = (u = l.value.projects) != null && u.length ? l.value.projects[0].id : void 0);
    }), e.supplyType & D.PARTY_A.V && (e.purchaseId = void 0), e;
  }, R.HOOK.beforeSubmit = async () => {
    const { validResult: e, dealList: t } = ee(y.value);
    e && (y.value = t);
    let o = true;
    return M.value && V.value && (o = await V.value.validate()), e && o;
  }, R.HOOK.afterSubmit = () => {
    p.selectObj = {}, O();
  };
  function le() {
    T.value = [];
  }
  function re(e) {
    if (c(e)) return;
    const t = /* @__PURE__ */ new Map([["requisitionsSN", -1], ["projectId", -1], ["workshopId", -1]]);
    let o = e[0].basicClass;
    for (let u = 1; u < e.length; u++) {
      const s = e[u];
      o === s.basicClass ? A.forEach((f, a) => {
        ["projectId", "monomerId", "areaId"].indexOf(a) > -1 ? c(s.applyPurchaseId) && c(s[a]) && (s[a] = f) : c(s[a]) && (s[a] = f);
      }) : (t.forEach((f, a) => {
        ["projectId"].indexOf(a) > -1 ? c(s.applyPurchaseId) && c(s[a]) && (s[a] = f) : c(s[a]) && (s[a] = f);
      }), o = s.basicClass);
    }
  }
  function ie(e) {
    return We(e, { props: ["quantity", ["mete", qe.weight.precision], ["amount", S.YUAN]], toThousandFields: ["mete", "amount"] });
  }
  return (e, t) => {
    const o = fe, u = q("common-table"), s = ve, f = q("common-dialog");
    return n(), d(f, { modelValue: r(w), "onUpdate:modelValue": t[1] || (t[1] = (a) => me(w) ? w.value = a : null), "before-close": r(O), title: l.value.serialNumber ? `订单：${l.value.serialNumber}（${l.value.supplier ? l.value.supplier.name : ""}）` : "甲供入库", top: "5vh", "append-to-body": "", "custom-class": "inbound-application-preview", fullscreen: "", width: "1200px" }, { titleAfter: g(() => [v.value ? m("", true) : (n(), d(Ve, { key: 0, detail: r(p), order: l.value }, null, 8, ["detail", "order"]))]), titleRight: g(() => [x.value ? (n(), d($e, { key: 0, "purchase-id": l.value.id, size: "default" }, null, 8, ["purchase-id"])) : m("", true)]), default: g(() => [r(w) ? (n(), d(s, { key: 0, ref: "formRef", disabled: r(i).status.edit === r(R).STATUS.PROCESSING, model: r(p) }, { default: g(() => [r(w) ? (n(), d(u, { key: 0, "cell-class-name": r(ae), data: y.value, "data-format": K.value, "expand-row-keys": T.value, "max-height": r(Q), "row-style": se, stripe: false, "summary-method": ie, "row-key": "uid", "show-summary": "" }, { default: g(() => [_(Ee, { "expand-row-keys": T.value, "onUpdate:expandRowKeys": t[0] || (t[0] = (a) => T.value = a), data: y.value, fixed: "left", "row-key": "uid" }, { default: g(({ row: a }) => [U.value ? m("", true) : (n(), d(Ne, { key: 0, "basic-class": a.basicClass, row: a, "show-brand": "" }, null, 8, ["basic-class", "row"])), P("p", null, [t[2] || (t[2] = ne(" 备注：")), P("span", null, k(a.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), _(ke, { "basic-class": I.basicClass, fixed: "left" }, null, 8, ["basic-class"]), U.value ? (n(), d(De, { key: 0, "basic-class": I.basicClass }, null, 8, ["basic-class"])) : m("", true), _(Be, { "basic-class": I.basicClass }, null, 8, ["basic-class"]), x.value && !v.value ? (n(), ce(de, { key: 1 }, [_(o, { key: "unitPrice", align: "right", label: "含税单价", prop: "unitPrice", width: "120" }, { default: g(({ row: { sourceRow: a } }) => [P("span", null, k(a == null ? void 0 : a.unitPrice), 1)]), _: 1 }), _(o, { key: "amount", align: "right", label: "金额", prop: "amount", width: "120" }, { default: g(({ row: a }) => [P("span", null, k(a == null ? void 0 : a.amount), 1)]), _: 1 })], 64)) : m("", true), h.value ? m("", true) : (n(), d(Ye, { key: 2, form: r(p), order: l.value, requisitions: r(i).props.requisitions }, null, 8, ["form", "order", "requisitions"])), E.value ? (n(), d(Le, { key: 3, form: r(p), boolManuf: h.value, showWarehouse: !h.value }, null, 8, ["form", "boolManuf", "showWarehouse"])) : m("", true), _(Oe, { showSourceRow: "", label: "实际入库时间" })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"])) : m("", true), M.value ? (n(), d(Fe, { key: 1, ref_key: "logisticsRef", ref: V, disabled: r(i).status.edit === r(R).STATUS.PROCESSING, form: r(p).logistics, class: "logistics-form-content" }, null, 8, ["disabled", "form"])) : m("", true)]), _: 1 }, 8, ["disabled", "model"])) : m("", true), _(Ke, { "show-total": false, class: "footer", "is-submit": "" })]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, la = be(Ge, [["__scopeId", "data-v-23cdd25a"]]);
export {
  la as default
};
