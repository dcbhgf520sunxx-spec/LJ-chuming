import { ref as V } from "vue";
import { inject as j } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createBlock as i } from "vue";
import { withCtx as t } from "vue";
import { createVNode as c } from "vue";
import { unref as o } from "vue";
import { createTextVNode as p } from "vue";
import { createCommentVNode as d } from "vue";
import { ElNotification as I } from "element-plus";
import { ElPopconfirm as L } from "element-plus";
import { u as T, L as U, m9 as E, G as A } from "../../../../../../shared/runtime.js";
import { g as $, _ as z, p as B } from "./enclosure/index.vue.js";
import "./enclosure/module/header.vue.js";
const q = { __name: "index", props: { modelValue: { type: Boolean }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "close"], setup(r, { emit: C }) {
  const D = r, f = C, { visible: N, handleClose: v } = T({ emit: f, props: D }), l = V(false), m = V(false), n = j("currentRow"), y = async (u) => {
    try {
      u === 16 ? l.value = true : m.value = true, await B({ checkStatus: u, id: n.value.id }), I({ title: "操作成功", type: "success" }), v(), f("close");
    } catch (e) {
      console.log(e);
    } finally {
      l.value = false, m.value = false;
    }
  };
  return (u, e) => {
    const _ = k("common-button"), g = L, R = k("common-drawer");
    return a(), i(R, { "before-close": o(v), visible: o(N), "custom-class": "approval-drawer", size: "100%", title: "清单明细" }, { titleRight: t(() => {
      var s, b, w;
      return [c(U, { params: { inventoryId: (s = o(n)) == null ? void 0 : s.id }, type: "primary", fn: o($) }, { default: t(() => e[2] || (e[2] = [p(" 待审核列表 ")])), _: 1, __: [2] }, 8, ["params", "fn"]), ((b = o(n)) == null ? void 0 : b.inventoryReviewedEnum) === o(E).UNAUDITED.V && o(A)(r.permission.audit) ? (a(), i(g, { key: 0, title: "确认是否驳回吗?", onConfirm: e[0] || (e[0] = (x) => y(16)) }, { reference: t(() => [c(_, { loading: l.value, size: "default", type: "danger" }, { default: t(() => e[3] || (e[3] = [p("驳回")])), _: 1, __: [3] }, 8, ["loading"])]), _: 1 })) : d("", true), ((w = o(n)) == null ? void 0 : w.inventoryReviewedEnum) === o(E).UNAUDITED.V && o(A)(r.permission.audit) ? (a(), i(g, { key: 1, title: "确认是否通过?", onConfirm: e[1] || (e[1] = (x) => y(8)) }, { reference: t(() => [c(_, { loading: m.value, size: "default", type: "success" }, { default: t(() => e[4] || (e[4] = [p("通过")])), _: 1, __: [4] }, 8, ["loading"])]), _: 1 })) : d("", true)];
    }), content: t(() => {
      var s;
      return [((s = o(n)) == null ? void 0 : s.buildingType) === "围护制品" ? (a(), i(z, { key: 0 })) : d("", true)];
    }), _: 1 }, 8, ["before-close", "visible"]);
  };
} };
export {
  q as default
};
