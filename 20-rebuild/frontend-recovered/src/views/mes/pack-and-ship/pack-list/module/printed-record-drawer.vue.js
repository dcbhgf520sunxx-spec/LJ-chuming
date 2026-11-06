import { ref as d } from "vue";
import { watch as H } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as f } from "vue";
import { createBlock as w } from "vue";
import { withCtx as c } from "vue";
import { withDirectives as R } from "vue";
import { unref as a } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as T } from "vue";
import { toDisplayString as _ } from "vue";
import { isRef as I } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as q } from "../../../../../modules/print-record-2e0b6340.js";
import { u as D, o as M, p as b } from "../../../../../shared/runtime.js";
const E = { __name: "printed-record-drawer", props: { visible: { type: Boolean, default: false }, packageId: { type: [Number, String], default: void 0 } }, emits: ["update:visible"], setup(h, { emit: v }) {
  const m = d(), g = v, n = h, { visible: o, handleClose: x } = D({ emit: g, props: n, field: "visible" }), { maxHeight: y } = M({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => m.value.loaded), p = d([]), s = d(false);
  H(() => o.value, (t) => {
    t && k();
  }, { immediate: true });
  async function k() {
    if (!n.packageId) return;
    s.value = true;
    let t = [];
    try {
      const { content: e = [] } = await q(n.packageId);
      t = e;
    } catch (e) {
      console.log("获取打印记录", e);
    } finally {
      p.value = t, s.value = false;
    }
  }
  return (t, e) => {
    const r = N, V = u("common-table"), B = u("common-drawer"), C = L;
    return f(), w(B, { ref_key: "drawerRef", ref: m, title: "打印详情", modelValue: a(o), "onUpdate:modelValue": e[0] || (e[0] = (l) => I(o) ? o.value = l : null), direction: "rtl", "before-close": a(x), size: "50%" }, { content: c(() => [R((f(), w(V, { ref: "table", data: p.value, "max-height": a(y), style: { width: "100%" } }, { default: c(() => [i(r, { label: "序号", type: "index", align: "center", width: "60" }), i(r, { "show-overflow-tooltip": true, prop: "userName", label: "操作人", "min-width": "110px" }), i(r, { "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center", "min-width": "80px" }), i(r, { "show-overflow-tooltip": true, prop: "time", label: "打印时间", "min-width": "300px" }, { default: c((l) => [T(_(a(b)(l.row.startTime)) + " ~ " + _(a(b)(l.row.endTime)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[C, s.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  E as default
};
