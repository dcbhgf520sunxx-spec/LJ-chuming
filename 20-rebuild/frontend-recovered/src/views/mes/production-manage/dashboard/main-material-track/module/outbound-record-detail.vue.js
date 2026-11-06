import { ref as w } from "vue";
import { watch as L } from "vue";
import { computed as x } from "vue";
import p from "moment";
import { resolveComponent as C } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as k } from "vue";
import { createBlock as z } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as l } from "vue";
import { withDirectives as c } from "vue";
import { createTextVNode as U } from "vue";
import { unref as s } from "vue";
import { toDisplayString as i } from "vue";
import { isRef as A } from "vue";
import { ElTag as J } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElPagination as F } from "element-plus";
import { vLoading as G } from "element-plus";
import { o as K } from "../../../../../../modules/main-material-track-74a129d5.js";
import { u as Q, J as W, o as X } from "../../../../../../shared/runtime.js";
const te = { __name: "outbound-record-detail", props: { visible: { type: Boolean, default: false }, projectId: { type: Number }, month: { type: String } }, emits: ["update:visible"], setup(V, { emit: B }) {
  const v = w(), D = B, r = V, { visible: m, handleClose: R } = Q({ emit: D, props: r, field: "visible" }), { handleSizeChange: S, handleCurrentChange: T, total: j, setTotalPage: q, queryPage: d } = W({ fetchHook: y }), { maxHeight: H } = X({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, v);
  L(() => r.visible, (u) => {
    u && y();
  }, { immediate: true });
  const I = x(() => r.month && p(p(r.month)).startOf("month").valueOf()), N = x(() => r.month && p(p(r.month)).endOf("month").valueOf()), f = w(false), b = w([]);
  async function y() {
    try {
      f.value = true;
      const u = Object.assign({ projectId: r.projectId, month: r.month }, d), { content: n, totalElements: g } = await K(u);
      b.value = n.map((a, h) => (a.rowId = h + "" + Math.random(), a)), q(g);
    } catch {
      console.log("获取详情列表失败");
    } finally {
      f.value = false;
    }
  }
  return (u, n) => {
    const g = J, a = Y, h = C("common-table"), O = F, E = C("common-drawer"), _ = M("parse-time"), P = G;
    return k(), z(E, { ref_key: "drawerRef", ref: v, title: "钢材出库记录", modelValue: s(m), "onUpdate:modelValue": n[0] || (n[0] = (e) => A(m) ? m.value = e : null), direction: "rtl", "before-close": s(R), size: "90%" }, { titleAfter: t(() => [o(g, { effect: "plain", size: "large" }, { default: t(() => [n[1] || (n[1] = l("span", null, "统计日期：", -1)), c(l("span", null, null, 512), [[_, { val: I.value, fmt: "{y}-{m}-{d}" }]]), n[2] || (n[2] = U(" ~ ")), c(l("span", null, null, 512), [[_, { val: N.value, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [1, 2] })]), titleRight: t(() => n[3] || (n[3] = [])), content: t(() => [c((k(), z(h, { data: b.value, "max-height": s(H), style: { width: "100%" } }, { default: t(() => [o(a, { label: "序号", type: "index", align: "center", width: "60" }), o(a, { prop: "name", "show-overflow-tooltip": true, label: "品名", align: "center" }, { default: t(({ row: e }) => [l("span", null, i(e.name), 1)]), _: 1 }), o(a, { prop: "thickness", "show-overflow-tooltip": true, label: "厚度/规格", align: "center" }, { default: t(({ row: e }) => [l("span", null, i(e.thickness), 1)]), _: 1 }), o(a, { prop: "unit", "show-overflow-tooltip": true, label: "计量单位", align: "center" }, { default: t(({ row: e }) => [l("span", null, i(e.unit), 1)]), _: 1 }), o(a, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: t(({ row: e }) => [l("span", null, i(e.quantity), 1)]), _: 1 }), o(a, { prop: "checkUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: t(({ row: e }) => [l("span", null, i(e.checkUnit), 1)]), _: 1 }), o(a, { prop: "weight", "show-overflow-tooltip": true, label: "重量", align: "center" }, { default: t(({ row: e }) => [l("span", null, i(e.weight), 1)]), _: 1 }), o(a, { prop: "type", "show-overflow-tooltip": true, label: "类别", align: "center" }, { default: t(({ row: e }) => [l("span", null, i(e.type), 1)]), _: 1 }), o(a, { prop: "createTime", "show-overflow-tooltip": true, label: "日期", align: "center", width: "120px" }, { default: t(({ row: e }) => [c(l("span", null, null, 512), [[_, { val: e.createTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[P, f.value]]), o(O, { total: s(j), "current-page": s(d).pageNumber, "page-size": s(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(S), onCurrentChange: s(T) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
