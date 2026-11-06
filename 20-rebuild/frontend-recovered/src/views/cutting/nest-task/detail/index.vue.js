import { ref as s } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as ae } from "vue";
import { createVNode as a } from "vue";
import { withCtx as l } from "vue";
import { createBlock as w } from "vue";
import { createCommentVNode as U } from "vue";
import { withModifiers as le } from "vue";
import { createTextVNode as f } from "vue";
import { unref as g } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as M } from "vue";
import { toDisplayString as r } from "vue";
import { isRef as Ve } from "vue";
import { Fragment as Ce } from "vue";
import { ElMessage as oe } from "element-plus";
import { ElTableColumn as Ie } from "element-plus";
import { ElDivider as xe } from "element-plus";
import { ElTag as Te } from "element-plus";
import { vLoading as De } from "element-plus";
import { _ as je, u as We, m0 as $ } from "../../../../shared/runtime.js";
import ne from "./group.vue.js";
import { m as Be, d as Pe, f as ze, e as Se, B as qe, h as Le } from "../../../../modules/radan-controller-25ebed6e.js";
const Ae = { class: "flex-rss" }, Ee = { class: "TaskPackage" }, Re = { key: 0, class: "taskTabHed head-container" }, Ue = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Object, required: true } }, emits: ["update:visible", "success"], setup(ie, { emit: re }) {
  const p = ie, O = re, T = s([]), k = s([]), v = s([]), D = s([]), j = s([]), F = s([]), W = s([]), B = s(false), _ = s(false), H = s(""), P = s(false), z = s(false), b = s(), c = s(), Q = s([]), G = s([]), S = s([]), N = s(), V = s(), C = s(), h = s(1), q = s(false), J = { key: "id", label: "name", value: "id" }, { visible: L, handleClose: K } = We({ emit: O, props: p, field: "visible", closeHook: ce, showHook: pe });
  async function I(n, t, u) {
    P.value = true;
    try {
      const d = await Pe({ projectId: p.detailData.projectId, monomerId: t, areaId: u });
      T.value = d, H.value = d[0].projectName;
    } catch (d) {
      console.log(d);
    }
    P.value = false;
  }
  async function se(n) {
    q.value = true;
    try {
      const { content: t } = await qe(n);
      F.value = t;
    } catch (t) {
      console.log(t);
    }
    q.value = false;
  }
  function ue(n) {
    k.value = n;
  }
  async function A(n) {
    x();
  }
  function de(n) {
    n.length > 0 ? (_.value = false, v.value = n) : (_.value = true, v.value = []);
  }
  function pe() {
    p.detailData && (I(), me());
  }
  function ce() {
    T.value = [], k.value = [], c.value = void 0, h.value = 1, W.value = [], j.value = [], S.value = [];
  }
  async function me() {
    try {
      const { content: n } = await Be({ projectId: p.detailData.projectId, productType: 1 });
      G.value = n;
    } catch (n) {
      console.log(n);
    }
  }
  async function fe(n, t) {
    try {
      const { content: u } = await Le({ projectId: n, monomerId: t, productType: 1 });
      Q.value = u;
    } catch (u) {
      console.log(u);
    }
  }
  async function x(n) {
    h.value = n, z.value = true;
    try {
      D.value = [], D.value = X(k.value.map((u) => u.areaId));
      const { content: t } = await ze(D.value, { projectId: p.detailData.projectId, thick: N.value, material: V.value, relationType: C.value });
      if (h.value === 1) {
        const u = [], d = [];
        t.forEach((o) => {
          u.push(o.thick), d.push(o.material), W.value = Y(d).sort(Z), S.value = Y(u).sort(Z);
        }), h.value++, _.value = true, oe({ message: "投料成功！！！", type: "success" });
      }
      j.value = t;
    } catch (t) {
      console.log(t);
    }
    z.value = false;
  }
  function we(n) {
    B.value = true, se(n.areaId);
  }
  function ge() {
    c.value = void 0, b.value = void 0, I(p.detailData.projectId);
  }
  function ve() {
    I(p.detailData.projectId, c.value), fe(p.detailData.projectId, c.value);
  }
  function he() {
    I(p.detailData.projectId, c.value, b.value);
  }
  function X(n) {
    return Array.from(new Set(n));
  }
  async function ye() {
    try {
      v.value = X(v.value.map((t) => t.id));
      const n = await Se(v.value, { projectId: p.detailData.projectId });
      oe({ message: n, type: "success" }), x(1), O("success");
    } catch (n) {
      console.log(n);
    }
  }
  function ke({ row: n, column: t, rowIndex: u, columnIndex: d }) {
    if (t.property === "projectName" || t.property === "monomerName") return u % 2 === 0 ? { rowspan: 2, colspan: 1 } : { rowspan: 0, colspan: 0 };
  }
  function Y(n) {
    return Array.from(new Set(n));
  }
  function Z(n, t) {
    return n - t;
  }
  function _e() {
    C.value = void 0, N.value = void 0, V.value = void 0, x();
  }
  return (n, t) => {
    const u = y("common-select"), d = y("common-button"), o = Ie, E = y("common-table"), be = xe, Ne = y("common-radio-button"), ee = Te, te = y("common-dialog"), R = De;
    return m(), ae(Ce, null, [a(te, { top: "10vh", title: "所属项目：" + H.value, width: "700px", direction: "rtl", ref: "drawerRef", fullscreen: "", "show-close": false, "close-on-click-modal": false, "custom-class": "section-steel-detail", modelValue: g(L), "onUpdate:modelValue": t[8] || (t[8] = (e) => Ve(L) ? L.value = e : null), "before-close": g(K) }, { titleLeft: l(() => [a(u, { style: { "margin-right": "10px" }, modelValue: c.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => c.value = e), options: G.value, type: "other", clearable: "", dataStructure: J, size: "default", placeholder: "请选择单体", class: "filter-item", onChange: ve }, null, 8, ["modelValue", "options"]), c.value !== void 0 ? (m(), w(u, { key: 0, style: { "margin-right": "10px" }, modelValue: b.value, "onUpdate:modelValue": t[1] || (t[1] = (e) => b.value = e), options: Q.value, clearable: "", type: "other", dataStructure: J, size: "default", placeholder: "请选择单元", class: "filter-item", onChange: he }, null, 8, ["modelValue", "options"])) : U("", true), a(d, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: t[2] || (t[2] = le((e) => ge(), ["stop"])) }, { default: l(() => t[10] || (t[10] = [f(" 重置 ")])), _: 1, __: [10] })]), titleRight: l(() => [a(d, { disabled: k.value.length === 0, type: "primary", size: "default", onClick: t[3] || (t[3] = (e) => x(1)) }, { default: l(() => t[11] || (t[11] = [f("投料操作")])), _: 1, __: [11] }, 8, ["disabled"]), a(d, { size: "default", onClick: g(K) }, { default: l(() => t[12] || (t[12] = [f("关 闭")])), _: 1, __: [12] }, 8, ["onClick"])]), default: l(() => [i("div", Ae, [M((m(), w(E, { "row-key": "id", ref: "tableRef", "max-height": 200, style: { width: "100%" }, data: T.value, onSelectionChange: ue, "span-method": ke }, { default: l(() => [a(o, { type: "selection", align: "center", width: "55" }), a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.monomerName), 1)]), _: 1 }), a(o, { key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "单元", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.areaName), 1)]), _: 1 }), a(o, { key: "sum", prop: "sum", "show-overflow-tooltip": true, label: "零件数量（件）", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.sum), 1)]), _: 1 }), a(o, { key: "reduce", prop: "reduce", "show-overflow-tooltip": true, label: "零件重量（kg）", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.reduce), 1)]), _: 1 }), a(o, { key: "packNum", prop: "packNum", "show-overflow-tooltip": true, label: "已创建数（件）", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.packNum), 1)]), _: 1 }), a(o, { key: "packWeight", prop: "packWeight", "show-overflow-tooltip": true, label: "已创建量（kg）", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.packWeight), 1)]), _: 1 }), a(o, { align: "center", label: "操作", "min-width": "60" }, { default: l((e) => [a(d, { size: "default", type: "primary", icon: "el-icon-view", onClick: (Me) => we(e.row) }, { default: l(() => t[13] || (t[13] = [f("查看")])), _: 2, __: [13] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data"])), [[R, P.value]])]), a(be), i("div", Ee, [h.value !== 1 ? (m(), ae("div", Re, [a(ne, { style: { "margin-right": "8px" }, value: "厚度", modelValue: N.value, "onUpdate:modelValue": t[4] || (t[4] = (e) => N.value = e), options: S.value, "show-option-all": "", size: "default", onChange: A }, null, 8, ["modelValue", "options"]), a(ne, { style: { "margin-right": "8px" }, value: "材质", modelValue: V.value, "onUpdate:modelValue": t[5] || (t[5] = (e) => V.value = e), options: W.value, "show-option-all": "", size: "default", onChange: A }, null, 8, ["modelValue", "options"]), a(Ne, { style: { "margin-right": "8px" }, class: "enumBtn", modelValue: C.value, "onUpdate:modelValue": t[6] || (t[6] = (e) => C.value = e), options: g($).ENUM, "show-option-all": "", type: "enum", size: "default", onChange: A }, null, 8, ["modelValue", "options"]), a(d, { size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: t[7] || (t[7] = le((e) => _e(), ["stop"])) }, { default: l(() => t[14] || (t[14] = [f("重 置")])), _: 1, __: [14] }), a(d, { style: { float: "right" }, disabled: _.value, type: "success", size: "default", onClick: ye }, { default: l(() => t[15] || (t[15] = [f(" 创建套料工单 ")])), _: 1, __: [15] }, 8, ["disabled"])])) : U("", true), M((m(), w(E, { onSelectionChange: de, ref: "tableRef", data: j.value, "max-height": 500, style: { width: "100%" }, "row-key": "id" }, { default: l(() => [a(o, { type: "selection", align: "center", width: "55" }), a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.monomerName), 1)]), _: 1 }), a(o, { key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "单元", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.areaName), 1)]), _: 1 }), a(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.serialNumber), 1), e.row.relationType && e.row.relationType === g($).PART_BOARD.V ? (m(), w(ee, { key: 0, style: { float: "right", "margin-right": "10px" }, type: "success" }, { default: l(() => t[16] || (t[16] = [f(" 零件板 ")])), _: 1, __: [16] })) : e.row.relationType && e.row.relationType === g($).WING_PLATE.V ? (m(), w(ee, { key: 1, style: { float: "right", "margin-right": "10px" }, type: "danger" }, { default: l(() => t[17] || (t[17] = [f(" 翼腹板 ")])), _: 1, __: [17] })) : U("", true)]), _: 1 }), a(o, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.specification), 1)]), _: 1 }), a(o, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.length), 1)]), _: 1 }), a(o, { key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.thick), 1)]), _: 1 }), a(o, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.material), 1)]), _: 1 }), a(o, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.quantity), 1)]), _: 1 }), a(o, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单重（kg）", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.netWeight), 1)]), _: 1 }), a(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.totalNetWeight), 1)]), _: 1 })]), _: 1 }, 8, ["data"])), [[R, z.value]])])]), _: 1 }, 8, ["title", "modelValue", "before-close"]), M((m(), w(te, { width: "60%", title: "零件清单", "append-to-body": "", modelValue: B.value, "onUpdate:modelValue": t[9] || (t[9] = (e) => B.value = e) }, { default: l(() => [a(E, { ref: "tableRef", data: F.value, "max-height": 400, style: { width: "100%" }, "row-key": "id" }, { default: l(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { align: "center", key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "60" }, { default: l((e) => [i("span", null, r(e.row.monomerName), 1)]), _: 1 }), a(o, { align: "center", key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "单元", "min-width": "60" }, { default: l((e) => [i("span", null, r(e.row.areaName), 1)]), _: 1 }), a(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.serialNumber), 1)]), _: 1 }), a(o, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.specification), 1)]), _: 1 }), a(o, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.length), 1)]), _: 1 }), a(o, { align: "center", key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "60" }, { default: l((e) => [i("span", null, r(e.row.material), 1)]), _: 1 }), a(o, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.quantity), 1)]), _: 1 }), a(o, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单重（kg）", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.netWeight), 1)]), _: 1 }), a(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "60", align: "center" }, { default: l((e) => [i("span", null, r(e.row.totalNetWeight), 1)]), _: 1 })]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue"])), [[R, q.value]])], 64);
  };
} }, Qe = je(Ue, [["__scopeId", "data-v-ddcec64a"]]);
export {
  Qe as default
};
