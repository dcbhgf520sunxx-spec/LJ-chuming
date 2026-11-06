import { ref as f } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as D } from "vue";
import { createBlock as h } from "vue";
import { withCtx as a } from "vue";
import { createVNode as s } from "vue";
import { withModifiers as j } from "vue";
import { createTextVNode as w } from "vue";
import { unref as r } from "vue";
import { isRef as x } from "vue";
import { ElMessage as k } from "element-plus";
import { ElFormItem as B } from "element-plus";
import { ElForm as C } from "element-plus";
import { a as L } from "../../../../modules/dept-task-1cfc3d1d.js";
import { u as N } from "../../../../shared/runtime.js";
import { u as z } from "../../../../modules/index-9d220fe1.js";
import "../../../../modules/use-users-4d979987.js";
const O = { __name: "user-dialog", props: { visible: { type: Boolean, default: false }, projectDetail: { type: Object, default: () => ({}) }, monomerDetail: { type: Object, default: () => ({}) } }, emits: ["update:visible", "success"], setup(d, { emit: b }) {
  const u = b, o = d, t = f([]), c = f(false), { visible: i, handleClose: p } = N({ emit: u, props: o, field: "visible", showHook: v });
  async function v() {
    var l, e;
    (l = o.monomerDetail.deepenIdsAndName) != null && l.length ? t.value = (e = o.monomerDetail.deepenIdsAndName) == null ? void 0 : e.map((n) => n.deepenedPersonId) : t.value = [];
  }
  async function g() {
    try {
      c.value = true, await L({ userIdList: t.value, monomerId: o.monomerDetail.id, projectId: o.projectDetail.id }), k.success("保存成功"), u("success"), p();
    } catch (l) {
      console.log(l);
    } finally {
      c.value = false;
    }
  }
  return (l, e) => {
    const n = _("common-button"), V = B, y = C, I = _("common-dialog");
    return D(), h(I, { title: `单体：【${d.monomerDetail.name}】`, modelValue: r(i), "onUpdate:modelValue": e[1] || (e[1] = (m) => x(i) ? i.value = m : null), width: "700px", top: "5vh", "before-close": r(p) }, { titleRight: a(() => [s(n, { type: "primary", onClick: j(g, ["stop"]), size: "mini" }, { default: a(() => e[2] || (e[2] = [w("保存")])), _: 1, __: [2] })]), default: a(() => [s(y, null, { default: a(() => [s(V, { label: "深化负责人", prop: "userIdList " }, { default: a(() => [s(r(z), { modelValue: t.value, "onUpdate:modelValue": e[0] || (e[0] = (m) => t.value = m), "collapse-tags": false, filterable: "", clearable: "", multiple: "", size: "default", placeholder: "请选择深化负责人", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  O as default
};
