import { useAttrs as g } from "vue";
import { ref as x } from "vue";
import { watch as f } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as r } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as u } from "vue";
import { createElementVNode as E } from "vue";
import { toDisplayString as N } from "vue";
import { Fragment as T } from "vue";
import { ElTableColumn as k } from "element-plus";
import { vLoading as B } from "element-plus";
import R from "./header.vue.js";
import { x as S, o as V, cO as v, jJ as h, jR as D, jl as H, cE as A, ac as M, P as U } from "../../../../shared/runtime.js";
import { g as q } from "../../../../modules/right-page-12d526dc.js";
import { _ as F } from "../../../../modules/raw-materials.vue_vue_type_script_setup_true_lang-78536997.js";
import O from "./finished-products.vue.js";
const Q = { __name: "index", setup(P) {
  const c = g(), p = x(null), { crud: a, columns: i, CRUD: y } = S({ title: "采购明细维度", optShow: { add: false, delete: false }, crudApi: { get: q }, queryOnPresenterCreated: false }, p);
  f(() => c.purchaseType, (s) => {
    s === "details" && a.toQuery();
  }, { immediate: true });
  const { maxHeight: _ } = V({ paginate: true, wrapperBox: ".header", extraHeight: 200 });
  return y.HOOK.handleRefresh = async (s, { data: { content: o } }) => {
    await v(o, { multipleSpec: true }), o.forEach((m) => {
      m.basicClass = m.basicClassEnum;
    });
    const { query: { materialType: l } } = s;
    l === h.MANUFACTURED.V ? s.data = await D(o, { toNum: true }, { mete: ["mete"], amount: ["price", "priceExcludingVat"] }) : s.data = await H(o, { toSmallest: false, toNum: true }, { mete: ["mete", "actualReceivedMete"], amount: ["price", "priceExcludingVat"] });
  }, f(() => a.query.materialType, () => {
    a.setColumns();
  }), (s, o) => {
    const l = k, m = B;
    return t(), C(T, null, [n(R, { form: e(c).props.form }, null, 8, ["form"]), w((t(), r(M, { ref_key: "tableRef", ref: p, data: e(a).data, "empty-text": e(a).emptyText, maxHeight: e(_) }, { default: d(() => [n(l, { align: "center", label: "序号", type: "index", width: "60" }), e(i).visible("purchaseSerialNumber") ? (t(), r(l, { key: "purchaseSerialNumber", align: "left", label: "采购合同", prop: "purchaseSerialNumber", "show-overflow-tooltip": "", width: "200" })) : u("", true), e(i).visible("supplier.name") ? (t(), r(l, { key: "supplier", align: "left", label: "供应商", prop: "supplier.name", "show-overflow-tooltip": "", width: "180" })) : u("", true), e(i).visible("basicClass") ? (t(), r(l, { key: "basicClass", align: "center", label: "材料类型" }, { default: d(({ row: b }) => [E("span", null, N(e(A).VL[b.basicClassEnum]), 1)]), _: 1 })) : u("", true), e(a).query.materialType === e(h).MANUFACTURED.V ? (t(), r(O, { key: 3, columns: e(i) }, null, 8, ["columns"])) : (t(), r(F, { key: 4, columns: e(i) }, null, 8, ["columns"]))]), _: 1 }, 8, ["data", "empty-text", "maxHeight"])), [[m, e(a).loading]]), n(U)], 64);
  };
} };
export {
  Q as default
};
