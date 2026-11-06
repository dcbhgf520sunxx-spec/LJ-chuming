import { ref as h } from "vue";
import { watch as V } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as W } from "vue";
import { createBlock as R } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as a } from "vue";
import { unref as c } from "vue";
import { toDisplayString as i } from "vue";
import { isRef as S } from "vue";
import { ElMessage as P } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { l as b, u as q, x as z, o as A, P as H } from "../../../../../shared/runtime.js";
function B(n) {
  return b({ module: "plan", url: "production-scheduling/list-scheduling/project-list", method: "get", params: n });
}
function F(n) {
  return b({ module: "plan", url: "production-scheduling/list-scheduling/workshop-list", method: "get", params: n });
}
function E(n) {
  return b({ module: "plan", url: "production-scheduling/list-scheduling/not-scheduling-list", method: "get", params: n });
}
const I = { get: B }, M = { __name: "summary-list", props: { visible: { type: Boolean, default: false }, summaryListData: { type: Array, default: () => [] } }, emits: ["update:visible"], setup(n, { emit: v }) {
  const d = v, m = n, y = h(), p = h(false);
  V(() => m.summaryListData, (r) => {
    r && (g.value = m.summaryListData);
  });
  const { visible: f, handleClose: _ } = q({ emit: d, props: m, field: "visible", showHook: C, closeHook: close });
  z({ title: "清单分拣", sort: [], crudApi: { get: E }, hasPagination: true, queryOnPresenterCreated: false }, y);
  const { maxHeight: k } = A({ paginate: true }), g = h();
  function N(r) {
    g.value.forEach((s, u) => {
      r.id === s.id && g.value.splice(u, 1);
    }), d("delete", r.id);
  }
  async function x() {
    p.value = true;
    try {
      const r = {};
      P.success("提交成功"), d("success"), _();
    } catch (r) {
      console.log(r);
    } finally {
      p.value = false;
    }
  }
  function C() {
  }
  return (r, s) => {
    const u = w("common-button"), l = j, D = w("common-table"), L = w("common-drawer");
    return W(), R(L, { ref: "drawerRef", title: "清单汇总", modelValue: c(f), "onUpdate:modelValue": s[0] || (s[0] = (e) => S(f) ? f.value = e : null), "before-close": c(_), size: "70%", "custom-class": "model-drawer" }, { titleAfter: o(() => s[1] || (s[1] = [])), titleRight: o(() => [t(u, { loading: p.value, type: "success", size: "default", onClick: x }, { default: o(() => s[2] || (s[2] = [a("确认")])), _: 1, __: [2] }, 8, ["loading"])]), content: o(() => [t(D, { ref_key: "tableRef", ref: y, data: n.summaryListData, "max-height": c(k), style: { width: "100%" } }, { default: o(() => [t(l, { type: "selection", width: "55", align: "center" }), t(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(l, { key: "areaName", prop: "areaName", "show-overflow-tooltip": "", label: "单体", align: "center" }, { default: o((e) => [a(i(e.row.areaName || "-"), 1)]), _: 1 }), t(l, { key: "areaName", prop: "areaName", "show-overflow-tooltip": "", label: "区域", align: "center" }, { default: o((e) => [a(i(e.row.areaName || "-"), 1)]), _: 1 }), t(l, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", align: "center" }, { default: o((e) => [a(i(e.row.name || "-"), 1)]), _: 1 }), t(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: o((e) => [a(i(e.row.serialNumber || "-"), 1)]), _: 1 }), t(l, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center" }, { default: o((e) => [a(i(e.row.specification || "-"), 1)]), _: 1 }), t(l, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "center" }, { default: o((e) => [a(i(e.row.length || "-"), 1)]), _: 1 }), t(l, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center" }, { default: o((e) => [a(i(e.row.material || "-"), 1)]), _: 1 }), t(l, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: o((e) => [a(i(e.row.quantity || "-"), 1)]), _: 1 }), t(l, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": "", label: "单净重（kg）", align: "center" }, { default: o((e) => [a(i(e.row.netWeight || "-"), 1)]), _: 1 }), t(l, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": "", label: "总净重（kg）", align: "center" }, { default: o((e) => [a(i(e.row.totalNetWeight || "-"), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": "", label: "操作", align: "center" }, { default: o((e) => [t(u, { type: "danger", size: "default", icon: "el-icon-delete", onClick: (O) => N(e.row), disabled: !e.row.id }, null, 8, ["onClick", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), t(c(H))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, $ = Object.freeze(Object.defineProperty({ __proto__: null, default: M }, Symbol.toStringTag, { value: "Module" }));
export {
  M as _,
  E as a,
  I as c,
  F as g,
  $ as s
};
