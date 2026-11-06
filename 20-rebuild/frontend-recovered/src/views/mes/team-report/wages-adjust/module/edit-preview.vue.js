import { ref as x } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as w } from "vue";
import { createBlock as v } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as V } from "vue";
import { unref as o } from "vue";
import { isRef as H } from "vue";
import { ElNotification as B } from "element-plus";
import { ElTableColumn as C } from "element-plus";
import { e as D } from "../../../../../modules/index-31ff7034.js";
import { u as k, o as N } from "../../../../../shared/runtime.js";
import { _ as R } from "../../../../../modules/index-3b2628f3.js";
import { _ as T } from "../../../../../modules/index-61ce89a1.js";
const z = { __name: "edit-preview", props: { visible: { type: Boolean, default: false }, modifiedData: { type: Array, default: () => [] }, data: { type: Object, default: () => {
} } }, emits: ["success", "update:visible"], setup(i, { emit: p }) {
  const c = p, d = i, m = x(false), { visible: l, handleClose: u } = k({ emit: c, props: d, field: "visible" }), { maxHeight: _ } = N({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false, extraHeight: 150 }, l);
  async function b() {
    try {
      m.value = true;
      const s = d.modifiedData.filter((e) => e.price).map((e) => ({ teamId: e.id, wages: e.price }));
      await D({ details: s, ...d.data }), B({ title: "班组工价修改成功", type: "success" }), u(), c("success");
    } catch (s) {
      console.log("操作失败", s);
    } finally {
      m.value = false;
    }
  }
  return (s, e) => {
    const g = r("common-button"), f = C, h = r("common-table"), y = r("common-dialog");
    return w(), v(y, { title: "班组工价修改预览", modelValue: o(l), "onUpdate:modelValue": e[0] || (e[0] = (n) => H(l) ? l.value = n : null), top: "5vh", "append-to-body": "", "before-close": o(u), width: "50%" }, { titleRight: a(() => [t(g, { loading: m.value, size: "default", disabled: !i.modifiedData || i.modifiedData.length == 0, type: "primary", onClick: b }, { default: a(() => e[1] || (e[1] = [V(" 保 存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), default: a(() => [t(h, { data: i.modifiedData, "max-height": o(_), "empty-text": "未做改动", style: { width: "100%" } }, { default: a(() => [t(f, { label: "序号", type: "index", align: "center", width: "60" }), t(o(R), { showProductionLine: "", showTeam: "" }), t(f, { align: "center", prop: "price", label: "单价" }, { default: a(({ row: n }) => [t(o(T), { old: n.wages, new: n.price }, null, 8, ["old", "new"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  z as default
};
