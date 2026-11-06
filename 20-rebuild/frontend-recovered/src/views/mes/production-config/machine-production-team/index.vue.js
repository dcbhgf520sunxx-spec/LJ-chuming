import { ref as g } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as y } from "vue";
import { unref as o } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as l } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as O } from "../../../../modules/production-machine-team -25d37afa.js";
import { x as B, oR as q, o as U, oS as W, oT as $, oU as N, an as K, P as j, oV as z, a3 as G, er as J, dM as Q } from "../../../../shared/runtime.js";
import X from "./module/header.vue.js";
import Y from "./module/form.vue.js";
const Z = { class: "app-container" }, ee = { class: "head-container" }, se = { __name: "index", setup(te) {
  const S = [], F = { add: true, edit: false, del: false, download: false }, w = g(), b = g([]), k = g([]), _ = g([]), { crud: f, columns: i, CRUD: x } = B({ title: "零件切割配置", sort: [], optShow: { ...F }, permission: { ...q }, crudApi: { ...O } }, w), { maxHeight: R } = U({ paginate: true });
  x.HOOK.handleRefresh = (c, d) => {
    d.data.content = d.data.content.map((e) => {
      var m, h, t, a, L, M, T, v;
      return e.productionLineId = (m = e.productionLine) == null ? void 0 : m.id, e.ncSystemId = (h = e.ncSystem) != null && h.id ? String((t = e.ncSystem) == null ? void 0 : t.id) : void 0, e.ncFileFormatId = (a = e.ncFileFormat) != null && a.id ? String((L = e.ncFileFormat) == null ? void 0 : L.id) : void 0, e.deviceTypeId = (M = e.deviceType) == null ? void 0 : M.id, e.groupsName = (v = (T = e.userLinks.filter((C) => C.boolLeaderEnum)) == null ? void 0 : T[0]) == null ? void 0 : v.userName, e.partFeature = e.partFeatureList, e;
    });
  };
  async function P() {
    try {
      const { content: c } = await z({ productType: G.MACHINE_PART.V, type: f.query.mesProductEnum });
      c.forEach((d) => {
        d.children = d.productionLineList;
      }), b.value = c;
    } catch (c) {
      console.log(c, "获取车间列表");
    }
  }
  async function E() {
    var d;
    _.value = [];
    const c = [];
    try {
      const e = await J({ workShopType: f.query.mesProductEnum });
      k.value = e.content || [], (d = e.content) == null || d.map((m) => {
        m.workshopList.map((h) => {
          h.children = h.productionLineList.filter((t) => t.productType === Q.MACHINE_PART.V) || [], c.push(h);
        }), m.children = m.workshopList || [];
      }), _.value = c;
    } catch (e) {
      console.log("获取工厂车间生产线树失败", e);
    }
  }
  return P(), E(), (c, d) => {
    const e = A, m = D("common-table"), h = H;
    return r(), I("div", Z, [p("div", ee, [y(o(X), { workShopList: b.value, workshopLines: k.value }, null, 8, ["workShopList", "workshopLines"])]), V((r(), n(m, { ref_key: "tableRef", ref: w, data: o(f).data, "data-format": S, "empty-text": o(f).emptyText, "max-height": o(R), style: { width: "100%" }, "row-key": "id" }, { default: s(() => [y(e, { label: "序号", type: "index", align: "center", width: "60" }), o(i).visible("workshopName") ? (r(), n(e, { key: "workshopName", prop: "workshopName", "show-overflow-tooltip": true, label: "车间", "min-width": "100px", align: "center" }, { default: s(({ row: t }) => {
      var a;
      return [p("span", null, u((a = t.workshop) == null ? void 0 : a.name), 1)];
    }), _: 1 })) : l("", true), o(i).visible("processName") ? (r(), n(e, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "产线", "min-width": "100px", align: "center" }, { default: s(({ row: t }) => {
      var a;
      return [p("span", null, u((a = t.productionLine) == null ? void 0 : a.name), 1)];
    }), _: 1 })) : l("", true), o(i).visible("partType") ? (r(), n(e, { key: "partType", prop: "partType", "show-overflow-tooltip": true, label: "零件类型", align: "center" }, { default: s(({ row: t }) => [p("span", null, u(o(W).VL[t.partType] || "-"), 1)]), _: 1 })) : l("", true), o(i).visible("partProdMode") ? (r(), n(e, { key: "partProdMode", prop: "partProdMode", label: "生产方式", align: "center" }, { default: s(({ row: t }) => [p("span", null, u(o($).VL[t.partProdMode] || "-"), 1)]), _: 1 })) : l("", true), o(i).visible("groupsName") ? (r(), n(e, { key: "groupsName", prop: "groupsName", label: "班组", align: "center" })) : l("", true), o(i).visible("MID") ? (r(), n(e, { key: "MID", prop: "MID", label: "MID", align: "center" })) : l("", true), o(i).visible("deviceName") ? (r(), n(e, { key: "deviceName", prop: "deviceName", label: "设备名称", align: "center" })) : l("", true), o(i).visible("deviceType") ? (r(), n(e, { key: "deviceType", prop: "deviceType", label: "切割方式", align: "center" }, { default: s(({ row: t }) => {
      var a;
      return [p("span", null, u((a = t.deviceType) == null ? void 0 : a.name), 1)];
    }), _: 1 })) : l("", true), o(i).visible("ncSystem") ? (r(), n(e, { key: "ncSystem", prop: "ncSystem", label: "数控系统", align: "center" }, { default: s(({ row: t }) => {
      var a;
      return [p("span", null, u(((a = t.ncSystem) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 })) : l("", true), o(i).visible("ncFileFormat") ? (r(), n(e, { key: "ncFileFormat", prop: "ncFileFormat", label: "数控文件格式", align: "center" }, { default: s(({ row: t }) => {
      var a;
      return [p("span", null, u(((a = t.ncFileFormat) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 })) : l("", true), o(i).visible("drillReportMethod") ? (r(), n(e, { key: "drillReportMethod", prop: "drillReportMethod", label: "切割报工", align: "center" }, { default: s(({ row: t }) => [p("span", null, u(o(N).VL[t.cuttingReportMethod] || "-"), 1)]), _: 1 })) : l("", true), o(i).visible("drillReportMethod") ? (r(), n(e, { key: "drillReportMethod", prop: "drillReportMethod", label: "钻孔报工", align: "center" }, { default: s(({ row: t }) => [p("span", null, u(o(N).VL[t.drillReportMethod] || "-"), 1)]), _: 1 })) : l("", true), y(e, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: s((t) => [y(o(K), { data: t.row }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[h, o(f).loading]]), y(o(j)), y(o(Y), { schedulingProductionLine: _.value }, null, 8, ["schedulingProductionLine"])]);
  };
} };
export {
  se as default
};
