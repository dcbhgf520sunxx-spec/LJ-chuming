import { openBlock as l } from "vue";
import { createElementBlock as w } from "vue";
import { unref as a } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as h } from "vue";
import { Fragment as x } from "vue";
import { ElTableColumn as s } from "element-plus";
import { b as u, z as c } from "../shared/runtime.js";
const r = { class: "project-name" }, v = { __name: "index", props: { showProject: { type: Boolean, default: false }, showArea: { type: Boolean, default: false }, showMonomer: { type: Boolean, default: false }, showFactory: { type: Boolean, default: false }, showWorkshop: { type: Boolean, default: false }, showProductionLine: { type: Boolean, default: false }, showProcess: { type: Boolean, default: false }, showTeam: { type: Boolean, default: false }, columns: { type: Object }, teamAlign: { type: String, default: "left" }, fixed: { type: String }, fixedWidth: { type: Boolean } }, setup(e) {
  return (y, b) => {
    const o = s;
    return l(), w(x, null, [e.showProject && (a(u)(e.columns) || e.columns.visible("project.shortName")) ? (l(), d(o, { key: 0, prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", width: e.fixedWidth ? "180px" : "", "min-width": e.fixedWidth ? "" : "180px", fixed: e.fixed }, { default: n(({ row: t }) => [m("span", r, f(a(c)(t.project)), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : h("", true), e.showMonomer && (a(u)(e.columns) || e.columns.visible("monomer.name")) ? (l(), d(o, { key: 1, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: n(({ row: t }) => {
      var i;
      return [m("span", null, f((i = t.monomer) == null ? void 0 : i.name), 1)];
    }), _: 1 }, 8, ["width", "min-width", "fixed"])) : h("", true), e.showArea && (a(u)(e.columns) || e.columns.visible("areaDetail.name")) ? (l(), d(o, { key: 2, prop: "areaDetail.name", "show-overflow-tooltip": true, label: "区域", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: n(({ row: t }) => {
      var i;
      return [m("span", null, f((i = t.areaDetail) == null ? void 0 : i.name), 1)];
    }), _: 1 }, 8, ["width", "min-width", "fixed"])) : h("", true), e.showFactory && (a(u)(e.columns) || e.columns.visible("factory.name")) ? (l(), d(o, { key: 3, prop: "factory.name", "show-overflow-tooltip": true, label: "工厂", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: n(({ row: t }) => {
      var i;
      return [m("span", null, f((i = t.factory) == null ? void 0 : i.name), 1)];
    }), _: 1 }, 8, ["width", "min-width", "fixed"])) : h("", true), e.showWorkshop && (a(u)(e.columns) || e.columns.visible("workshop.name")) ? (l(), d(o, { key: 4, prop: "workshop.name", "show-overflow-tooltip": true, label: "车间", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: n(({ row: t }) => {
      var i;
      return [m("span", null, f((i = t.workshop) == null ? void 0 : i.name), 1)];
    }), _: 1 }, 8, ["width", "min-width", "fixed"])) : h("", true), e.showProductionLine && (a(u)(e.columns) || e.columns.visible("productionLine.name")) ? (l(), d(o, { key: 5, prop: "productionLine.name", "show-overflow-tooltip": true, label: "生产线", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: n(({ row: t }) => {
      var i;
      return [m("span", null, f((i = t.productionLine) == null ? void 0 : i.name), 1)];
    }), _: 1 }, 8, ["width", "min-width", "fixed"])) : h("", true), e.showProcess && (a(u)(e.columns) || e.columns.visible("processName")) ? (l(), d(o, { key: 6, prop: "processName", "show-overflow-tooltip": true, label: "工序", width: e.fixedWidth ? "100px" : "", "min-width": e.fixedWidth ? "" : "100px", fixed: e.fixed }, { default: n(({ row: t }) => [m("span", null, f(t.processName), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : h("", true), e.showTeam && (a(u)(e.columns) || e.columns.visible("leaderName")) ? (l(), d(o, { key: 7, prop: "leaderName", "show-overflow-tooltip": true, label: "班组", align: e.teamAlign, width: e.fixedWidth ? "100px" : "", "min-width": e.fixedWidth ? "" : "100px", fixed: e.fixed }, { default: n(({ row: t }) => [m("span", null, f(t.leaderName), 1)]), _: 1 }, 8, ["align", "width", "min-width", "fixed"])) : h("", true)], 64);
  };
} };
export {
  v as _
};
