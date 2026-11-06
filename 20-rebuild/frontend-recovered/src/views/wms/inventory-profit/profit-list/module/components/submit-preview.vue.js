import { ref as _ } from "vue";
import { useStore as D } from "vuex";
import { inject as H } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as o } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as u } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as f } from "vue";
import { withDirectives as L } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as h } from "vue";
import { isRef as O } from "vue";
import { ElMessage as R } from "element-plus";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { ElForm as J } from "element-plus";
import { vLoading as K } from "element-plus";
import { jX as U, u as Y, o as G, xL as Q, bD as X, vg as S, i as W, aR as Z, jG as ee, jH as ae, z as te, xP as oe, jl as se, xQ as le, t0 as ne, xR as ie, ba as re } from "../../../../../../shared/runtime.js";
const ue = { class: "main-content" }, me = { class: "mtb-10", style: { "margin-left": "30px" } }, ce = { __name: "submit-preview", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue", "success"], setup(B, { emit: C }) {
  const w = _([]), k = D(), N = _(), y = C, T = B, l = H("crud").form, m = _(false), E = _([...U]), { visible: b, handleClose: x } = Y({ emit: y, props: T }), { maxHeight: j } = G({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, N);
  async function V(d) {
    m.value = true;
    try {
      const t = JSON.parse(JSON.stringify(l));
      t.list = await se(t.list, { toSmallest: true, toNum: true }), d ? await le(t).then((p) => {
        p && (y("success", d), R.success("提交审核成功"), k.dispatch("approval_list/fetchApprovalNum", ne.INVENTORY_PROFIT.V), k.dispatch("approval_list/fetchApprovalNum"));
      }) : await ie(t).then((p) => {
        p && (y("success", d), R.success("已添加至清单"));
      });
    } finally {
      m.value = false, x();
    }
  }
  function A(d) {
    return re(d, { props: ["amount", "quantity", "mete"], toThousandFields: ["amount", "quantity", "mete"] });
  }
  return (d, t) => {
    const p = $, g = v("common-button"), n = q, z = v("common-table"), P = J, F = v("common-drawer"), I = K;
    return i(), c(F, { ref_key: "drawerRef", ref: N, modelValue: a(b), "onUpdate:modelValue": t[3] || (t[3] = (e) => O(b) ? b.value = e : null), "before-close": a(x), direction: "rtl", size: "100%", title: "提交预览" }, { titleAfter: o(() => [s(p, { effect: "plain", size: "medium" }, { default: o(() => {
      var e;
      return [r(u((e = a(Q).V[a(l).boolPartyA]) == null ? void 0 : e.SL), 1)];
    }), _: 1 }), a(l).boolPartyA ? f("", true) : (i(), c(p, { key: 0, effect: "plain", size: "medium" }, { default: o(() => [r(" 发票及税率：" + u(a(X).VL[a(l).invoiceType]) + "(" + u(a(l).taxRate) + "%) ", 1)]), _: 1 }))]), titleRight: o(() => [s(g, { loading: m.value, size: "default", type: "success", onClick: a(x) }, { default: o(() => t[4] || (t[4] = [r(" 上一步 ")])), _: 1, __: [4] }, 8, ["loading", "onClick"]), s(g, { loading: m.value, size: "default", type: "warning", onClick: t[0] || (t[0] = (e) => V(a(S).NO.V)) }, { default: o(() => t[5] || (t[5] = [r(" 保存至盘盈清单 ")])), _: 1, __: [5] }, 8, ["loading"]), s(g, { loading: m.value, size: "default", type: "primary", onClick: t[1] || (t[1] = (e) => V(a(S).YES.V)) }, { default: o(() => t[6] || (t[6] = [r(" 提交 ")])), _: 1, __: [6] }, 8, ["loading"])]), content: o(() => [L((i(), M("div", ue, [a(W)(a(l)) ? (i(), c(P, { key: 0, model: a(l), "label-position": "left", "label-width": "100px", size: "default" }, { default: o(() => [s(z, { data: a(l).list, "data-format": E.value, "max-height": a(j), stripe: false, "summary-method": A, "expand-row-keys": w.value, "row-key": "uid", "show-summary": "" }, { default: o(() => [s(Z, { "expand-row-keys": w.value, "onUpdate:expandRowKeys": t[2] || (t[2] = (e) => w.value = e), data: a(l).list, "row-key": "uid", fixed: "left" }, { default: o(({ row: e }) => [h("div", me, [h("span", null, "备注：" + u(e.remark || "-"), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: o(({ $index: e }) => [h("span", null, u(e + 1), 1)]), _: 1 }), s(ee, { showIndex: false, "show-is-whole": "" }), s(ae), a(l).boolPartyA ? f("", true) : (i(), c(n, { key: 0, align: "left", label: "含税单价", "min-width": "100px", prop: "unitPrice" })), a(l).boolPartyA ? f("", true) : (i(), c(n, { key: 1, align: "left", label: "含税金额", "min-width": "100px", prop: "amount" })), s(n, { align: "left", label: "品牌", "min-width": "80px", prop: "brand" }), s(n, { align: "left", label: "炉批号/卷号", "min-width": "80px", prop: "heatNoAndBatchNo" }), s(n, { align: "left", label: "项目", "min-width": "130px", prop: "project" }, { default: o(({ row: { sourceRow: e } }) => [r(u(a(te)(e.project) || "-"), 1)]), _: 1 }), s(n, { align: "left", label: "仓库", "min-width": "130px", prop: "workshop" }, { default: o(({ row: { sourceRow: e } }) => [s(oe, { id: e.workshop ? e.workshop.id : e.workshopId }, null, 8, ["id"]), r(" " + u(e.warehouse ? e.warehouse.name : e.warehouseName), 1)]), _: 1 }), a(l).boolPartyA ? f("", true) : (i(), c(n, { key: 2, align: "left", label: "供应商", "min-width": "130px", prop: "supplier.name" }))]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["model"])) : f("", true)])), [[I, m.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ce as default
};
