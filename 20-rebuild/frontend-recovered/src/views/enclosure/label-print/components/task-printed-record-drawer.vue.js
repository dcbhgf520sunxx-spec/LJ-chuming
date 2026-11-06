import { ref as r } from "vue";
import { watch as B } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as f } from "vue";
import { createBlock as w } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as I } from "vue";
import { unref as c } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as C } from "vue";
import { toDisplayString as H } from "vue";
import { isRef as N } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as E } from "element-plus";
import { u as T, o as D } from "../../../../shared/runtime.js";
const M = { __name: "task-printed-record-drawer", props: { visible: { type: Boolean, default: false }, taskId: { type: [Number, String], default: void 0 }, getEnclosureRecord: { type: Function, required: true } }, emits: ["update:visible"], setup(_, { emit: b }) {
  const m = r(), v = b, t = _, { visible: s, handleClose: h } = T({ emit: v, props: t, field: "visible" }), { maxHeight: g } = D({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, m), x = r([["printTime", "parse-time"]]), n = r(false), u = r([]);
  B([() => t.visible, () => t.taskId], ([e, a]) => {
    e && y();
  }, { immediate: true });
  async function y() {
    n.value = true;
    try {
      const e = await t.getEnclosureRecord({ taskId: t.taskId });
      u.value = e || [];
    } catch (e) {
      console.log("获取打印记录", e);
    } finally {
      n.value = false;
    }
  }
  return (e, a) => {
    const o = q, k = p("common-table"), R = p("common-drawer"), V = E;
    return f(), w(R, { ref_key: "drawerRef", ref: m, title: "打印详情", modelValue: c(s), "onUpdate:modelValue": a[0] || (a[0] = (d) => N(s) ? s.value = d : null), direction: "rtl", "before-close": c(h), size: "50%" }, { titleRight: l(() => a[1] || (a[1] = [])), content: l(() => [I((f(), w(k, { data: u.value, "data-format": x.value, "max-height": c(g), style: { width: "100%" } }, { default: l(() => [i(o, { label: "序号", type: "index", align: "center", width: "60" }), i(o, { "show-overflow-tooltip": true, prop: "userName", label: "操作人", "min-width": "110px" }), i(o, { "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center", "min-width": "80px" }), i(o, { "show-overflow-tooltip": true, prop: "time", label: "打印时间", "min-width": "300px" }, { default: l((d) => [C("span", null, H(d.row.printTime), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[V, n.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  M as default
};
