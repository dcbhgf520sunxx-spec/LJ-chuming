import { inject as ve } from "vue";
import { ref as f } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as ge } from "vue";
import { createElementVNode as n } from "vue";
import { unref as c } from "vue";
import { createBlock as v } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as u } from "vue";
import { createCommentVNode as h } from "vue";
import { createVNode as o } from "vue";
import { withModifiers as P } from "vue";
import { toDisplayString as s } from "vue";
import { withDirectives as M } from "vue";
import { Fragment as ke } from "vue";
import { ElMessage as T } from "element-plus";
import { ElPopover as ye } from "element-plus";
import { ElTableColumn as he } from "element-plus";
import { vLoading as be } from "element-plus";
import { l as C, _ as _e, kc as Ce, G as b } from "../../../../shared/runtime.js";
import { b as Ne } from "../../../../modules/radan-controller-25ebed6e.js";
function De(d) {
  return C({ url: `/api/order/deletesOrder/${d}`, method: "delete" });
}
function Be(d) {
  return C({ url: `/api/order/uploadOrder/${d}`, method: "get" });
}
function Pe(d) {
  return C({ url: "/api/order/updateOrder", method: "get", params: d });
}
function Te(d, _) {
  return C({ url: "/api/order/addPartFromOrder", method: "post", params: d, data: _ });
}
function xe(d, _) {
  return C({ url: "/api/order/deletePartFromOrder", method: "post", params: d, data: _ });
}
const Ee = { class: "ud-operation", style: { display: "inline-block" } }, ze = { style: { "text-align": "right", margin: "0" } }, Se = { style: { "text-align": "right", margin: "0" } }, Ie = { style: { "text-align": "right", margin: "0" } }, Ve = { style: { "text-align": "right", margin: "0" } }, We = { __name: "del", props: { data: { type: Object, required: true }, disabledDel: { type: Boolean, default: false }, showDetail: { type: Boolean, default: false }, showDel: { type: Boolean, default: true }, delPrompt: { type: String, default: "选择撤销操作，让数据复原？" }, beforeToDetail: { type: Function }, beforeToEdit: { type: Function } }, emits: ["selectionChange", "success", "getPlate"], setup(d, { emit: _ }) {
  const N = _, p = d, g = ve("permission"), x = f(false), R = f(false), G = f(false), k = f(false), E = f(false), D = f([]), { crud: J } = Ce(), W = f(false), y = f(false), L = f([]), z = f(false), S = f(false);
  function K() {
    k.value = false, J.cancelDelete(p.data);
  }
  function Q() {
    y.value = false;
  }
  function X() {
    y.value = true;
  }
  function Y() {
    k.value = true;
  }
  function Z(a) {
    a.deleteBtn = true;
  }
  function ee(a) {
    a.addBtn = true;
  }
  function te(a) {
    a.deleteBtn = false;
  }
  function le(a) {
    a.addBtn = false;
  }
  async function oe() {
    try {
      k.value = false;
      const a = await De(p.data.cutTaskId);
      T({ type: "success", message: a }), N("success");
    } catch (a) {
      console.log(a);
    }
  }
  async function ne(a) {
    try {
      const e = await Be(p.data.cutTaskId);
      T({ type: "success", message: e }), N("success");
    } catch (e) {
      console.log(e);
    }
    y.value = false;
  }
  async function ae(a) {
    S.value = true, z.value = true;
    try {
      const { content: e } = await Ne({ cutTaskId: p.data.cutTaskId });
      L.value = e;
    } catch (e) {
      console.log(e);
    }
    S.value = false;
  }
  async function I(a, e) {
    x.value = true, E.value = true, W.value = e;
    try {
      D.value = await Pe({ cutTaskId: p.data.cutTaskId }), D.value.forEach((i) => {
        i.deleteBtn = false, i.addBtn = false;
      }), N("getPlate"), console.log("updateData", D.value);
    } catch (i) {
      console.log(i);
    }
    x.value = false;
  }
  async function ie(a) {
    try {
      const e = [];
      e.push(a.id);
      const i = await xe({ cutTaskId: p.data.cutTaskId }, e);
      T({ type: "success", message: i }), I(a, true);
    } catch (e) {
      console.log("addClick", e);
    }
  }
  async function re(a) {
    try {
      const e = [];
      e.push(a.id);
      const i = await Te({ cutTaskId: p.data.cutTaskId }, e);
      T({ type: "success", message: i }), I(a, true);
    } catch (e) {
      console.log("addClick", e);
    }
  }
  function O() {
    N("getPlate");
  }
  function se() {
    setTimeout(() => {
      document.addEventListener("click", $, { passive: false });
    }, 0);
  }
  function de() {
    document.removeEventListener("click", $);
  }
  function $(a) {
    k.value = false;
  }
  function q(a) {
    y.value = false;
  }
  function ue() {
    setTimeout(() => {
      document.addEventListener("click", q, { passive: false });
    }, 0);
  }
  function ce() {
    document.removeEventListener("click", q);
  }
  function F(a) {
    G.value = false;
  }
  function pe() {
    setTimeout(() => {
      document.addEventListener("click", F, { passive: false });
    }, 0);
  }
  function fe() {
    document.removeEventListener("click", F);
  }
  function H(a) {
    R.value = false;
  }
  function me() {
    setTimeout(() => {
      document.addEventListener("click", H, { passive: false });
    }, 0);
  }
  function we() {
    document.removeEventListener("click", H);
  }
  return (a, e) => {
    const i = V("common-button"), B = ye, r = he, U = V("common-table"), A = V("common-dialog"), j = be;
    return m(), ge(ke, null, [n("span", Ee, [c(b)(c(g).views) ? (m(), v(i, { key: 0, size: "default", type: "primary", onClick: ae }, { default: l(() => e[5] || (e[5] = [u("查看")])), _: 1, __: [5] })) : h("", true), d.data.state === "0" || d.data.state === "1" && c(b)(c(g).edit) ? (m(), v(i, { key: 1, onClick: e[0] || (e[0] = (t) => I(d.data, true)), type: "warning", size: "default" }, { default: l(() => e[6] || (e[6] = [u("修改")])), _: 1, __: [6] })) : h("", true), d.data.state !== "2" && p.showDel && c(b)(c(g).revoke) ? (m(), v(B, { key: 2, visible: k.value, "onUpdate:visible": e[1] || (e[1] = (t) => k.value = t), placement: "top", width: "180", trigger: "manual", onShow: se, onHide: de }, { reference: l(() => [o(i, { disabled: p.disabledDel, type: "danger", size: "default", onClick: P(Y, ["stop"]) }, { default: l(() => e[9] || (e[9] = [u(" 撤销 ")])), _: 1, __: [9] }, 8, ["disabled"])]), default: l(() => [n("p", null, s(p.delPrompt), 1), n("div", ze, [o(i, { size: "default", link: "", type: "primary", onClick: K }, { default: l(() => e[7] || (e[7] = [u("取消")])), _: 1, __: [7] }), o(i, { type: "primary", size: "default", onClick: oe }, { default: l(() => e[8] || (e[8] = [u("确定")])), _: 1, __: [8] })])]), _: 1 }, 8, ["visible"])) : h("", true), d.data.state === "0" && p.showDel && c(b)(c(g).Nesting) ? (m(), v(B, { key: 3, visible: y.value, "onUpdate:visible": e[2] || (e[2] = (t) => y.value = t), placement: "top", width: "180", trigger: "manual", onShow: ue, onHide: ce }, { reference: l(() => [o(i, { type: "success", size: "default", onClick: P(X, ["stop"]) }, { default: l(() => e[12] || (e[12] = [u(" 去套料 ")])), _: 1, __: [12] })]), default: l(() => [e[13] || (e[13] = n("p", null, "选择套料操作，确认套料？", -1)), n("div", Se, [o(i, { size: "default", link: "", type: "primary", onClick: Q }, { default: l(() => e[10] || (e[10] = [u("取消")])), _: 1, __: [10] }), o(i, { type: "primary", size: "default", onClick: ne }, { default: l(() => e[11] || (e[11] = [u("确定")])), _: 1, __: [11] })])]), _: 1, __: [13] }, 8, ["visible"])) : h("", true)]), o(A, { onClose: O, width: "70%", title: "零件清单", "append-to-body": "", modelValue: E.value, "onUpdate:modelValue": e[3] || (e[3] = (t) => E.value = t) }, { default: l(() => [M((m(), v(U, { ref: "tableRef", data: D.value, "max-height": 400, style: { width: "100%" }, "row-key": "id" }, { default: l(() => [o(r, { label: "序号", type: "index", align: "center", width: "60" }), o(r, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.monomerName), 1)]), _: 1 }), o(r, { key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "区域", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.areaName), 1)]), _: 1 }), o(r, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.serialNumber), 1)]), _: 1 }), o(r, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.specification), 1)]), _: 1 }), o(r, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.length), 1)]), _: 1 }), o(r, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.material), 1)]), _: 1 }), o(r, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.quantity), 1)]), _: 1 }), o(r, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单重（kg）", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.netWeight), 1)]), _: 1 }), o(r, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.totalNetWeight), 1)]), _: 1 }), W.value ? (m(), v(r, { key: 0, align: "center", "show-overflow-tooltip": true, label: "操作", "min-width": "60" }, { default: l((t) => [t.row.nestingState === 1 && c(b)(c(g).delPart) ? (m(), v(B, { key: 0, visible: t.row.deleteBtn, "onUpdate:visible": (w) => t.row.deleteBtn = w, placement: "top", width: "180", trigger: "click", onShow: pe, onHide: fe }, { reference: l(() => [o(i, { type: "danger", icon: "el-icon-delete", size: "default", onClick: P((w) => Z(t.row), ["stop"]) }, null, 8, ["onClick"])]), default: l(() => [e[16] || (e[16] = n("p", null, "选择删除操作，让数据删除？", -1)), n("div", Ie, [o(i, { size: "default", link: "", type: "primary", onClick: (w) => te(t.row) }, { default: l(() => e[14] || (e[14] = [u("取消")])), _: 2, __: [14] }, 1032, ["onClick"]), o(i, { type: "primary", size: "default", onClick: (w) => ie(t.row) }, { default: l(() => e[15] || (e[15] = [u("确定")])), _: 2, __: [15] }, 1032, ["onClick"])])]), _: 2, __: [16] }, 1032, ["visible", "onUpdate:visible"])) : t.row.nestingState === 2 && c(b)(c(g).addPart) ? (m(), v(B, { key: 1, visible: t.row.addBtn, "onUpdate:visible": (w) => t.row.addBtn = w, placement: "top", width: "180", trigger: "click", onShow: me, onHide: we }, { reference: l(() => [o(i, { type: "primary", size: "default", onClick: P((w) => ee(t.row), ["stop"]) }, { default: l(() => e[19] || (e[19] = [u(" 新增 ")])), _: 2, __: [19] }, 1032, ["onClick"])]), default: l(() => [e[20] || (e[20] = n("p", null, "选择新增操作，让数据添加？", -1)), n("div", Ve, [o(i, { size: "default", link: "", type: "primary", onClick: (w) => le(t.row) }, { default: l(() => e[17] || (e[17] = [u("取消")])), _: 2, __: [17] }, 1032, ["onClick"]), o(i, { type: "primary", size: "default", onClick: (w) => re(t.row) }, { default: l(() => e[18] || (e[18] = [u("确定")])), _: 2, __: [18] }, 1032, ["onClick"])])]), _: 2, __: [20] }, 1032, ["visible", "onUpdate:visible"])) : h("", true)]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data"])), [[j, x.value]])]), _: 1 }, 8, ["modelValue"]), o(A, { onClose: O, width: "70%", title: "零件清单", "append-to-body": "", modelValue: z.value, "onUpdate:modelValue": e[4] || (e[4] = (t) => z.value = t) }, { default: l(() => [M((m(), v(U, { ref: "tableRef", data: L.value, "max-height": 400, style: { width: "100%" }, "row-key": "id" }, { default: l(() => [o(r, { label: "序号", type: "index", align: "center", width: "60" }), o(r, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.monomerName), 1)]), _: 1 }), o(r, { key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "区域", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.areaName), 1)]), _: 1 }), o(r, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.serialNumber), 1)]), _: 1 }), o(r, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.specification), 1)]), _: 1 }), o(r, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.length), 1)]), _: 1 }), o(r, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.material), 1)]), _: 1 }), o(r, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.quantity), 1)]), _: 1 }), o(r, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单重（kg）", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.netWeight), 1)]), _: 1 }), o(r, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "60", align: "center" }, { default: l((t) => [n("span", null, s(t.row.totalNetWeight), 1)]), _: 1 })]), _: 1 }, 8, ["data"])), [[j, S.value]])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, qe = _e(We, [["__scopeId", "data-v-9b40099b"]]);
export {
  qe as default
};
