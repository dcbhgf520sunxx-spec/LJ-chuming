import { resolveComponent as p } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withKeys as C } from "vue";
import { ElDatePicker as h } from "element-plus";
import { ElInput as I } from "element-plus";
import { B as V, I as g, dE as y, C as j } from "../../../../../shared/runtime.js";
import { u as D } from "../../../../../modules/use-crm-project-information-18afe991.js";
const E = { class: "head-container" }, N = { __name: "header", setup(P) {
  const { projectInformationMap: d } = D(), s = { date: [], startDate: void 0, endDate: void 0, projectLevelConfigId: void 0 }, { crud: r, query: e } = V(s);
  function m() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), r.toQuery();
  }
  return (v, o) => {
    var l;
    const u = h, c = p("common-select"), i = I;
    return f(), _("div", E, [n(u, { modelValue: t(e).date, "onUpdate:modelValue": o[0] || (o[0] = (a) => t(e).date = a), "value-format": "x", class: "filter-item", shortcuts: t(g), type: "daterange", "start-placeholder": "开始日期", "end-placeholder": "结束日期", onChange: m }, null, 8, ["modelValue", "shortcuts"]), n(c, { modelValue: t(e).projectLevelConfigId, "onUpdate:modelValue": o[1] || (o[1] = (a) => t(e).projectLevelConfigId = a), class: "filter-item", onChange: t(r).toQuery, options: (l = t(d)[t(y).PROJECT_LEVEL_CONFIG.V]) == null ? void 0 : l.crmProjectInformationConfigDTOS, placeholder: "选择项目等级", clearable: "" }, null, 8, ["modelValue", "onChange", "options"]), n(i, { modelValue: t(e).projectName, "onUpdate:modelValue": o[2] || (o[2] = (a) => t(e).projectName = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "搜索项目", size: "default", style: { width: "300px" }, onKeyup: C(t(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(t(j))]);
  };
} };
export {
  N as default
};
