import { ref as r } from "vue";
import { reactive as ee } from "vue";
import { watch as le } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as m } from "vue";
import { createBlock as y } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as c } from "vue";
import { withDirectives as s } from "vue";
import { vShow as p } from "vue";
import { createCommentVNode as v } from "vue";
import { ElRadioGroup as U } from "element-plus";
import { createElementBlock as oe } from "vue";
import { Fragment as te } from "vue";
import { renderList as ae } from "vue";
import { ElFormItem as ne } from "element-plus";
import { ElInput as de } from "element-plus";
import { Search as ue } from "@element-plus/icons-vue";
import { ElIcon as ie } from "element-plus";
import { ElPopover as se } from "element-plus";
import { ElRadioButton as pe } from "element-plus";
import { ElOption as re } from "element-plus";
import { ElSelect as me } from "element-plus";
import { ElInputNumber as fe } from "element-plus";
import { ElForm as ye } from "element-plus";
import { vLoading as ce } from "element-plus";
import { x8 as O, ao as Ve, x7 as i, i as _e, a as be } from "../../../../shared/runtime.js";
import { m as ve } from "../../../../modules/menu-28602dc9.js";
import { p as Ue } from "../../../../modules/permission-type-323df755.js";
import { m as we } from "../../../../modules/tree-select-86c0f12c.js";
import { I as ge } from "../../../../modules/index-e65bb365.js";
const Be = { __name: "form", setup(xe) {
  const S = r(), R = r(), C = r(), z = r(), I = r(), w = r(false), g = r(false), h = r([]), x = r([]), P = r({}), N = ee({ data: false }), D = { id: void 0, name: void 0, sort: 1, path: void 0, component: void 0, componentName: void 0, iframe: false, roles: [], pid: 0, pName: "顶级类目", icon: null, cache: false, hidden: false, type: 0, category: O.PC.V, permission: null, alwaysShow: false }, { CRUD: F, crud: _, form: o } = Ve(D, S), L = { name: [{ required: true, message: "请填写名称", trigger: "blur" }] };
  le(() => o.type, (d) => {
    d === i.SYSTEM.V ? o.iframe = true : o.iframe = false;
  });
  function q(d) {
    o.icon = d, w.value = false;
  }
  function G(d) {
    P.value = d, o.pid = d.id, o.pName = d.label, g.value = false;
  }
  Y();
  async function Y() {
    try {
      const { content: d } = await Ue();
      h.value = d;
    } catch (d) {
      console.log("权限类型", d);
    }
  }
  let T = [];
  function M(d) {
    d.forEach((l) => {
      T.push(l), l.children && l.children.length > 0 && M(l.children);
    });
  }
  j();
  async function j() {
    try {
      N.data = true;
      const d = { id: 0, label: "顶级类目", children: [] };
      d.children = await ve(), x.value = [d];
    } catch (d) {
      console.log("菜单树", d);
    } finally {
      N.data = false;
    }
  }
  return F.HOOK.afterToEdit = (d, l) => {
    if (_e(l.pid)) {
      T = [], M(x.value);
      const E = T.find((b) => b.id === l.pid);
      l.pName = E.label;
    }
  }, (d, l) => {
    const E = k("common-button"), b = k("common-radio-button"), u = ne, f = de, A = be, H = ue, K = ie, B = se, V = pe, Q = re, J = me, W = fe, X = ye, Z = k("common-dialog"), $ = ce;
    return m(), y(Z, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(_).cancelCU, visible: e(_).status.cu > 0, title: e(_).status.title, width: "600px" }, { titleRight: n(() => [t(E, { loading: e(_).status.cu === 2, type: "primary", size: "default", onClick: e(_).submitCU }, { default: n(() => l[19] || (l[19] = [c("确认")])), _: 1, __: [19] }, 8, ["loading", "onClick"])]), default: n(() => [s((m(), y(X, { ref_key: "formRef", ref: S, model: e(o), rules: L, size: "default", "label-width": "80px", inline: true }, { default: n(() => [t(u, { label: "类型", prop: "type" }, { default: n(() => [t(b, { modelValue: e(o).type, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(o).type = a), options: e(i).ENUM, type: "enum", size: "default", style: { "margin-right": "178px", display: "block" } }, null, 8, ["modelValue", "options"])]), _: 1 }), s(t(u, { label: "类别", prop: "category" }, { default: n(() => [t(b, { modelValue: e(o).category, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(o).category = a), options: e(O).ENUM, type: "enum", size: "default", style: { width: "178px", display: "block" } }, null, 8, ["modelValue", "options"])]), _: 1 }, 512), [[p, e(o).type === e(i).MODULE.V]]), s(t(u, { label: "菜单标题", prop: "name" }, { default: n(() => [t(f, { modelValue: e(o).name, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(o).name = a), style: { width: "450px" }, placeholder: "菜单标题" }, null, 8, ["modelValue"])]), _: 1 }, 512), [[p, e(o).type !== e(i).BUTTON.V]]), s(t(u, { label: "按钮名称", prop: "name" }, { default: n(() => [t(f, { modelValue: e(o).name, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(o).name = a), placeholder: "按钮名称", style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 }, 512), [[p, e(o).type === e(i).BUTTON.V]]), s(t(u, { label: "权限标识", prop: "permission" }, { default: n(() => [t(f, { modelValue: e(o).permission, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(o).permission = a), disabled: e(o).iframe, placeholder: "权限标识", style: { width: "450px" } }, null, 8, ["modelValue", "disabled"])]), _: 1 }, 512), [[p, e(o).type !== e(i).MODULE.V]]), s(t(u, { label: "菜单图标", prop: "icon" }, { default: n(() => [t(B, { placement: "bottom-start", width: "450", trigger: "click", visible: w.value, "onUpdate:visible": l[6] || (l[6] = (a) => w.value = a), ref_key: "iconPopover", ref: R }, { reference: n(() => [t(f, { modelValue: e(o).icon, "onUpdate:modelValue": l[5] || (l[5] = (a) => e(o).icon = a), style: { width: "450px" }, placeholder: "点击选择图标", readonly: "" }, { prefix: n(() => [e(o).icon ? (m(), y(A, { key: 0, "icon-class": e(o).icon, class: "el-input__icon", style: { height: "32px", width: "16px" } }, null, 8, ["icon-class"])) : (m(), y(K, { key: 1, class: "el-input__icon" }, { default: n(() => [t(H)]), _: 1 }))]), _: 1 }, 8, ["modelValue"])]), default: n(() => [t(ge, { ref_key: "iconSelectRef", ref: I, onSelected: q, style: { width: "400px" } }, null, 512)]), _: 1 }, 8, ["visible"])]), _: 1 }, 512), [[p, e(o).type !== e(i).BUTTON.V]]), e(o).type === e(i).MENU.V ? (m(), y(u, { key: 0, label: "路由地址", prop: "path" }, { default: n(() => [t(f, { modelValue: e(o).path, "onUpdate:modelValue": l[7] || (l[7] = (a) => e(o).path = a), placeholder: "路由地址", style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 })) : v("", true), e(o).type !== e(i).BUTTON.V ? (m(), y(u, { key: 1, label: "转发地址", prop: "path" }, { default: n(() => [t(f, { modelValue: e(o).redirect, "onUpdate:modelValue": l[8] || (l[8] = (a) => e(o).redirect = a), placeholder: "转发地址", style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 })) : v("", true), s(t(u, { label: "组件路径", prop: "component" }, { default: n(() => [t(f, { modelValue: e(o).component, "onUpdate:modelValue": l[9] || (l[9] = (a) => e(o).component = a), style: { width: "450px" }, placeholder: "组件路径" }, null, 8, ["modelValue"])]), _: 1 }, 512), [[p, !e(o).iframe && e(o).type === e(i).MENU.V]]), s(t(u, { label: "组件名称", prop: "componentName" }, { default: n(() => [t(f, { modelValue: e(o).componentName, "onUpdate:modelValue": l[10] || (l[10] = (a) => e(o).componentName = a), style: { width: "450px" }, placeholder: "匹配组件内Name字段" }, null, 8, ["modelValue"])]), _: 1 }, 512), [[p, !e(o).iframe && e(o).type === e(i).MENU.V]]), s(t(u, { label: "外链菜单", prop: "iframe" }, { default: n(() => [t(e(U), { modelValue: e(o).iframe, "onUpdate:modelValue": l[11] || (l[11] = (a) => e(o).iframe = a), size: "default" }, { default: n(() => [t(V, { value: true }, { default: n(() => l[20] || (l[20] = [c("是")])), _: 1, __: [20] }), t(V, { value: false }, { default: n(() => l[21] || (l[21] = [c("否")])), _: 1, __: [21] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 512), [[p, e(o).type !== e(i).BUTTON.V]]), s(t(u, { label: "菜单缓存", prop: "cache", style: { "min-width": "258px" } }, { default: n(() => [t(e(U), { modelValue: e(o).cache, "onUpdate:modelValue": l[12] || (l[12] = (a) => e(o).cache = a), size: "default" }, { default: n(() => [t(V, { value: true }, { default: n(() => l[22] || (l[22] = [c("是")])), _: 1, __: [22] }), t(V, { value: false }, { default: n(() => l[23] || (l[23] = [c("否")])), _: 1, __: [23] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 512), [[p, e(o).type === e(i).MENU.V]]), s(t(u, { label: "菜单可见", prop: "hidden" }, { default: n(() => [t(e(U), { modelValue: e(o).hidden, "onUpdate:modelValue": l[13] || (l[13] = (a) => e(o).hidden = a), size: "default" }, { default: n(() => [t(V, { value: false }, { default: n(() => l[24] || (l[24] = [c("是")])), _: 1, __: [24] }), t(V, { value: true }, { default: n(() => l[25] || (l[25] = [c("否")])), _: 1, __: [25] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 512), [[p, e(o).type !== e(i).BUTTON.V]]), s(t(u, { label: "单个子菜单可见", prop: "alwaysShow", "label-width": "120px", style: { "min-width": "257px" } }, { default: n(() => [t(e(U), { modelValue: e(o).alwaysShow, "onUpdate:modelValue": l[14] || (l[14] = (a) => e(o).alwaysShow = a), size: "default", style: { width: "100px" } }, { default: n(() => [t(V, { value: true }, { default: n(() => l[26] || (l[26] = [c("是")])), _: 1, __: [26] }), t(V, { value: false }, { default: n(() => l[27] || (l[27] = [c("否")])), _: 1, __: [27] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 512), [[p, e(o).type === e(i).MENU.V]]), e(o).type === e(i).BUTTON.V ? (m(), y(u, { key: 2, label: "权限类型", prop: "type" }, { default: n(() => [t(J, { modelValue: e(o).permissionTypeId, "onUpdate:modelValue": l[15] || (l[15] = (a) => e(o).permissionTypeId = a), placeholder: "请选择权限类型", style: { width: "450px" } }, { default: n(() => [(m(true), oe(te, null, ae(h.value, (a) => (m(), y(Q, { key: a.id, label: a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })) : v("", true), t(u, { label: "菜单排序", prop: "sort" }, { default: n(() => [t(W, { modelValue: e(o).sort, "onUpdate:modelValue": l[16] || (l[16] = (a) => e(o).sort = a), modelModifiers: { number: true }, min: 1, max: 999, "controls-position": "right", style: { width: "450px" } }, null, 8, ["modelValue"])]), _: 1 }), e(o).type !== e(i).SYSTEM.V ? (m(), y(u, { key: 3, label: "上级类目", prop: "pid" }, { default: n(() => [t(B, { placement: "top-start", width: "450", trigger: "click", visible: g.value, "onUpdate:visible": l[18] || (l[18] = (a) => g.value = a), ref_key: "menuPopover", ref: C }, { reference: n(() => [t(f, { modelValue: e(o).pName, "onUpdate:modelValue": l[17] || (l[17] = (a) => e(o).pName = a), style: { width: "450px" }, placeholder: "点击选择上级类目", readonly: "" }, null, 8, ["modelValue"])]), default: n(() => [t(we, { ref_key: "menuSelectRef", ref: z, onSelected: G, style: { width: "400px" }, pid: e(o).pid, treeMenu: x.value, defaultProps: { children: "children", label: "label" } }, null, 8, ["pid", "treeMenu"])]), _: 1 }, 8, ["visible"])]), _: 1 })) : v("", true)]), _: 1 }, 8, ["model"])), [[$, N.data]])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  Be as default
};
