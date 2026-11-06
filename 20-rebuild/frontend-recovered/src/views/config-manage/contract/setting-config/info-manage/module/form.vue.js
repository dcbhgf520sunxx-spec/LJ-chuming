import { ref as f } from "vue";
import { watch as g } from "vue";
import { computed as I } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as F } from "vue";
import { createBlock as J } from "vue";
import { withCtx as s } from "vue";
import { createVNode as o } from "vue";
import { unref as r } from "vue";
import { createTextVNode as $ } from "vue";
import { createElementVNode as K } from "vue";
import { ElInput as M } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElCheckbox as q } from "element-plus";
import { ElTree as A } from "element-plus";
import { ElForm as H } from "element-plus";
import { l as i, _ as G, ds as Q, cB as W, ao as X, i as Y } from "../../../../../../shared/runtime.js";
function Z(a) {
  return i({ module: "contract", url: "deploy/project/template", method: "get", params: a });
}
function ee(a) {
  return i({ module: "contract", url: "deploy/project/templateSave", method: "post", data: a });
}
function te(a) {
  return i({ module: "contract", url: "deploy/project/template/Update", method: "put", data: a });
}
function le(a) {
  return i({ module: "contract", url: `deploy/project/remove/${a}`, method: "delete" });
}
function de(a) {
  return i({ module: "contract", url: "deploy/project/status", method: "put", params: a });
}
function ae(a) {
  return i({ module: "contract", url: "deploy/project/template/details", method: "get", params: a });
}
function ie({ id: a, isDefault: m }) {
  return i({ module: "contract", url: `deploy/project/${a}/default/${m}`, method: "put" });
}
const me = { get: Z, add: ee, edit: te, del: le };
const re = { __name: "form", setup(a) {
  const { userDeptTree: m } = Q(), v = f(), w = { id: void 0, templateName: void 0, remark: void 0, isDefault: false, userIdList: [], status: W.ENUM.TRUE.V }, { CRUD: N, crud: c, form: u } = X(w, v), V = { templateName: [{ required: true, message: "请输入模板名称", trigger: "blur" }, { min: 2, max: 10, message: "长度在 2 到 10 个字符", trigger: "blur" }], remark: [{ required: true, message: "请输入描述信息", trigger: "change" }] }, _ = f(), y = f(), D = { children: "children", label: "label" }, j = f([]), k = f([]), p = f([]);
  g(() => y.value, (t) => {
    _.value.filter(t);
  }), g(() => c.form.id, (t) => {
    t ? S(t) : (p.value = [], _.value && x());
  }, { deep: true, immediate: true }), g(m, (t) => {
    Y(m.value) && O();
  }, { immediate: true, deep: true });
  const C = I(() => k.value);
  function E(t, e) {
    return t ? e.label.indexOf(t) !== -1 || e.parentLabel && e.parentLabel.indexOf(t) !== -1 : true;
  }
  function O() {
    let t = [], e = [];
    t = JSON.parse(JSON.stringify(m.value)), h(t, true), e = JSON.parse(JSON.stringify(m.value)), h(e, false), j.value = t, k.value = e;
  }
  function h(t, e, n) {
    t.forEach((l) => {
      l.disabled = e, l.parentLabel = n, l.isUser || (l.id === 1 ? l.label = "<公司>" + l.label : l.label = "<部门>" + l.label, l.id = -l.id), l.children && h(l.children, e, l.label);
    });
  }
  async function S(t) {
    let e = [];
    try {
      const { content: n } = await ae({ id: t });
      e = n.map((l) => l.id);
    } catch (n) {
      console.log(n);
    } finally {
      p.value = e, x();
    }
  }
  function T() {
    let t = _.value.getCheckedKeys(true);
    t = t.filter((e) => e > 0), p.value = t;
  }
  function x() {
    _.value.setCheckedKeys(p.value);
  }
  return N.HOOK.beforeSubmit = (t, e) => {
    T(), t.form.userIdList = p.value || [];
  }, (t, e) => {
    const n = U("common-button"), l = M, b = P, R = q, B = A, L = H, z = U("common-drawer");
    return F(), J(z, { "append-to-body": "", "close-on-click-modal": false, "before-close": r(c).cancelCU, visible: r(c).status.cu > 0, title: r(c).status.title, "wrapper-closable": false, size: "860px" }, { titleRight: s(() => [o(n, { loading: r(c).status.cu === 2, type: "primary", size: "default", onClick: r(c).submitCU }, { default: s(() => e[4] || (e[4] = [$("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), content: s(() => [o(L, { ref_key: "formRef", ref: v, model: r(u), rules: V, size: "default", "label-width": "140px" }, { default: s(() => [o(b, { label: "模板名称", prop: "templateName" }, { default: s(() => [o(l, { modelValue: r(u).templateName, "onUpdate:modelValue": e[0] || (e[0] = (d) => r(u).templateName = d), type: "text", placeholder: "模板名称", style: { width: "250px" }, maxlength: "10" }, null, 8, ["modelValue"])]), _: 1 }), o(b, { label: "描述信息", prop: "remark" }, { default: s(() => [o(l, { modelValue: r(u).remark, "onUpdate:modelValue": e[1] || (e[1] = (d) => r(u).remark = d), type: "textarea", autosize: { minRows: 6, maxRows: 8 }, maxlength: 200, "show-word-limit": "", placeholder: "描述信息", style: { "max-width": "500px" } }, null, 8, ["modelValue"])]), _: 1 }), o(b, { label: "默认模板", prop: "isDefault" }, { default: s(() => [o(R, { modelValue: r(u).isDefault, "onUpdate:modelValue": e[2] || (e[2] = (d) => r(u).isDefault = d) }, null, 8, ["modelValue"])]), _: 1 }), o(b, { label: "用户信息", prop: "isDefault" }, { default: s(() => [K("div", null, [o(l, { modelValue: y.value, "onUpdate:modelValue": e[3] || (e[3] = (d) => y.value = d), class: "filter-item", placeholder: "输入关键字进行过滤", style: { width: "270px" } }, null, 8, ["modelValue"]), o(B, { ref_key: "treeRef", ref: _, class: "filter-tree", data: C.value, "empty-text": "没有用户", props: D, "default-expand-all": "", "show-checkbox": "", "node-key": "id", "filter-node-method": E, "default-checked-keys": p.value }, null, 8, ["data", "default-checked-keys"])])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, oe = G(re, [["__scopeId", "data-v-9e2746d3"]]), ce = Object.freeze(Object.defineProperty({ __proto__: null, default: oe }, Symbol.toStringTag, { value: "Module" }));
export {
  de as a,
  me as c,
  ie as e,
  ce as f,
  oe as m
};
