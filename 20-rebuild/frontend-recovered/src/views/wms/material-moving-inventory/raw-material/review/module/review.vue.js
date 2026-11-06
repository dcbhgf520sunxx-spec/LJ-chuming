import { ElMessage as de } from "element-plus";
import { ref as i } from "vue";
import { computed as x } from "vue";
import { watch as me } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as T } from "vue";
import { createBlock as I } from "vue";
import { withCtx as r } from "vue";
import { createVNode as s } from "vue";
import { createCommentVNode as D } from "vue";
import { unref as b } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as y } from "vue";
import { isRef as fe } from "vue";
import { ElTableColumn as pe } from "element-plus";
import { ElTooltip as ve } from "element-plus";
import { ElInput as we } from "element-plus";
import { ElForm as ye } from "element-plus";
import { zl as he, zm as _e, zn as H, fK as ge, _ as be, t as ke, jX as Ce, bD as xe, D as N, kc as Ne, o as Ve, u as Le, zo as Re, zp as W, cO as Ue, jl as j, zq as Te, zr as Ie, jG as Ae, xP as ze, V as Be, zs as Ee, zt as Fe, ba as Pe, jN as Se } from "../../../../../../shared/runtime.js";
import { R as De } from "../../../../../../modules/review-convenient-operate-8438d44b.js";
import { _ as We } from "../../../../../../modules/review-confirm-button-aa3600ad.js";
function je() {
  const u = (n, h) => h.boolPartyA && h.partyATransferType === H.BUY_IN.V ? !!n : true, f = { unitPrice: [{ validator: u, message: "请填写单价", trigger: "blur" }], amount: [{ validator: u, message: "请填写金额", trigger: "blur" }] };
  return { tableValidate: (n) => He(n, f), wrongCellMask: (n) => he(n, f), cleanUpData: (n) => _e(n) };
}
function He(u, f) {
  let n = true;
  if (u.filter((d) => d.boolPartyA && d.partyATransferType === H.BUY_IN.V).length === 0) return { dealList: u, validResult: n };
  const k = "请填写“买入甲供物料”的金额";
  for (const d in u) {
    const p = u[d];
    delete p.verify, p.verify = {};
    for (const v in f) p.verify[v] = ge(v, f[v], p), p.verify[v] || (n = false);
  }
  return n || de({ message: k, type: "error" }), { dealList: u, validResult: n };
}
const Me = { style: { width: "100%", "text-overflow": "ellipsis", "white-space": "nowrap", overflow: "hidden" } }, qe = { class: "flex-rss footer-info" }, Ye = { __name: "review", props: { visible: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["refresh", "update:visible"], setup(u, { emit: f }) {
  const { decimalPrecision: n } = ke(), h = f, k = u, d = i(), p = i(), v = i(), w = i(false), _ = i(false), g = i(false), A = i([]), l = i({}), z = i(0), V = i(false), C = i([]), L = i(), M = x(() => [...Ce, ["invoiceType", ["parse-enum", xe, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", n.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", n.value.wms]], ["amount", ["to-thousand", N.YUAN]], ["amountExcludingVAT", ["to-thousand", N.YUAN]], ["inputVAT", ["to-thousand", N.YUAN]]]), q = x(() => _.value || g.value), Y = x(() => w.value ? "移库单：" : `移库单：${l.value.serialNumber || ""}`), { crud: O } = Ne(), { maxHeight: $ } = Ve({ mainBox: ".raw-mat-transfer-application-review-form", extraBox: [".el-drawer__header", ".approval-comments", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => x(() => !w.value)), { visible: R, handleClose: U } = Le({ emit: h, props: k, field: "visible", showHook: oe, closeHook: se }), { tableValidate: K, cleanUpData: B, wrongCellMask: G } = je();
  me(() => k.data, async (e) => {
    E(), e && e.id && (L.value = e.id, w.value = true, await Q(), F(e.id));
  }, { immediate: true, deep: true });
  function X(e) {
    var m;
    const t = (m = e.sourceWorkshop) == null ? void 0 : m.name, o = e.sourceWarehouse ? e.sourceWarehouse.name : e.sourceWarehouseName;
    return t ? t + "【" + o + "】" : o;
  }
  function E() {
    w.value = false, g.value = false, _.value = false, A.value = [], l.value = {};
  }
  function J(e) {
    E(), F(e);
  }
  async function Q() {
    C.value = await Re(O.query);
  }
  async function F(e) {
    if (e) try {
      w.value = true;
      const t = await W(e);
      t.logistics = {}, l.value = await Z(t);
    } catch (t) {
      console.log("加载失败", t);
    } finally {
      w.value = false;
    }
  }
  async function Z(e) {
    return await Ue(e.detailList), e.detailList = await j(e.detailList, { toSmallest: false, toNum: true }), e;
  }
  async function ee(e) {
    const { validResult: t, dealList: o } = K(e.detailList);
    t && (e.detailList = o);
    const m = await v.value.validate();
    return t && m;
  }
  async function ae(e) {
    return B(e.detailList), e.detailList = await j(e.detailList, { toSmallest: true, toNum: true }), e;
  }
  async function te() {
    try {
      if (_.value = true, !await ee(l.value)) return;
      const t = Be(l.value), o = await ae(t), m = { id: o.id, approvalComments: o.approvalComments };
      await Ee(m), P();
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      _.value = false;
    }
  }
  async function le() {
    try {
      g.value = true;
      const e = { id: l.value.id, approvalComments: l.value.approvalComments };
      await Fe(e), P();
    } catch (e) {
      console.log("退回", e);
    } finally {
      g.value = false;
    }
  }
  function P() {
    try {
      ++z.value, V.value && d.value ? d.value.removeCurrent() : U();
    } catch (e) {
      console.log("审核提交后", e), U();
    }
  }
  function oe() {
    l.value && l.value.list && B(l.value.list);
  }
  function se() {
    z.value && h("refresh");
  }
  function ne(e) {
    return Pe(e, { props: ["quantity", ["mete", Se.weight.precision], ["amount", N.YUAN]], toThousandFields: ["mete", "amount"] });
  }
  return (e, t) => {
    const o = pe, m = ve, re = S("common-table"), ie = we, ue = ye, ce = S("common-drawer");
    return T(), I(ce, { ref_key: "drawerRef", ref: p, modelValue: b(R), "onUpdate:modelValue": t[3] || (t[3] = (a) => fe(R) ? R.value = a : null), "before-close": b(U), "content-loading": w.value, "show-close": true, title: Y.value, "custom-class": "raw-mat-transfer-application-review-form", size: "100%" }, { titleAfter: r(() => [s(Te, { detail: l.value }, null, 8, ["detail"])]), titleRight: r(() => [C.value && C.value.length > 1 ? (T(), I(De, { key: 0, ref_key: "reviewConvenientRef", ref: d, modelValue: L.value, "onUpdate:modelValue": t[0] || (t[0] = (a) => L.value = a), consequent: V.value, "onUpdate:consequent": t[1] || (t[1] = (a) => V.value = a), list: C.value, class: "convenient-operation", onChange: J }, null, 8, ["modelValue", "consequent", "list"])) : D("", true), s(We, { "passed-fn": te, "passed-loading": _.value, "returned-fn": le, "returned-loading": g.value }, null, 8, ["passed-loading", "returned-loading"])]), content: r(() => [s(ue, { ref_key: "formRef", ref: v, disabled: q.value, model: l.value, rules: e.rules, class: "form", "label-position": "left", size: "default" }, { default: r(() => [l.value.boolHasUnfreeze ? (T(), I(Ie, { key: 0, "basic-class": l.value.basicClass, list: l.value.unfreezeList, class: "unfreeze-info" }, null, 8, ["basic-class", "list"])) : D("", true), s(re, { "cell-class-name": b(G), data: l.value.detailList, "data-format": M.value, "expand-row-keys": A.value, "max-height": b($), "summary-method": ne, "row-key": "id", "show-summary": "" }, { default: r(() => [s(Ae, { "basic-class": b(W).basicClass, "spec-merge": false, "classify-name-alias": "名称", "reject-detail-viewable": "", "show-classification": "", "show-reject-status": "", sortable: "", "spec-only": "" }, { afterMaterialSn: r(() => [s(o, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), s(o, { key: "measureUnit", "show-overflow-tooltip": true, align: "center", label: "计量单位", "min-width": "90", prop: "measureUnit" }, { default: r(({ row: a }) => [c("span", null, y(a.measureUnit || "-"), 1)]), _: 1 }), s(o, { key: "quantity", "show-overflow-tooltip": true, align: "center", label: "数量", "min-width": "100", prop: "quantity" }, { default: r(({ row: a }) => [c("span", null, y(a.quantity || "-"), 1)]), _: 1 }), s(o, { key: "accountingUnit", "show-overflow-tooltip": true, align: "center", label: "核算单位", "min-width": "90", prop: "accountingUnit" }, { default: r(({ row: a }) => [c("span", null, y(a.accountingUnit || "-"), 1)]), _: 1 }), s(o, { key: "mete", "show-overflow-tooltip": true, align: "center", label: "核算量", "min-width": "100", prop: "mete" }, { default: r(({ row: a }) => [c("span", null, y(a.mete || "-"), 1)]), _: 1 }), s(o, { key: "projectFullName", "show-overflow-tooltip": true, align: "center", label: "关联项目", "min-width": "170", prop: "projectFullName" }, { default: r(({ row: a }) => [c("span", null, y(a.projectFullName || "-"), 1)]), _: 1 }), s(o, { key: "sourceWarehouse", align: "center", label: "所属仓库", "min-width": "170", prop: "sourceWarehouse" }, { default: r(({ row: a }) => [c("div", Me, [s(ze, { id: a.sourceWorkshop ? a.sourceWorkshop.id : a.sourceWorkshopId }, null, 8, ["id"]), s(m, { content: X(a), class: "item", effect: "dark", placement: "top-start" }, { default: r(() => [c("span", null, y(a.sourceWarehouse ? a.sourceWarehouse.name : a.sourceWarehouseName), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 }), s(o, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "170", prop: "remark" }, { default: r(({ row: a }) => [c("span", null, y(a.remark || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"]), c("div", qe, [s(ie, { modelValue: l.value.approvalComments, "onUpdate:modelValue": t[2] || (t[2] = (a) => l.value.approvalComments = a), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])])]), _: 1 }, 8, ["disabled", "model", "rules"])]), _: 1 }, 8, ["modelValue", "before-close", "content-loading", "title"]);
  };
} }, Xe = be(Ye, [["__scopeId", "data-v-d8a7df13"]]);
export {
  Xe as default
};
