import { ref as i } from "vue";
import { watch as C } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as f } from "vue";
import { createBlock as w } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as I } from "vue";
import { unref as m } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as v } from "vue";
import { createTextVNode as N } from "vue";
import { isRef as H } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as D } from "element-plus";
import { u as F, o as L } from "../../../../shared/runtime.js";
const S = { __name: "task-printed-record-drawer", props: { visible: { type: Boolean, default: false }, taskId: { type: [Number, String], default: void 0 }, getPrintRecord: { type: Function, required: true } }, emits: ["update:visible"], setup(_, { emit: h }) {
  const c = i(), g = h, a = _, { visible: n, handleClose: x } = F({ emit: g, props: a, field: "visible" }), { maxHeight: y } = L({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, c), k = i([["startTime", "parse-time"], ["endTime", "parse-time"]]), d = i(false), u = i([]);
  C([() => a.visible, () => a.taskId], ([t, e]) => {
    t && R();
  }, { immediate: true });
  async function R() {
    d.value = true;
    try {
      const { content: t = [] } = await a.getPrintRecord(a.taskId);
      u.value = t;
    } catch (t) {
      console.log("获取打印记录", t);
    } finally {
      d.value = false;
    }
  }
  return (t, e) => {
    const o = q, V = p("common-table"), B = p("common-drawer"), T = D;
    return f(), w(B, { ref_key: "drawerRef", ref: c, title: "打印详情", modelValue: m(n), "onUpdate:modelValue": e[0] || (e[0] = (r) => H(n) ? n.value = r : null), direction: "rtl", "before-close": m(x), size: "50%" }, { titleRight: l(() => e[1] || (e[1] = [])), content: l(() => [I((f(), w(V, { data: u.value, "data-format": k.value, "max-height": m(y), style: { width: "100%" } }, { default: l(() => [s(o, { label: "序号", type: "index", align: "center", width: "60" }), s(o, { "show-overflow-tooltip": true, prop: "userName", label: "操作人", "min-width": "110px" }), s(o, { "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center", "min-width": "80px" }), s(o, { "show-overflow-tooltip": true, prop: "time", label: "打印时间", "min-width": "300px" }, { default: l((r) => [b("span", null, v(r.row.startTime), 1), e[2] || (e[2] = N(" ~ ")), b("span", null, v(r.row.startTime), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[T, d.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  S as default
};
