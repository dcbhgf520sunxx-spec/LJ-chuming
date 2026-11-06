import { useStore as A } from "vuex";
import { computed as y } from "vue";
import { watch as V } from "vue";
import { ref as m } from "vue";
import { l as i, g8 as z, lz as Z, lT as Q, dC as X, gv as v, bv as G, lq as ee, lU as re, dE as g, dw as E, dt as I, dA as u, lC as ne } from "../shared/runtime.js";
import { g as te, a as oe, e as ae } from "./project-information-053c195b.js";
function Te(r) {
  return i({ module: "crm", url: "enterprise/warehousing/summary", method: "get", params: r });
}
function he(r) {
  return i({ module: "crm", url: "enterprise/warehousing/list", method: "get", params: r });
}
function se(r) {
  return i({ module: "crm", url: "enterprise/warehousing/detail", method: "get", params: r });
}
function ie(r, l) {
  return i({ module: "crm", url: "enterprise/warehousing/save", method: "post", data: r, params: l });
}
function be(r) {
  return i({ module: "crm", url: "enterprise/warehousing/delete", method: "post", params: r });
}
function Ne(r) {
  return i({ module: "crm", url: "enterprise/warehousing/detail/down/load", method: "get", responseType: "blob", params: r });
}
function Ee(r) {
  return i({ module: "crm", url: "government/warehousing/summary", method: "get", params: r });
}
function Ce(r) {
  return i({ module: "crm", url: "government/warehousing/list", method: "get", params: r });
}
function ue(r) {
  return i({ module: "crm", url: "government/warehousing/detail", method: "get", params: r });
}
function le(r) {
  return i({ module: "crm", url: "government/warehousing/update", method: "post", data: r });
}
function _e(r) {
  return i({ module: "crm", url: "government/warehousing/delete", method: "post", params: r });
}
function Ie(r) {
  return i({ module: "crm", url: "government/warehousing/detail/down/load", method: "get", responseType: "blob", params: r });
}
function ye(r) {
  return i({ module: "crm", url: "supplier/warehousing/summary", method: "get", params: r });
}
function Re(r) {
  return i({ module: "crm", url: "supplier/warehousing/list", method: "get", params: r });
}
function me(r) {
  return i({ module: "crm", url: "supplier/warehousing/detail", method: "get", params: r });
}
function ce(r) {
  return i({ module: "crm", url: "supplier/warehousing/update", method: "post", data: r });
}
function De(r) {
  return i({ module: "crm", url: "supplier/warehousing/delete", method: "post", params: r });
}
function we(r) {
  return i({ module: "crm", url: "supplier/warehousing/detail/down/load", method: "get", responseType: "blob", params: r });
}
function ke(r) {
  return i({ module: "crm", url: "bidding/platform/warehousing/summary", method: "get", params: r });
}
function Se(r) {
  return i({ module: "crm", url: "bidding/platform/warehousing/list", method: "get", params: r });
}
function de(r) {
  return i({ module: "crm", url: "bidding/platform/warehousing/detail", method: "get", params: r });
}
function fe(r) {
  return i({ module: "crm", url: "bidding/platform/warehousing/update", method: "post", data: r });
}
function Pe(r) {
  return i({ module: "crm", url: "bidding/platform/warehousing/delete", method: "post", params: r });
}
function Fe(r) {
  return i({ module: "crm", url: "bidding/platform/warehousing/detail/down/load", method: "get", responseType: "blob", params: r });
}
const Ge = (r) => {
  const l = A(), c = y(() => l.state.crm.sectionLoaded);
  if (c.value || l.dispatch("crm/fetchSectionTree"), r) {
    const p = V(c, (T) => {
      T && setTimeout(() => {
        r(), p();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: c, sectionTree: y(() => l.state.crm.sectionList) };
}, Ae = (r) => {
  const l = A(), c = y(() => l.state.crm.tenderApplicationLoaded);
  if (c.value || l.dispatch("crm/fetchTenderApplication"), r) {
    const p = V(c, (T) => {
      T && setTimeout(() => {
        r(), p();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: c, tenderConfigMap: y(() => l.state.crm.tenderApplicationMap) };
};
function Ve() {
  const r = z(["info_source"]), l = m([]), c = m(["填报人", "企业类别", "企业性质", "所属行业", "企业信誉", "文件格式", "相关单位", "项目经理配合", "项目级别", "招标单位", "招标方式", "承建类别", "重点项目", "项目类别", "建筑形式", "结构类型", "是否高管配合", "履约保证金类型", "标书提交方式", "评标方式", "结算方式", "跟进方式", "所属项目", "企业名称", "建设单位", "代建单位", "EPC单位", "设计单位", "总包单位", "项目信息来源"]), p = m(["填报日期", "受理截止日", "跟进日期", "计划开工日期", "计划完工日期", "计划竣工日期", "本次跟进日期", "上次跟进日期", "投标保证金截止日", "投标截止日", "开标时间"]), T = m(["附件", "备案规定", "跟进证明", "资格预审通知文件"]), M = m(["其他信息备注", "备注"]), U = m(["招标规定", "是否项目经理配合"]), L = m(["标书需求"]), R = m([]), D = m({}), j = m(["预估工程量(吨)", "预估造价(万元)", "建筑面积(平方米)", "投标保证金额(万元)", "招标控制价(万元)", "有效期剩(天)", "资格预审费(元)", "履约保证金额(万元)", "费用(万元)"]);
  async function K({ countryType: a, isNeed: n, recordEnum: o, basicsConfigMap: t, user: C, section: $, projectInformation: d, tenderApplicationMap: h, allProjectList: H, esayFirmList: f = [], currentRow: w = {} }) {
    var F;
    try {
      const _ = await Z({ crmPageManagementConfigEnum: o, crmCountryTypeEnum: a });
      console.log(_, "ressssss");
      let k = [];
      (F = D.value) != null && F.recordBindProject ? k = H : k = await Q({ id: w == null ? void 0 : w.id, crmPageManagementConfigEnum: o });
      let O = [];
      O = _.map((e) => (c.value.includes(e.fieldName) ? e.fillOutType = "select" : p.value.includes(e.fieldName) ? e.fillOutType = "datePicker" : T.value.includes(e.fieldName) ? (e.fillOutType = "table", e.verifyMessage = `${e.fieldName}列表为空`, e.verifyTrigger = "") : M.value.includes(e.fieldName) ? e.fillOutType = "textareaInput" : e.fieldName === "国省市区" || e.fieldName === "所属部门" ? e.fillOutType = "regionCascader" : U.value.includes(e.fieldName) ? e.fillOutType = "radio" : L.value.includes(e.fieldName) ? e.fillOutType = "checkBox" : j.value.includes(e.fieldName) ? e.fillOutType = "numInput" : e.fillOutType = "input", ["select", "datePicker", "regionCascader", "radio", "checkBox"].includes(e.fillOutType) ? e.rules = [{ required: e.isWrite, message: `请选择${e.fieldName}`, trigger: "change" }] : ["table"].includes(e.fillOutType) ? e.rules = [{ required: e.isWrite, message: `请添加${e.fieldName}`, trigger: "change" }] : e.rules = [{ required: e.isWrite, message: `请填写${e.fieldName}`, trigger: "blur" }], e.fieldName === "社会统一信用代码" && e.rules.push({ validator: (S, b, N) => {
        b && (/^(([0-9A-Za-z]{15})|([0-9A-Za-z]{18})|([0-9A-Za-z]{20}))$/.test(b) || N(new Error("请输入正确社会统一信用代码"))), N();
      }, trigger: "blur" }), a !== X.FOREIGN.V && (e.fieldName === "联系电话" || e.fieldName === "联系人电话") && e.rules.push({ pattern: v, message: `请填写正确的${e.fieldName}格式`, trigger: "blur" }), e)), console.log(O), O = O.map((e) => {
        var S, b, N;
        switch (e.fieldName) {
          case "企业性质":
            e.myOptions = s("enum", t[I.UNIT_NATURE_CONFIG.V].crmBasicsConfigDTOS);
            break;
          case "建设单位":
            e.myOptions = s("firm", f);
            break;
          case "代建单位":
            e.myOptions = s("firm", f);
            break;
          case "EPC单位":
            e.myOptions = s("firm", f);
            break;
          case "设计单位":
            e.myOptions = s("firm", f);
            break;
          case "总包单位":
            e.myOptions = s("firm", f);
            break;
          case "企业类别":
            e.myOptions = s("enum", t[I.UNIT_TYPE_CONFIG.V].crmBasicsConfigDTOS);
            break;
          case "企业名称":
            e.myOptions = s("firm", f);
            break;
          case "所属行业":
            e.myOptions = s("enum", t[I.BELONG_INDUSTRY_CONFIG.V].crmBasicsConfigDTOS);
            break;
          case "企业信誉":
            e.myOptions = s("enum", t[I.FIRM_REPUTATION.V].crmBasicsConfigDTOS);
            break;
          case "填报人":
            e.myOptions = s("user", (S = C[0]) == null ? void 0 : S.children);
            break;
          case "所属部门":
            e.myOptions = s("section", (b = $[0]) == null ? void 0 : b.children);
            break;
          case "建筑形式":
            e.myOptions = s("enum", d[g.BUILDING_TYPE_CONFIG.V].crmProjectInformationConfigDTOS);
            break;
          case "结构类型":
            e.myOptions = s("enum", d[g.STRUCTURE_TYPE_CONFIG.V].crmProjectInformationConfigDTOS);
            break;
          case "项目类别":
            e.myOptions = s("enum", d[g.PROJECT_TYPE_CONFIG.V].crmProjectInformationConfigDTOS);
            break;
          case "承建类别":
            e.myOptions = s("enum", d[g.CONTRACT_BUILD_CONFIG.V].crmProjectInformationConfigDTOS);
            break;
          case "招标方式":
            e.myOptions = s("enum", (N = h[E.BIDDING_METHOD_CONFIG.V]) == null ? void 0 : N.crmTenderRequestConfigDTOS);
            break;
          case "项目级别":
            e.myOptions = s("enum", d[g.PROJECT_LEVEL_CONFIG.V].crmProjectInformationConfigDTOS);
            break;
          case "招标单位":
            e.myOptions = s("firm", f);
            break;
          case "项目经理配合":
            e.myOptions = s("enum", d[g.PROJECT_MANAGER_CONFIG.V].crmProjectInformationConfigDTOS);
            break;
          case "相关单位":
            e.myOptions = s("firm", f);
            break;
          case "重点项目":
            e.myOptions = s("enum", d[g.KEY_PROJECT_CONFIG.V].crmProjectInformationConfigDTOS);
            break;
          case "是否高管配合":
            e.myOptions = [{ id: true, name: "是" }, { id: false, name: "否" }];
            break;
          case "履约保证金类型":
            e.myOptions = s("enum", h[E.TYPE_OF_PERFORMANCE_BOND.V].crmTenderRequestConfigDTOS);
            break;
          case "标书提交方式":
            e.myOptions = s("enum", h[E.TENDER_SUBMISSION_METHOD.V].crmTenderRequestConfigDTOS);
            break;
          case "评标方式":
            e.myOptions = s("enum", h[E.EVALUATION_METHOD_CONFIG.V].crmTenderRequestConfigDTOS);
            break;
          case "结算方式":
            e.myOptions = s("enum", h[E.SETTLEMENT_METHOD.V].crmTenderRequestConfigDTOS);
            break;
          case "跟进方式":
            e.myOptions = s("enum", d[g.FOLLOW_UP_METHODS.V].crmProjectInformationConfigDTOS);
            break;
          case "招标规定":
            e.myOptions = s("ENUM", re);
            break;
          case "是否项目经理配合":
            e.myOptions = [{ id: true, name: "是", label: true }, { id: false, name: "否", label: false }];
            break;
          case "标书需求":
            e.myOptions = G.toArr(ee);
            break;
          case "所属项目":
            e.myOptions = s("project", k);
            break;
          case "项目信息来源":
            e.myOptions = s("dict", r.value.info_source);
            break;
          default:
            e.myOptions = [];
        }
        return e;
      }), o === u.PROJECT_TRACK_DOWN.V && n && (O = O.filter((e) => e.fieldName !== "跟进证明")), l.value = O || [];
    } catch (_) {
      console.log(_, "获取列表数据");
    }
  }
  function s(a = "user", n) {
    let o = [];
    return a === "enum" ? o = n : a === "user" ? (R.value = [], o = P(n), o = o.map((t) => ({ id: t.id, name: t.label }))) : a === "section" ? o = n.map((t) => ({ id: t.id, name: t.name, children: t.children })) : a === "firm" ? o = n.map((t) => ({ id: t.id, name: t.businessName })) : a === "ENUM" ? o = G.toArr(n).map((C) => ({ id: C.V, name: C.L })) : a === "project" ? o = n.map((t) => ({ id: t.id, name: t.projectName })) : a === "dict" ? o = n.map((t) => ({ id: t.value, name: t.label })) : a === "radio" ? o = n.map((t) => ({ value: t.id, label: t.name })) : o = [], o;
  }
  function P(a) {
    return a == null || a.forEach((n) => {
      n.isUser ? R.value.push(n) : P(n.children);
    }), R.value;
  }
  async function B({ params: a, tabType: n, countryType: o }) {
    try {
      let t = {};
      switch (n) {
        case u.FIRM_RECORD_CONFIG.K:
          t = await se({ id: a.id, crmCountryTypeEnum: o });
          break;
        case u.PROJECT_SIGN_IN_CONFIG.K:
          t = await te({ id: a.id, crmCountryTypeEnum: o });
          break;
        case u.GOVERNMENT_RECORD_CONFIG.K:
          t = await q(a.id);
          break;
        case u.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K:
          t = await J(a.id);
          break;
        case u.PROJECT_TRACK_DOWN.K:
          t = await ne(a.id);
          break;
        case u.SUPPLIER_INTO_RECORD_CONFIG.K:
          t = await Y(a.id);
          break;
      }
      D.value = t;
    } catch (t) {
      console.log(t);
    }
  }
  async function q(a) {
    const n = await ue({ id: a });
    for (const o in n) n[o] ? n["boll" + o] = true : n["boll" + o] = false;
    return n;
  }
  async function J(a) {
    const n = await de({ id: a });
    for (const o in n) n[o] ? n["boll" + o] = true : n["boll" + o] = false;
    return n;
  }
  async function Y(a) {
    console.log(a, "获取供应商详情");
    const n = await me({ id: a });
    for (const o in n) n[o] ? n["boll" + o] = true : n["boll" + o] = false;
    return n;
  }
  async function x({ tabType: a, formData: n, countryType: o }) {
    try {
      switch (a) {
        case u.FIRM_RECORD_CONFIG.K:
          await ie(Object.assign(n, { crmCountryTypeEnum: o }));
          break;
        case u.GOVERNMENT_RECORD_CONFIG.K:
          await le(n);
          break;
        case u.PROJECT_SIGN_IN_CONFIG.K:
          await oe(Object.assign(n, { crmCountryTypeEnum: o }));
          break;
        case u.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K:
          await fe(n);
          break;
        case u.SUPPLIER_INTO_RECORD_CONFIG.K:
          await ce(n);
          break;
      }
    } catch (t) {
      throw console.log(t, "提交表单"), t;
    }
  }
  async function W({ tabType: a, formData: n, countryType: o }) {
    try {
      switch (a) {
        case u.PROJECT_SIGN_IN_CONFIG.K:
          await ae(Object.assign(n, { crmCountryTypeEnum: o }));
          break;
      }
    } catch (t) {
      throw console.log(t, "修改提交表单"), t;
    }
  }
  return { formItemList: l, serchFormDetail: D, fetchFormItemList: K, submitForm: x, submitEditForm: W, fetchFormDetail: B };
}
export {
  Ee as a,
  ke as b,
  ye as c,
  he as d,
  Ce as e,
  Se as f,
  Te as g,
  Re as h,
  be as i,
  _e as j,
  Pe as k,
  De as l,
  Ge as m,
  Ae as n,
  Ne as o,
  Ie as p,
  Fe as q,
  we as s,
  Ve as u
};
