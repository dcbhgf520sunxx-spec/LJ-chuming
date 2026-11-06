import { ref as m } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as v } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { createTextVNode as B } from "vue";
import { createCommentVNode as D } from "vue";
import { ElInput as M } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElPopover as z } from "element-plus";
import { ElInputNumber as I } from "element-plus";
import { ElForm as O } from "element-plus";
import { d as q } from "../../../../modules/dept-398bb184.js";
import { ao as j, i as h } from "../../../../shared/runtime.js";
import { m as H } from "../../../../modules/tree-select-86c0f12c.js";
const W = { __name: "form", setup(K) {
  const _ = m(), V = m(), k = m(), u = m(false), p = m([]), x = { id: void 0, name: void 0, sort: 1, pid: 1, pName: void 0 }, { CRUD: N, crud: i, form: o } = j(x, _), w = { name: [{ required: true, message: "请填写部门称", trigger: "blur" }], sort: [{ required: true, message: "请填写序号", trigger: "blur", type: "number" }] };
  function C(r) {
    o.pid = r.id, o.pName = r.name, u.value = false;
  }
  function E() {
    R();
  }
  async function R() {
    try {
      p.value = await q({ hasRoot: true });
    } catch (r) {
      console.log("部门tree", r);
    }
  }
  let c = [];
  function b(r) {
    r.forEach((e) => {
      c.push(e), e.children && e.children.length > 0 && b(e.children);
    });
  }
  return N.HOOK.afterToEdit = (r, e) => {
    if (h(e.pid)) {
      c = [], b(p.value);
      const s = c.find((d) => d.id === e.pid);
      e.pName = h(s) ? s.name : "";
    }
  }, (r, e) => {
    const s = g("common-button"), d = M, f = P, U = z, F = I, S = O, T = g("common-dialog");
    return v(), y(T, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(i).cancelCU, visible: t(i).status.cu > 0, title: t(i).status.title, width: "600px", onOpen: E }, { titleRight: l(() => [n(s, { loading: t(i).status.cu === 2, type: "primary", size: "default", onClick: t(i).submitCU }, { default: l(() => e[4] || (e[4] = [B("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: l(() => [n(S, { ref_key: "formRef", ref: _, model: t(o), rules: w, size: "default", "label-width": "80px", inline: true }, { default: l(() => [n(f, { label: "名称", prop: "name" }, { default: l(() => [n(d, { modelValue: t(o).name, "onUpdate:modelValue": e[0] || (e[0] = (a) => t(o).name = a), style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 }), t(o).id != 1 ? (v(), y(f, { key: 0, label: "上级部门", prop: "pid" }, { default: l(() => [n(U, { placement: "bottom-start", width: "450", trigger: "click", visible: u.value, "onUpdate:visible": e[2] || (e[2] = (a) => u.value = a), ref_key: "menuPopover", ref: V }, { reference: l(() => [n(d, { modelValue: t(o).pName, "onUpdate:modelValue": e[1] || (e[1] = (a) => t(o).pName = a), style: { width: "450px" }, placeholder: "点击选择上级类目", readonly: "" }, null, 8, ["modelValue"])]), default: l(() => [n(H, { ref_key: "menuSelectRef", ref: k, onSelected: C, style: { width: "400px" }, pid: t(o).pid, defaultProps: { children: "children", label: "name" }, treeMenu: p.value }, null, 8, ["pid", "treeMenu"])]), _: 1 }, 8, ["visible"])]), _: 1 })) : D("", true), n(f, { label: "排序", prop: "sort" }, { default: l(() => [n(F, { modelValue: t(o).sort, "onUpdate:modelValue": e[3] || (e[3] = (a) => t(o).sort = a), modelModifiers: { number: true }, min: 0, max: 999999, "controls-position": "right", style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  W as default
};
