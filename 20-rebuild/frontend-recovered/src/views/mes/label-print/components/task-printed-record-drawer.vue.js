import { ref as i } from "vue";
import { watch as T } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as f } from "vue";
import { createBlock as w } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as C } from "vue";
import { unref as m } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as v } from "vue";
import { createTextVNode as N } from "vue";
import { isRef as H } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as D } from "element-plus";
import { u as F, o as L } from "../../../../shared/runtime.js";
const S = { __name: "task-printed-record-drawer", props: { visible: { type: Boolean, default: false }, taskId: { type: [Number, String], default: void 0 }, getPrintRecord: { type: Function, required: true } }, emits: ["update:visible"], setup(_, { emit: h }) {
  const u = i(), g = h, t = _, { visible: s, handleClose: x } = F({ emit: g, props: t, field: "visible" }), { maxHeight: y } = L({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, u), k = i([["startTime", "parse-time"], ["endTime", "parse-time"]]), d = i(false), c = i([]);
  T([() => t.visible, () => t.taskId], ([a, e]) => {
    a && R();
  }, { immediate: true });
  async function R() {
    if (t.taskId) {
      d.value = true;
      try {
        const { content: a = [] } = await t.getPrintRecord(t.taskId);
        c.value = a;
      } catch (a) {
        console.log("获取打印记录", a);
      } finally {
        d.value = false;
      }
    }
  }
  return (a, e) => {
    const o = q, V = p("common-table"), B = p("common-drawer"), I = D;
    return f(), w(B, { ref_key: "drawerRef", ref: u, title: "打印详情", modelValue: m(s), "onUpdate:modelValue": e[0] || (e[0] = (r) => H(s) ? s.value = r : null), direction: "rtl", "before-close": m(x), size: "50%" }, { titleRight: l(() => e[1] || (e[1] = [])), content: l(() => [C((f(), w(V, { data: c.value, "data-format": k.value, "max-height": m(y), style: { width: "100%" } }, { default: l(() => [n(o, { label: "序号", type: "index", align: "center", width: "60" }), n(o, { "show-overflow-tooltip": true, prop: "userName", label: "操作人", "min-width": "110px" }), n(o, { "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center", "min-width": "80px" }), n(o, { "show-overflow-tooltip": true, prop: "time", label: "打印时间", "min-width": "300px" }, { default: l((r) => [b("span", null, v(r.row.startTime), 1), e[2] || (e[2] = N(" ~ ")), b("span", null, v(r.row.endTime), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[I, d.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  S as default
};
