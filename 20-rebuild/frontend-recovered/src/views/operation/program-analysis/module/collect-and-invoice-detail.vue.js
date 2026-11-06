import { ref as N } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as v } from "vue";
import { createBlock as g } from "vue";
import { withCtx as t } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as p } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as D } from "vue";
import { createElementVNode as _ } from "vue";
import { isRef as R } from "vue";
import { ElTag as T } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { h as z, i as H } from "../../../../modules/program-analysis-f1c6c876.js";
import { u as L, G as I, o as O, z as S, L as E, ba as F } from "../../../../shared/runtime.js";
const U = { __name: "collect-and-invoice-detail", props: { visible: { type: Boolean, default: false }, projectInfo: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(i, { emit: j }) {
  const d = N([]), x = j, r = i, { visible: u, handleClose: C } = L({ emit: x, props: r, field: "visible", showHook: A });
  async function A() {
    var o, c, a;
    if (!I((o = r.permission) == null ? void 0 : o.detail)) return false;
    let s = [];
    try {
      s = await z({ projectId: (c = r.projectInfo) == null ? void 0 : c.id, branchCompanyId: (a = r.query) == null ? void 0 : a.branchCompanyId }) || [];
    } catch (m) {
      console.log("获取收款及开票记录失败", m);
    } finally {
      d.value = s;
    }
  }
  const { maxHeight: V } = O({ extraBox: [".head-container"], paginate: true });
  function k(s) {
    return F(s, { props: ["collectionAmount", "invoiceAmount"] });
  }
  return (s, o) => {
    const c = T, a = q, m = y("common-table"), B = y("common-drawer");
    return v(), g(B, { ref: "drawerRef", title: "收款及开票详情", modelValue: l(u), "onUpdate:modelValue": o[0] || (o[0] = (e) => R(u) ? u.value = e : null), direction: "rtl", "before-close": l(C), size: "50%" }, { titleAfter: t(() => [n(c, { effect: "plain", size: "large", class: "filter-item" }, { default: t(() => [w(" 项目： " + p(l(S)(i.projectInfo.project) || "-"), 1)]), _: 1 })]), titleRight: t(() => {
      var e, f, b, h;
      return [l(I)((e = i.permission) == null ? void 0 : e.download) ? (v(), g(E, { key: 0, fn: l(H), params: { projectId: (f = i.projectInfo) == null ? void 0 : f.id, branchCompanyId: (b = i.query) == null ? void 0 : b.branchCompanyId }, disabled: !((h = d.value) != null && h.length) }, { default: t(() => o[1] || (o[1] = [w(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : D("", true)];
    }), content: t(() => [n(m, { ref: "tableRef", data: d.value, "max-height": l(V), style: { width: "100%" }, "show-empty-symbol": false, "show-summary": "", "summary-method": k }, { default: t(() => [n(a, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), n(a, { "show-overflow-tooltip": true, prop: "dateTime", label: "日期", align: "center" }), n(a, { "show-overflow-tooltip": true, prop: "collectionAmount", label: "收款（元）", align: "center" }, { default: t(({ row: e }) => [_("span", null, p(e.collectionAmount ? e.collectionAmount : 0), 1)]), _: 1 }), n(a, { "show-overflow-tooltip": true, prop: "invoiceAmount", label: "开票（元）", align: "center" }, { default: t(({ row: e }) => [_("span", null, p(e.invoiceAmount ? e.invoiceAmount : 0), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  U as default
};
