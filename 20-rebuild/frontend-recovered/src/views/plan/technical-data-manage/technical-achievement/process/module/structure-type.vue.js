import { ref as l } from "vue";
import { watch as g } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as b } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as x } from "vue";
import { withCtx as q } from "vue";
import { createVNode as s } from "vue";
import { ElTableColumn as C } from "element-plus";
import { vLoading as w } from "element-plus";
import { d as k } from "../../../../../../modules/process-611d795f.js";
import "../../../../../../shared/runtime.js";
const N = { style: { padding: "10px", "padding-left": "0" } }, j = { __name: "structure-type", props: { query: { type: Object, default: () => {
} }, maxHeight: { type: Number, default: void 0 } }, emits: ["change"], setup(r, { emit: u }) {
  const m = u, t = r, n = l([]), o = l(false), d = l();
  g(() => t.query, (e) => {
    e && p();
  }, { deep: true, immediate: true });
  async function p() {
    let e = [];
    if (!t.query.projectId && !t.query.processType) {
      n.value = e;
      return;
    }
    o.value = true;
    try {
      const { content: a = [] } = await k({ ...t.query });
      e = a;
    } catch (a) {
      console.log("构件类型明细", a);
    } finally {
      n.value = e, o.value = false;
    }
  }
  function f(e) {
    m("change", e);
  }
  return (e, a) => {
    const c = C, h = _("common-table"), y = w;
    return i(), b("div", N, [v((i(), x(h, { ref_key: "tableRef", ref: d, data: n.value, "max-height": r.maxHeight, style: { width: "300px" }, onSelectionChange: f }, { default: q(() => [s(c, { type: "selection", width: "55", align: "center" }), s(c, { key: "structureClassName", prop: "structureClassName", label: "构件类型", align: "center" }), s(c, { key: "quantity", prop: "quantity", label: "数量(件)", align: "center" })]), _: 1 }, 8, ["data", "max-height"])), [[y, o.value]])]);
  };
} };
export {
  j as default
};
