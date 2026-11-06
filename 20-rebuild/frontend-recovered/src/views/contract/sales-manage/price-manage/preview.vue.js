import { inject as x } from "vue";
import { ref as U } from "vue";
import { useAttrs as F } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as l } from "vue";
import { createBlock as m } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as G } from "vue";
import { unref as t } from "vue";
import { createElementBlock as d } from "vue";
import { Fragment as f } from "vue";
import { toDisplayString as E } from "vue";
import { createCommentVNode as g } from "vue";
import { createElementVNode as X } from "vue";
import { isRef as Y } from "vue";
import { ElNotification as q } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElFormItem as K } from "element-plus";
import { ElForm as J } from "element-plus";
import { s as W, a as Z } from "../../../../modules/common-913d415d.js";
import { l as L, u as ee, o as te, K as v, kz as p, bT as P, kA as ae, iB as ne, kB as ie } from "../../../../shared/runtime.js";
import { _ as T } from "../../../../modules/index-61ce89a1.js";
function le(c) {
  return L({ module: "contract", url: "business/standardPart", method: "get", params: c });
}
function oe(c) {
  return L({ module: "contract", url: "business/standardPart", method: "put", data: c });
}
const ge = { get: le }, re = { key: 0 }, se = { key: 0 }, pe = { __name: "preview", props: { modifiedData: { type: Array, default: () => [] }, params: { type: Object, default: () => {
} }, modelValue: { type: Boolean, require: true }, categoryValue: { type: Number }, showType: { type: String, default: void 0 } }, emits: ["success", "update:visible"], setup(c, { emit: C }) {
  const M = C, a = c, k = x("globalProject"), b = U(false), y = U(), w = x("priceEditMode"), B = F(), { visible: _, handleClose: R } = ee({ emit: M, props: a }), { maxHeight: S } = te({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false, extraHeight: 150 }, _);
  async function D() {
    try {
      b.value = true;
      const r = [];
      a.showType === "log" ? a.modifiedData.map((e) => {
        r.push(e.id);
      }) : a.modifiedData.map((e) => {
        a.params.type !== p.AUXILIARY_MATERIAL.V ? r.push({ id: e.id, unitPrice: e.unitPrice !== "同上" ? e.unitPrice : null, pricingManner: e.pricingManner }) : r.push({ id: e.id, unitPrice: e.unitPrice !== "同上" ? e.unitPrice : null });
      });
      const s = a.showType === "log" ? W : a.params.type === p.AUXILIARY_MATERIAL.V ? oe : Z, h = a.showType === "log" ? { priceTempIds: r, remark: y.value, ...a.params } : { details: r, remark: y.value, ...a.params };
      await s(h), q({ title: "提交成功", type: "success" }), R(), M("success"), B.onRefreshCount();
    } catch (r) {
      console.log("提交商务价格", r);
    } finally {
      b.value = false;
    }
  }
  return (r, s) => {
    var A, I;
    const h = V("common-button"), e = Q, j = V("common-table"), N = $, H = K, z = J, O = V("common-dialog");
    return l(), m(O, { title: `${((A = t(k)) == null ? void 0 : A.projectType) === t(v).BRIDGE.V ? "分段" : (I = t(p).V[a.params.type]) == null ? void 0 : I.SL}价格修改`, modelValue: t(_), "onUpdate:modelValue": s[1] || (s[1] = (u) => Y(_) ? _.value = u : null), top: "8vh", "append-to-body": "", "before-close": t(R), width: "50%" }, { titleRight: o(() => [n(h, { loading: b.value, size: "default", disabled: !a.modifiedData.length, type: "primary", onClick: D }, { default: o(() => s[2] || (s[2] = [G(" 保 存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])]), default: o(() => [n(j, { data: a.modifiedData, "max-height": t(S) - 180, "empty-text": "未做改动", style: { width: "100%" } }, { default: o(() => {
      var u;
      return [n(e, { label: "序号", type: "index", align: "center", width: "60" }), ((u = t(k)) == null ? void 0 : u.projectType) !== t(v).BRIDGE.V && (a.params.type === t(p).STRUCTURE.V || a.params.type === t(p).MACHINE_PART.V) ? (l(), d(f, { key: 0 }, [n(e, { prop: "name", label: "名称", align: "center" }), n(e, { prop: "specification", label: "规格", align: "center" }), n(e, { prop: "material", label: "材质", align: "center" }), n(e, { prop: "totalQuantity", label: "数量", align: "center" }), n(e, { align: "center", prop: "pricingManner", label: "计价方式" }, { default: o(({ row: i }) => [i.pricingManner === i.originPricingManner ? (l(), d("span", re, E(t(P).VL[i.originPricingManner]), 1)) : (l(), m(t(T), { key: 1, old: t(P).VL[i.originPricingManner], new: t(P).VL[i.pricingManner] }, null, 8, ["old", "new"]))]), _: 1 })], 64)) : g("", true), a.params.type === t(p).ENCLOSURE.V ? (l(), d(f, { key: 1 }, [n(e, { prop: "name", label: "名称", align: "center" }), a.categoryValue !== t(ae).FOLDING_PIECE.V ? (l(), m(e, { key: 0, prop: "plate", label: "板型", align: "center" })) : g("", true), n(e, { prop: "specification", label: "规格", align: "center" }), n(e, { prop: "totalQuantity", label: "数量", align: "center" }), n(e, { align: "center", prop: "pricingManner", label: "计价方式" }, { default: o(({ row: i }) => [X("span", null, E(t(ne).VL[i.pricingManner]), 1)]), _: 1 })], 64)) : g("", true), a.params.type === t(p).AUXILIARY_MATERIAL.V ? (l(), d(f, { key: 2 }, [n(e, { prop: "name", label: "名称", align: "center" }), n(e, { prop: "specification", label: "规格", align: "center" }), n(e, { prop: "quantity", label: "数量", align: "center" })], 64)) : g("", true), n(e, { align: "center", prop: "price", label: "综合单价" }, { default: o(({ row: i }) => [a.params.type === t(p).STRUCTURE.V ? (l(), d(f, { key: 0 }, [i.originUnitPrice === i.unitPrice ? (l(), d("span", se, E(i.unitPrice), 1)) : (l(), m(t(T), { key: 1, old: i.originUnitPrice === "同上" ? "-" : i.originUnitPrice, new: i.unitPrice }, null, 8, ["old", "new"]))], 64)) : (l(), m(t(T), { key: 1, old: i.originUnitPrice === "同上" ? "-" : i.originUnitPrice, new: i.unitPrice }, null, 8, ["old", "new"]))]), _: 1 })];
    }), _: 1 }, 8, ["data", "max-height"]), t(w) === t(ie).AUDIT.V || c.showType === "log" ? (l(), m(z, { key: 0, style: { "margin-top": "20px" } }, { default: o(() => [n(H, { label: "事由：" }, { default: o(() => [n(N, { modelValue: y.value, "onUpdate:modelValue": s[0] || (s[0] = (u) => y.value = u), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 6 }, placeholder: "请输入事由", style: { width: "100%" }, "show-word-limit": "", maxlength: "255" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })) : g("", true)]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ye = Object.freeze(Object.defineProperty({ __proto__: null, default: pe }, Symbol.toStringTag, { value: "Module" }));
export {
  pe as _,
  ge as c,
  ye as p
};
