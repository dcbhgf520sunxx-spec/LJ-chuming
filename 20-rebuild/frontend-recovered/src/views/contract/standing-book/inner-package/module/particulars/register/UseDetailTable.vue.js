import { ref as c } from "vue";
import { inject as O } from "vue";
import { watch as x } from "vue";
import { computed as P } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as a } from "vue";
import { withCtx as o } from "vue";
import { Fragment as R } from "vue";
import { renderList as A } from "vue";
import { createBlock as m } from "vue";
import { unref as _ } from "vue";
import { withDirectives as M } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as I } from "vue";
import { ElOption as F } from "element-plus";
import { ElSelect as H } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElPopover as q } from "element-plus";
import { ElTable as z } from "element-plus";
import { vLoading as Q } from "element-plus";
import { _ as G, o as J, iv as K, j1 as T, ec as W } from "../../../../../../../shared/runtime.js";
import { u as X } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const Y = { class: "table-container" }, Z = { key: 0 }, ee = { key: 1 }, ae = { key: 0 }, te = { key: 1 }, oe = { __name: "UseDetailTable", setup(le) {
  const v = c([]), g = c(false), y = c(), w = c(), { projectInfo: p, _commonFn: k } = O("parent_data"), { maxHeight: B } = J({ wrapperBox: ".register-info-container", extraBox: ".header-container", paginate: false, extraHeight: 200 }), b = async (n) => {
    var r, d;
    try {
      g.value = true;
      const s = await T.get(`/api/contract/Injection/getAssetInjectionDetail/${p.project.id}`, { supplierId: n });
      y.value = (r = s[0]) == null ? void 0 : r.contractSignBodyName, w.value = (d = s[0]) == null ? void 0 : d.projectManagerName, v.value = W(s);
    } catch (s) {
      console.error("获取使用注资明细失败:getTableData", s);
    } finally {
      g.value = false;
    }
  };
  k.value.getUseTableData = b, x(() => p.project.id, (n) => {
    n && b();
  }, { immediate: true });
  const { getSummaries: N } = X(false, { defineData: ["amount", "contractSignBodyPayAmount", "contractSignBodyRemainAmount", "projectManagerPayAmount", "projectManagerRemainAmount"] }), u = c(), j = c([]);
  (async () => {
    try {
      j.value = await T.get(`/api/contract/Injection/getPurchaseOrder/${p.project.id}`);
    } catch (n) {
      console.error("获取供应商信息失败:getPurchaseOrder", n);
    }
  })(), x(() => u.value, async (n) => {
    await b(n);
  });
  const S = P(() => p.projectAttribute !== 3);
  return (n, r) => {
    const d = F, s = H, E = D("print-table"), U = D("table-header"), l = $, V = q, C = z, L = Q;
    return t(), i("div", Y, [a(U, { "header-title": "" }, { headerLeft: o(() => [a(s, { modelValue: u.value, "onUpdate:modelValue": r[0] || (r[0] = (e) => u.value = e), clearable: "", placeholder: "选择供应商" }, { default: o(() => [(t(true), i(R, null, A(j.value, (e) => (t(), m(d, { key: e.supplierId, label: e.supplierName, value: e.supplierId }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), headerRight: o(() => [a(E, { params: { projectId: _(p).project.id, supplierId: u.value }, "api-key": "capitalInjectionUse", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"])]), _: 1 }), M((t(), m(C, { ref: "tableRef", data: v.value, "max-height": _(B), "summary-method": _(N), border: "", "show-summary": "", stripe: "" }, { default: o(() => [a(l, { align: "center", label: "序号", type: "index", width: "60" }), a(l, { align: "center", label: "日期", "min-width": "100", prop: "assetInjectionTime", width: "120" }), a(l, { align: "center", label: "摘要", "min-width": "120", prop: "supplier.supplierName", "show-overflow-tooltip": "" }), a(l, { align: "center", label: "类型", prop: "type" }, { default: o(({ row: e }) => [h("span", null, f(_(K).VL[e.type]), 1)]), _: 1 }), a(l, { align: "center", label: "支付金额", prop: "amount" }), S.value ? (t(), m(l, { key: 0, label: y.value, align: "center", prop: "subject" }, { default: o(() => [a(l, { align: "center", label: "支付金额", "min-width": "120", prop: "contractSignBodyPayAmount" }, { default: o(({ row: { contractSignBodyPayAmount: e } }) => [e ? (t(), i("span", Z, f(e), 1)) : (t(), i("span", ee, "-"))]), _: 1 })]), _: 1 }, 8, ["label"])) : I("", true), a(l, { label: w.value, align: "center", prop: "projectManager" }, { default: o(() => [a(l, { align: "center", label: "支付金额", prop: "projectManagerPayAmount" }, { default: o(({ row: { projectManagerPayAmount: e } }) => [e ? (t(), i("span", ae, f(e), 1)) : (t(), i("span", te, "-")), e && e == "0.00" ? (t(), m(V, { key: 2, width: 200, content: "注资额度不足，已使用项目授信进行支付", placement: "bottom-start", title: "", trigger: "hover" }, { reference: o(() => r[1] || (r[1] = [h("div", { class: "status" }, [h("span", null, "说明")], -1)])), _: 1 })) : I("", true)]), _: 1 })]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[L, g.value]])]);
  };
} }, ie = G(oe, [["__scopeId", "data-v-0b6520dd"]]);
export {
  ie as default
};
