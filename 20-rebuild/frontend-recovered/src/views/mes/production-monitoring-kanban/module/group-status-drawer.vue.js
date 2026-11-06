import { ref as h } from "vue";
import { watch as A } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as G } from "vue";
import { createBlock as L } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as t } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as N } from "vue";
import { unref as c } from "vue";
import { toDisplayString as i } from "vue";
import { withModifiers as W } from "vue";
import { isRef as z } from "vue";
import { ElTag as S } from "element-plus";
import { ElDivider as $ } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { b as O } from "../../../../modules/kanban-603b7875.js";
import { o as P, u as U, a3 as C } from "../../../../shared/runtime.js";
import q from "./group-status-detail.vue.js";
const J = { style: { display: "flex" } }, K = { style: { width: "40%" } }, X = ["onClick"], Y = { class: "tc-danger" }, Z = { class: "tc-danger" }, ee = ["onClick"], te = { class: "tc-danger" }, ae = { class: "tc-danger" }, le = ["onClick"], ne = { class: "tc-danger" }, ie = { class: "tc-danger" }, oe = { style: { width: "58%" } }, ue = { __name: "group-status-drawer", props: { visible: { type: Boolean, default: false }, groupDetailData: { type: Object, default: () => {
} }, workshopId: { type: Number }, areaId: { type: Number } }, emits: ["update:visible"], setup(I, { emit: D }) {
  const F = D, g = h([]), M = h([]), m = h([]), _ = h([]), y = h([]), u = I, { maxHeight: f } = P({ mainBox: ".group-detail-drawer", extraBox: [".el-drawer__header", ".title"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }), { visible: w, handleClose: T } = U({ emit: F, props: u, field: "visible", showHook: Q });
  function Q() {
    g.value = {};
  }
  A([() => u.workshopId, () => u.areaId], (d) => {
    B();
  }, { immediate: true });
  async function B() {
    var d;
    m.value = [], _.value = [], y.value = [];
    try {
      const n = await O({ workshopId: u.workshopId, areaId: u.areaId });
      M.value = n || [], (d = M.value) == null || d.forEach((r) => {
        r.taskTypeEnum === C.ARTIFACT.V ? m.value.push(r) : r.taskTypeEnum === C.ASSEMBLE.V ? _.value.push(r) : r.taskTypeEnum === C.MACHINE_PART.V && y.value.push(r);
      });
    } catch (n) {
      console.log("获取班组状态失败", n);
    }
  }
  function x(d) {
    g.value = d;
  }
  function k(d) {
    g.value = d;
  }
  return (d, n) => {
    var R, E;
    const r = S, b = $, o = j, v = V("common-table"), H = V("common-drawer");
    return G(), L(H, { ref: "drawerRef", customClass: "group-detail-drawer", title: `车间：${(E = (R = I.groupDetailData) == null ? void 0 : R.workshop) == null ? void 0 : E.name}`, modelValue: c(w), "onUpdate:modelValue": n[0] || (n[0] = (e) => z(w) ? w.value = e : null), direction: "rtl", "before-close": c(T), size: "100%" }, { content: l(() => [t("div", J, [t("div", K, [a(b, { class: "title" }, { default: l(() => [a(r, { type: "success", size: "large" }, { default: l(() => n[1] || (n[1] = [N(" 构件 ")])), _: 1, __: [1] })]), _: 1 }), a(v, { ref: "directRef", "highlight-current-row": "", data: m.value, style: { width: "100%", cursor: "pointer" }, "row-key": "id", "max-height": c(f) / 3 - 40, onRowClick: k }, { default: l(() => [a(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(o, { prop: "groups.name", key: "groups.name", label: "班组", align: "center" }, { default: l(({ row: e }) => {
      var s, p;
      return [t("span", null, i((s = e.groups) == null ? void 0 : s.name) + ">" + i((p = e.team) == null ? void 0 : p.name), 1)];
    }), _: 1 }), a(o, { prop: "lastMonthNetWeight", key: "lastMonthNetWeight", label: "上月产量（吨）", align: "center", width: "120px" }, { default: l(({ row: e }) => [t("span", null, i((e.lastMonthNetWeight / 1e3).toFixed(2)), 1)]), _: 1 }), a(o, { prop: "yearNetWeight", key: "yearNetWeight", label: "年度平均产量（吨）", align: "center", width: "150px" }, { default: l(({ row: e }) => [t("span", null, i((e.yearNetWeight / 1e3).toFixed(2)), 1)]), _: 1 }), a(o, { prop: "unQuantity", key: "unQuantity", label: "未完成任务（件/吨）", align: "center", width: "150px" }, { default: l(({ row: e }) => [t("div", { onClick: W((s) => x(e), ["stop"]) }, [t("span", Y, i(e.unQuantity), 1), n[2] || (n[2] = t("span", null, " / ", -1)), t("span", Z, i((e.unNetWeight / 1e3).toFixed(2)), 1)], 8, X)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), a(b, { class: "title" }, { default: l(() => [a(r, { type: "warning", size: "large" }, { default: l(() => n[3] || (n[3] = [N(" 部件 ")])), _: 1, __: [3] })]), _: 1 }), a(v, { ref: "indirectRef", "highlight-current-row": "", data: _.value, style: { width: "100%", cursor: "pointer" }, "row-key": "id", "max-height": c(f) / 3 - 40, onRowClick: k }, { default: l(() => [a(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(o, { prop: "groups.name", key: "groups.name", label: "班组", align: "center" }, { default: l(({ row: e }) => {
      var s, p;
      return [t("span", null, i((s = e.groups) == null ? void 0 : s.name) + ">" + i((p = e.team) == null ? void 0 : p.name), 1)];
    }), _: 1 }), a(o, { prop: "lastMonthNetWeight", key: "lastMonthNetWeight", label: "上月产量（吨）", align: "center", width: "120px" }, { default: l(({ row: e }) => [t("span", null, i((e.lastMonthNetWeight / 1e3).toFixed(2)), 1)]), _: 1 }), a(o, { prop: "yearNetWeight", key: "yearNetWeight", label: "年度平均产量（吨）", align: "center", width: "150px" }, { default: l(({ row: e }) => [t("span", null, i((e.yearNetWeight / 1e3).toFixed(2)), 1)]), _: 1 }), a(o, { prop: "unQuantity", key: "unQuantity", label: "未完成任务（件/吨）", align: "center", width: "150px" }, { default: l(({ row: e }) => [t("div", { onClick: W((s) => x(e), ["stop"]) }, [t("span", te, i(e.unQuantity), 1), n[4] || (n[4] = t("span", null, " / ", -1)), t("span", ae, i((e.unNetWeight / 1e3).toFixed(2)), 1)], 8, ee)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), a(b, { class: "title" }, { default: l(() => [a(r, { size: "large" }, { default: l(() => n[5] || (n[5] = [N(" 零件 ")])), _: 1, __: [5] })]), _: 1 }), a(v, { ref: "indirectRef", "highlight-current-row": "", data: y.value, style: { width: "100%", cursor: "pointer" }, "row-key": "id", "max-height": c(f) / 3 - 40, onRowClick: k }, { default: l(() => [a(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(o, { prop: "groups.name", key: "groups.name", label: "班组", align: "center" }, { default: l(({ row: e }) => {
      var s, p;
      return [t("span", null, i((s = e.groups) == null ? void 0 : s.name) + ">" + i((p = e.team) == null ? void 0 : p.name), 1)];
    }), _: 1 }), a(o, { prop: "lastMonthNetWeight", key: "lastMonthNetWeight", label: "上月产量（吨）", align: "center", width: "120px" }, { default: l(({ row: e }) => [t("span", null, i((e.lastMonthNetWeight / 1e3).toFixed(2)), 1)]), _: 1 }), a(o, { prop: "yearNetWeight", key: "yearNetWeight", label: "年度平均产量（吨）", align: "center", width: "150px" }, { default: l(({ row: e }) => [t("span", null, i((e.yearNetWeight / 1e3).toFixed(2)), 1)]), _: 1 }), a(o, { prop: "unQuantity", key: "unQuantity", label: "未完成任务（件/吨）", align: "center", width: "150px" }, { default: l(({ row: e }) => [t("div", { onClick: W((s) => x(e), ["stop"]) }, [t("span", ne, i(e.unQuantity), 1), n[6] || (n[6] = t("span", null, " / ", -1)), t("span", ie, i((e.unNetWeight / 1e3).toFixed(2)), 1)], 8, le)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), n[7] || (n[7] = t("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 180px)" } }, null, -1)), t("div", oe, [a(q, { "detail-data": g.value, workshopId: u.workshopId, areaId: u.areaId }, null, 8, ["detail-data", "workshopId", "areaId"])])])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ue as default
};
