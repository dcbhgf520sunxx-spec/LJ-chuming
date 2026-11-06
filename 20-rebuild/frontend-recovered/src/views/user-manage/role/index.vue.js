import { ref as s } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as ye } from "vue";
import { createElementVNode as ae } from "vue";
import { createVNode as o } from "vue";
import { unref as l } from "vue";
import { withDirectives as ge } from "vue";
import { createBlock as C } from "vue";
import { withCtx as T } from "vue";
import { createCommentVNode as N } from "vue";
import { createTextVNode as Ce } from "vue";
import { toDisplayString as Te } from "vue";
import { ElMessage as ke } from "element-plus";
import { ElTableColumn as Se } from "element-plus";
import { vLoading as be } from "element-plus";
import { c as we, b as Ie, u as Ne, g as Ee } from "../../../modules/role-8519830b.js";
import { m as Pe } from "../../../modules/menu-28602dc9.js";
import { r as k } from "../../../modules/user-2de6904c.js";
import { _ as Me, xb as U, x as xe, o as Re, G as se, an as Ve, P as De, xc as te, xd as S, i as Oe } from "../../../shared/runtime.js";
import Le from "./module/header.vue.js";
import Ue from "./module/form.vue.js";
import Ae from "./module/menu-assignation.vue.js";
import Je from "../components/dept-user.vue.js";
import "./module/table-tree/index.vue.js";
import "./module/table-tree/TableItem.vue.js";
import "../../../modules/use-dept-b8e95315.js";
const Be = { class: "app-container" }, $e = { class: "head-container" }, ze = { class: "dialog-container" }, He = { __name: "index", setup(Ke) {
  const H = s(), b = s(false), K = s(""), F = s(false), M = s(false), x = s(false), E = s([]), R = s([]), A = s([]), V = s([]), P = s(), J = s(), D = s(), B = s({}), Q = s(), Y = s(), w = s(U.MENU_PICK.V), O = s(), p = s(false), h = s(false), _ = s(false), y = s(false), g = s(false), m = s([]), j = s([]), r = s({}), $ = s(false), { crud: I, columns: z, CRUD: ne } = xe({ title: "角色", sort: [], permission: { ...k }, crudApi: { ...we }, hasPagination: true }, H), { maxHeight: le } = Re({ paginate: true });
  ie();
  async function ie() {
    try {
      const e = await Pe();
      E.value = e, q();
    } catch (e) {
      console.log("菜单树", e);
    }
  }
  function q() {
    var a, t;
    const e = E.value;
    J.value = e[0], R.value = ((a = e[0]) == null ? void 0 : a.children) || [], A.value = ((t = e[0]) == null ? void 0 : t.children) || [];
  }
  function ue(e, a) {
    const t = new Set(a);
    return G(e, null, t);
  }
  function G(e = [], a, t) {
    return e.map((n, d) => (Oe(n.children) ? (n.children = G(n.children, n, t), n.semiChecked = n.children.some((u) => u.semiChecked || u.checked), n.checked = n.children.every((u) => u.checked)) : t.has(n.id) ? (n.checked = true, n.semiChecked = false) : (n.checked = false, n.semiChecked = false), n));
  }
  function oe() {
    D.value = [], V.value = [], b.value = false;
  }
  async function re() {
    F.value = true;
    const e = await W(A.value, "children", "label", K.value);
    R.value = JSON.parse(JSON.stringify(e)), F.value = false;
  }
  function W(e, a, t, n, d = 1) {
    let u;
    return d === 1 ? u = JSON.parse(JSON.stringify(e)) : u = e, u.filter((c) => {
      if (c[t].indexOf(n) !== -1) return true;
      if (c[a] && c[a].length) {
        const v = W(c[a], a, t, n, ++d);
        return v && v.length > 0 ? (c[a] = v, true) : false;
      } else return false;
    });
  }
  function ce(e, a) {
    const t = new Set(e);
    V.value = Array.from(t);
  }
  function me(e) {
    J.value = e, R.value = e.children || [], A.value = e.children || [];
  }
  async function de() {
    K.value = "", await re();
  }
  async function ve() {
    var t;
    M.value = true, await de();
    const e = { id: P.value, menus: V.value }, a = { sysRoleId: P.value, sysModuleTypeEnum: te.CRM.V, isFullPermissions: p.value, isThisDepartment: h.value, isThisDepartmentAndSubordinateDepartments: _.value, isIndividual: y.value, isIndividualAndThisDept: g.value, departmentIdList: m.value };
    O.value === S.CUSTOM_PERMISSION.V && !((t = m.value) != null && t.length) && ke.error("请至少选中一条部门数据！");
    try {
      w.value === U.MENU_PICK.V ? await Ie(e) : await Ne(a), I.notify("保存成功", ne.NOTIFICATION_TYPE.SUCCESS), M.value = false, b.value = false, I.toQuery(), setTimeout(() => {
        Z();
      }, 200);
    } catch (n) {
      M.value = false, console.log("绑定菜单", n);
    }
  }
  function fe(e) {
    w.value = U.MENU_PICK.V, r.value = {}, e && (P.value = e.id, B.value = e, D.value = e.menus ? JSON.parse(JSON.stringify(e.menus)) : [], V.value = e.menus ? JSON.parse(JSON.stringify(e.menus)) : [], q(), E.value = ue(E.value, D.value), setTimeout(() => {
      Z();
    }, 200), b.value = true);
  }
  function X(e, a) {
    Q.value = e.id, Y.value = a, x.value = true;
  }
  function pe(e) {
    w.value = e;
  }
  function he(e) {
    switch (O.value = e, e) {
      case S.ALL_PERMISSION.V:
        p.value = true, h.value = false, _.value = false, y.value = false, g.value = false, m.value = [];
        break;
      case S.CURRENT_DEPT_PERMISSION.V:
        p.value = false, h.value = true, _.value = false, y.value = false, g.value = false, m.value = [];
        break;
      case S.CURRENT_DEPT_AND_UNDER_DEPT_PERMISSION.V:
        p.value = false, h.value = false, _.value = true, y.value = false, g.value = false, m.value = [];
        break;
      case S.ONLY_CURRENT_USER.V:
        p.value = false, h.value = false, _.value = false, y.value = true, g.value = false, m.value = [];
        break;
      case S.DEPT_AND_PERSOANL.V:
        p.value = false, h.value = false, _.value = false, y.value = false, g.value = true, m.value = [];
        break;
    }
  }
  function _e(e) {
    j.value = e, O.value === S.CUSTOM_PERMISSION.V && (m.value = j.value || [], p.value = false, h.value = false, _.value = false, y.value = false, g.value = false);
  }
  async function Z() {
    var e, a, t, n, d, u, c, v;
    r.value = {};
    try {
      const i = await Ee({ roleId: P.value, sysModuleTypeEnum: te.CRM.V });
      r.value = i || {}, (e = r.value) != null && e.isFullPermissions || (a = r.value) != null && a.isThisDepartment || (t = r.value) != null && t.isThisDepartmentAndSubordinateDepartments || (n = r.value) != null && n.isIndividual || (d = r.value) != null && d.isIndividualAndThisDept || (u = r.value) != null && u.departmentIds && ((v = (c = r.value) == null ? void 0 : c.departmentIds) == null ? void 0 : v.length) > 0 ? $.value = true : $.value = false;
    } catch (i) {
      console.log(i, "获取当前角色的数据权限失败");
    }
  }
  return (e, a) => {
    const t = Se, n = L("common-button"), d = L("common-table"), u = L("common-radio-button"), c = L("common-drawer"), v = be;
    return f(), ye("div", Be, [ae("div", $e, [o(l(Le), { ref: "header", permission: l(k) }, null, 8, ["permission"])]), ge((f(), C(d, { ref_key: "tableRef", ref: H, data: l(I).data, "empty-text": l(I).emptyText, "max-height": l(le), style: { width: "100%" }, "row-key": "id", onSelectionChange: l(I).selectionChangeHandler }, { default: T(() => [o(t, { type: "selection", width: "55", align: "center" }), o(t, { label: "序号", type: "index", align: "center", width: "60" }), l(z).visible("name") ? (f(), C(t, { key: "name", prop: "name", label: "名称" })) : N("", true), l(z).visible("sort") ? (f(), C(t, { key: "sort", prop: "sort", label: "排序", align: "center", width: "100" }, { default: T((i) => [Ce(Te(i.row.sort), 1)]), _: 1 })) : N("", true), l(z).visible("remark") ? (f(), C(t, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "描述" })) : N("", true), o(t, { label: "人员设置", align: "center" }, { default: T((i) => [l(se)(l(k).edit) ? (f(), C(n, { key: 0, size: "default", icon: "el-icon-edit", type: "primary", disabled: i.row.id === 1 && i.row.permission === "admin", onClick: (ee) => X(i.row, "edit") }, null, 8, ["disabled", "onClick"])) : N("", true), o(n, { size: "default", icon: "el-icon-view", type: "primary", onClick: (ee) => X(i.row, "detail") }, null, 8, ["onClick"])]), _: 1 }), l(se)([...l(k).edit, ...l(k).del]) ? (f(), C(t, { key: 3, label: "操作", width: "180px", align: "center", fixed: "right" }, { default: T((i) => [o(n, { size: "default", type: "info", icon: "el-icon-key", onClick: (ee) => fe(i.row) }, null, 8, ["onClick"]), o(l(Ve), { data: i.row, permission: l(k) }, null, 8, ["data", "permission"])]), _: 1 })) : N("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[v, l(I).loading]]), o(l(De)), o(l(Ue)), o(l(Je), { roleId: Q.value, showType: Y.value, modelValue: x.value, "onUpdate:modelValue": a[0] || (a[0] = (i) => x.value = i), onSuccess: a[1] || (a[1] = (i) => x.value = false) }, null, 8, ["roleId", "showType", "modelValue"]), o(c, { modelValue: b.value, "onUpdate:modelValue": a[3] || (a[3] = (i) => b.value = i), "with-header": false, direction: "rtl", size: "100%", "show-close": false }, { title: T(() => a[4] || (a[4] = [])), content: T(() => [ae("div", ze, [b.value ? (f(), C(l(Ae), { key: 0, ref: "menu", "current-id": P.value, systemList: E.value, currentSystem: J.value, menus: R.value, currentRow: B.value, "menu-ids": D.value, "role-name": B.value.name, permission: l(k), menuLoading: M.value, saveMenu: ve, menuType: w.value, isExist: $.value, showPermissionType: O.value, dataPermissionList: r.value, closeMenuAssignation: oe, onChange: ce, onSystemChange: me, onRaidoChange: he, onCheckListChange: _e, style: { height: "calc(100% - 90px)" } }, { menuBtn: T(() => [o(u, { modelValue: w.value, "onUpdate:modelValue": a[2] || (a[2] = (i) => w.value = i), options: l(U).ENUM, size: "default", type: "enum", onChange: pe }, null, 8, ["modelValue", "options"])]), _: 1 }, 8, ["current-id", "systemList", "currentSystem", "menus", "currentRow", "menu-ids", "role-name", "permission", "menuLoading", "menuType", "isExist", "showPermissionType", "dataPermissionList"])) : N("", true)])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, la = Me(He, [["__scopeId", "data-v-e77edd51"]]);
export {
  la as default
};
