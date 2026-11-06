import { inject as A } from "vue";
import { ref as v } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as F } from "vue";
import { createElementBlock as H } from "vue";
import { withDirectives as E } from "vue";
import { vShow as _ } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as l } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as I } from "vue";
import { unref as g } from "vue";
import { withModifiers as y } from "vue";
import { createTextVNode as x } from "vue";
import { ElMessageBox as M } from "element-plus";
import { ElNotification as O } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { ElSwitch as P } from "element-plus";
import { ElPopover as G } from "element-plus";
import { e as J, d as K } from "../../../../../modules/unloading-config-d2b6e127.js";
import { au as c } from "../../../../../shared/runtime.js";
import Q from "./module/form.vue.js";
const W = { style: { "text-align": "right", margin: "0" } }, te = { __name: "index", props: { cutConfigRow: { type: Object, default: () => {
} } }, emits: ["refresh-cut-config"], setup(r, { expose: D, emit: k }) {
  const V = k, R = A("maxHeight"), m = v(false), d = v(false), o = v({}), h = r;
  async function B(i, e) {
    try {
      await M.confirm(`此操作将${h.cutConfigRow.name}的开孔方式改为${c.VL[e]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await J({ id: i.id, boolDrillEnum: e }), p(), O({ title: `${h.cutConfigRow.name}的开孔方式修改成功`, type: "success", duration: 3e3 });
    } catch (a) {
      console.log("变更是否开孔状态", a), i.boolDrillEnum = i.boolDrillEnum === c.TRUE.V ? c.FALSE.V : c.TRUE.V;
    }
  }
  function T(i) {
    o.value = i, m.value = true, d.value = true;
  }
  function U(i) {
    o.value = i, i.deleteBtn = true;
  }
  function $() {
    o.value.deleteBtn = false;
  }
  function p() {
    V("refresh-cut-config");
  }
  async function S() {
    o.value.deleteBtn = false;
    try {
      await K([o.value.id]), p();
    } catch (i) {
      console.log("删除切割配置详情失败", i);
    }
  }
  function z() {
    m.value = false, d.value = true;
  }
  return D({ toAdd: z }), (i, e) => {
    var b, C;
    const a = q, L = P, f = w("common-button"), N = G, j = w("common-table");
    return F(), H("div", null, [E(u("div", null, e[1] || (e[1] = [u("div", { class: "my-code" }, "点击切割形式查看详情", -1)]), 512), [[_, !((b = r.cutConfigRow) != null && b.id)]]), E(u("div", null, [l(j, { ref: "tableRef", data: r.cutConfigRow.detailConfigDTOList, "max-height": g(R) + 92, style: { width: "100%" } }, { default: n(() => [l(a, { label: "序号", type: "index", align: "center", width: "60" }), l(a, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, align: "center", label: "厚度", width: "140" }, { default: n(({ row: t }) => [u("span", null, I(t.thickness), 1)]), _: 1 }), l(a, { key: "boolDrillEnum", prop: "boolDrillEnum", "show-overflow-tooltip": true, align: "center", label: "是否切孔", "min-width": "100" }, { default: n(({ row: t }) => [l(L, { modelValue: t.boolDrillEnum, "onUpdate:modelValue": (s) => t.boolDrillEnum = s, "active-value": g(c).TRUE.V, "inactive-value": g(c).FALSE.V, class: "drawer-switch", onChange: (s) => B(t, t.boolDrillEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onChange"])]), _: 1 }), l(a, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: n(({ row: t }) => [l(f, { class: "filter-item", size: "default", type: "primary", icon: "el-icon-edit", onClick: y((s) => T(t), ["stop"]) }, null, 8, ["onClick"]), l(N, { visible: t.deleteBtn, "onUpdate:visible": (s) => t.deleteBtn = s, placement: "top", width: "180", trigger: "manual" }, { reference: n(() => [l(f, { type: "danger", icon: "el-icon-delete", size: "default", onClick: y((s) => U(t), ["stop"]) }, null, 8, ["onClick"])]), default: n(() => [e[4] || (e[4] = u("p", null, "确认删除本条数据吗？", -1)), u("div", W, [l(f, { size: "default", link: "", type: "primary", onClick: $ }, { default: n(() => e[2] || (e[2] = [x("取消")])), _: 1, __: [2] }), l(f, { type: "primary", size: "default", onClick: S }, { default: n(() => e[3] || (e[3] = [x("确定")])), _: 1, __: [3] })])]), _: 2, __: [4] }, 1032, ["visible", "onUpdate:visible"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), l(Q, { visible: d.value, "onUpdate:visible": e[0] || (e[0] = (t) => d.value = t), isEdit: m.value, "form-data": o.value, cutConfigId: r.cutConfigRow.id, onRefresh: p }, null, 8, ["visible", "isEdit", "form-data", "cutConfigId"])], 512), [[_, (C = r.cutConfigRow) == null ? void 0 : C.id]])]);
  };
} };
export {
  te as default
};
