import { inject as qe } from "vue";
import { computed as r } from "vue";
import { ref as u } from "vue";
import { watch as Ue } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as i } from "vue";
import { createBlock as d } from "vue";
import { withCtx as v } from "vue";
import { createVNode as n } from "vue";
import { createCommentVNode as f } from "vue";
import { unref as _ } from "vue";
import { createElementVNode as C } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as M } from "vue";
import { createElementBlock as L } from "vue";
import { Fragment as T } from "vue";
import { isRef as Fe } from "vue";
import { ElTableColumn as Be } from "element-plus";
import { ElInput as De } from "element-plus";
import { ElForm as Oe } from "element-plus";
import { _ as $e, t as He, jX as Me, bD as We, D as V, jY as Ye, gS as ze, G as Ge, jV as Ke, jZ as Xe, j_ as Ze, kc as Je, o as Qe, u as ea, yE as aa, yF as ta, i as W, cO as sa, jl as ne, V as oe, k0 as Y, b as I, xm as la, aR as na, k4 as oa, jG as ia, jH as ua, k5 as ra, k6 as ca, yB as da, yq as ma, aw as pa, yG as va, yH as fa, v3 as ga, iX as z, ba as wa, jN as ha } from "../../../../../../shared/runtime.js";
import { _ as ba } from "../../../../../../modules/index-e817c507.js";
import { R as ya } from "../../../../../../modules/review-convenient-operate-8438d44b.js";
import { _ as _a } from "../../../../../../modules/review-confirm-button-aa3600ad.js";
import Ca from "../../components/inspection-return-info.vue.js";
import xa from "../../components/warehouse-set-columns.vue.js";
const ka = { __name: "review", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:modelValue"], setup(ie, { emit: ue }) {
  const { decimalPrecision: G } = He(), K = ue, X = ie, re = qe("permission"), ce = r(() => [...Me, ["invoiceType", ["parse-enum", We, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", G.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", G.value.wms]], ["amount", ["to-thousand", V.YUAN]], ["amountExcludingVAT", ["to-thousand", V.YUAN]], ["inputVAT", ["to-thousand", V.YUAN]], ["remark", "empty-text"], ["realTime", "parse-time"]]), j = u(), de = u(), q = u(), g = u(false), b = u(false), y = u(false), R = u([]), me = u(), t = u({}), Z = u(0), U = u(false), N = u([]), F = u(), { inboundFillWayCfg: J } = Ye(), A = r(() => J.value ? J.value.amountFillWay === ze.REVIEWING.V : false), E = r(() => Ge(re.showAmount) || A.value), P = u(false), Q = r(() => m.value.logisticsPayerType === Ke.DEMAND.V);
  r(() => !A.value);
  const x = r(() => {
    var e;
    return ((e = t.value) == null ? void 0 : e.supplyType) === Xe.PARTY_A.V;
  }), pe = r(() => t.value.basicClass & Ze.MANUFACTURED.V), m = r(() => t.value.purchaseOrder || {}), ee = r(() => b.value || y.value), ve = r(() => g.value ? "入库单" : `入库单：${t.value.serialNumber}（ ${m.value.supplier ? m.value.supplier.name : "无供应商"} ）`), B = r(() => {
    const e = E.value && !x.value && (m.value.projects && m.value.requisitionsSN || P.value), a = E.value && x.value && m.value.projects && m.value.requisitionsSN && P.value;
    return !(e || a);
  }), fe = { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择仓库", trigger: "change" }] }, ge = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, we = r(() => {
    const e = {};
    return A.value && !x.value && Object.assign(e, ge), P.value && Object.assign(e, fe), e;
  }), { crud: he } = Je(), { maxHeight: be } = Qe({ mainBox: ".raw-mat-inbound-application-review-form", extraBox: [".el-drawer__header", ".approval-comments", ".logistics-form-content", ".inspection-return-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => r(() => !g.value)), ae = /* @__PURE__ */ new Map([["requisitionsSN", -1], ["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { visible: D, handleClose: O } = ea({ emit: K, props: X, closeHook: Pe }), { tableValidate: ye, cleanUpData: _e, wrongCellMask: Ce } = pa({ rules: we, ditto: ae });
  Ue(() => X.data, async (e) => {
    te(), e && e.id && (F.value = e.id, g.value = true, await ke(), se(e.id));
  }, { immediate: true, deep: true });
  function te() {
    g.value = false, y.value = false, b.value = false, R.value = [], me.value = void 0, t.value = {};
  }
  function xe(e) {
    te(), se(e);
  }
  async function ke() {
    N.value = await aa(he.query);
  }
  async function se(e) {
    if (e) try {
      g.value = true;
      const a = await ta(e);
      t.value = await Ve(a);
    } catch (a) {
      console.log("加载失败", a);
    } finally {
      g.value = false;
    }
  }
  async function Ve(e) {
    var a;
    return (a = e.purchaseOrder) != null && a.projects && (e.purchaseOrder.projectIds = e.purchaseOrder.projects.filter((s) => s !== s.id)), e.requisitions = {}, W(e.requisitionsList) && e.requisitionsList.forEach((s) => {
      e.requisitions[s.serialNumber] = s;
    }), await sa(e.list), e.list = await ne(e.list, { toSmallest: false, toNum: true }), e.list.forEach((s) => s.sourceRequisitionsSN = s.requisitionsSN), e.originList = oe(e.list), e.list = e.originList.filter((s) => s.qualityTestingEnum & (Y.ALL_PASS.V | Y.NO.V)), e.returnList = e.originList.filter((s) => s.qualityTestingEnum & Y.ALL_REFUSE.V), Se(e.list), e;
  }
  async function Re(e) {
    const { validResult: a, dealList: s } = ye(e.list);
    a && (e.list = s);
    let o = true;
    return Q.value && q.value && (o = await q.value.validate()), a && o;
  }
  async function Ne(e) {
    return _e(e.list), e.list = await ne(e.list, { toSmallest: true, toNum: true }), e;
  }
  async function Ae() {
    try {
      if (b.value = true, !await Re(t.value)) return;
      const a = oe(t.value), s = await Ne(a);
      await va(s), le();
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      b.value = false;
    }
  }
  async function Ee() {
    try {
      y.value = true;
      const e = { id: t.value.id, approvalComments: t.value.approvalComments };
      await fa(e), le();
    } catch (e) {
      console.log("退回", e);
    } finally {
      y.value = false;
    }
  }
  function le() {
    try {
      ++Z.value, U.value && j.value ? j.value.removeCurrent() : O();
    } catch (e) {
      console.log("审核提交后", e), O();
    }
  }
  function Pe() {
    Z.value && K("refresh");
  }
  function Se(e) {
    if (I(e)) return;
    const a = /* @__PURE__ */ new Map([["requisitionsSN", -1], ["projectId", -1], ["workshopId", -1]]);
    let s = e[0].basicClass;
    for (let o = 1; o < e.length; o++) {
      const p = e[o];
      s === p.basicClass ? ae.forEach((k, w) => {
        I(p[w]) && (p[w] = k);
      }) : (a.forEach((k, w) => {
        I(p[w]) && (p[w] = k);
      }), s = p.basicClass);
    }
  }
  function Le(e, a) {
    ga(e) > 10 && (a.unitPrice = z(e, 10), e = a.unitPrice), a.amount = W(e) ? z(e * a.mete, 2) : void 0;
  }
  function Te(e, a) {
    a.unitPrice = W(e) ? z(e / a.mete, 10) : void 0;
  }
  function Ie(e) {
    return wa(e, { props: ["quantity", ["mete", ha.weight.precision], ["amount", V.YUAN]], toThousandFields: ["mete", "amount"] });
  }
  return (e, a) => {
    const s = $("common-input-number"), o = Be, p = $("common-table"), k = De, w = Oe, je = $("common-drawer");
    return i(), d(je, { ref_key: "drawerRef", ref: de, modelValue: _(D), "onUpdate:modelValue": a[6] || (a[6] = (c) => Fe(D) ? D.value = c : null), "content-loading": g.value, "before-close": _(O), title: ve.value, "show-close": true, size: "100%", "custom-class": "raw-mat-inbound-application-review-form" }, { titleAfter: v(() => [n(la, { order: m.value, detail: t.value }, null, 8, ["order", "detail"])]), titleRight: v(() => [N.value && N.value.length > 1 ? (i(), d(ya, { key: 0, ref_key: "reviewConvenientRef", ref: j, modelValue: F.value, "onUpdate:modelValue": a[0] || (a[0] = (c) => F.value = c), consequent: U.value, "onUpdate:consequent": a[1] || (a[1] = (c) => U.value = c), list: N.value, onChange: xe, class: "convenient-operation" }, null, 8, ["modelValue", "consequent", "list"])) : f("", true), n(ba, { "purchase-id": m.value.id, size: "default" }, null, 8, ["purchase-id"]), n(_a, { "passed-loading": b.value, "onUpdate:passedLoading": a[2] || (a[2] = (c) => b.value = c), "returned-loading": y.value, "onUpdate:returnedLoading": a[3] || (a[3] = (c) => y.value = c), "passed-fn": Ae, "returned-fn": Ee }, null, 8, ["passed-loading", "returned-loading"])]), content: v(() => [n(w, { class: "form", disabled: ee.value }, { default: v(() => {
      var c;
      return [(c = t.value.returnList) != null && c.length ? (i(), d(Ca, { key: 0, class: "inspection-return-info", "basic-class": t.value.basicClass, list: t.value.returnList, showTableColumnSecondary: B.value, showAmount: E.value, boolPartyA: x.value }, null, 8, ["basic-class", "list", "showTableColumnSecondary", "showAmount", "boolPartyA"])) : f("", true), n(p, { data: t.value.list, "max-height": _(be), dataFormat: ce.value, "show-summary": "", "cell-class-name": _(Ce), "summary-method": Ie, "expand-row-keys": R.value, "row-key": "id" }, { default: v(() => {
        var S;
        return [n(na, { data: t.value.list, "expand-row-keys": R.value, "onUpdate:expandRowKeys": a[4] || (a[4] = (l) => R.value = l), "row-key": "id", fixed: "left" }, { default: v(({ row: l }) => [B.value ? f("", true) : (i(), d(oa, { key: 0, "basic-class": l.basicClass, row: l, "show-brand": "" }, null, 8, ["basic-class", "row"])), C("p", null, [a[7] || (a[7] = H(" 单体：")), C("span", null, M(l.monomerName), 1)]), C("p", null, [a[8] || (a[8] = H(" 区域：")), C("span", null, M(l.areaName), 1)]), C("p", null, [a[9] || (a[9] = H(" 备注：")), C("span", null, M(l.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), n(ia, { "basic-class": t.value.basicClass, fixed: "left" }, null, 8, ["basic-class"]), n(ua, { "basic-class": t.value.basicClass }, null, 8, ["basic-class"]), B.value ? (i(), d(ra, { key: 0, "basic-class": t.value.basicClass }, null, 8, ["basic-class"])) : f("", true), E.value && !x.value ? (i(), L(T, { key: 1 }, [_(I)((S = t.value.purchaseOrder) == null ? void 0 : S.details) && A.value ? (i(), L(T, { key: 0 }, [n(o, { prop: "unitPrice", align: "center", width: "135px", label: "含税单价" }, { default: v(({ row: { sourceRow: l } }) => [l ? (i(), d(s, { key: 0, modelValue: l.unitPrice, "onUpdate:modelValue": (h) => l.unitPrice = h, min: 0, max: 9999999999, controls: false, step: 1, size: "default", placeholder: "含税单价", onChange: (h) => Le(h, l) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : f("", true)]), _: 1 }), n(o, { prop: "amount", align: "center", width: "135px", label: "金额" }, { default: v(({ row: { sourceRow: l } }) => [l ? (i(), d(s, { key: 0, modelValue: l.amount, "onUpdate:modelValue": (h) => l.amount = h, min: 0, max: 9999999999, controls: false, step: 1, size: "default", precision: _(V).YUAN, placeholder: "金额", onChange: (h) => Te(h, l) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : f("", true)]), _: 1 })], 64)) : (i(), L(T, { key: 1 }, [n(o, { prop: "unitPrice", label: "含税单价", align: "right", "min-width": "120px", "show-overflow-tooltip": "" }), n(o, { prop: "amount", label: "金额", align: "right", "min-width": "120px", "show-overflow-tooltip": "" })], 64))], 64)) : f("", true), n(o, { prop: "project", label: "项目", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), n(o, { prop: "monomerName", label: "单体", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), n(o, { prop: "areaName", label: "区域", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), pe.value ? (i(), d(o, { key: 3, prop: "workshop.name", label: "车间", align: "left", "min-width": "120px", "show-overflow-tooltip": "" })) : (i(), L(T, { key: 2 }, [P.value ? (i(), d(xa, { key: 0, form: t.value }, null, 8, ["form"])) : (i(), d(ca, { key: 1 }))], 64)), n(da, { label: "实际入库时间" })];
      }), _: 1 }, 8, ["data", "max-height", "dataFormat", "cell-class-name", "expand-row-keys"]), n(k, { class: "approval-comments", modelValue: t.value.approvalComments, "onUpdate:modelValue": a[5] || (a[5] = (S) => t.value.approvalComments = S), rows: 2, maxlength: "1000", type: "textarea", "show-word-limit": "", placeholder: "审核意见", style: { "margin-top": "5px" } }, null, 8, ["modelValue"]), Q.value ? (i(), d(ma, { key: 1, ref_key: "logisticsRef", ref: q, class: "logistics-form-content", disabled: ee.value, form: t.value.logistics }, null, 8, ["disabled", "form"])) : f("", true)];
    }), _: 1 }, 8, ["disabled"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, La = $e(ka, [["__scopeId", "data-v-e76de862"]]);
export {
  La as default
};
